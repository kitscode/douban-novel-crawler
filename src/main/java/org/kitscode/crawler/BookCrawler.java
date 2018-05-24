package org.kitscode.crawler;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.kitscode.base.BaseCrawler;
import org.kitscode.base.BaseTask;
import org.kitscode.model.BookInfo;
import org.kitscode.model.BookTask;
import org.kitscode.util.Crawler;
import org.kitscode.util.DB;
import org.kitscode.util.Utils;
import org.nutz.dao.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kevin
 * @date 2018年3月19日
 */
public class BookCrawler extends BaseCrawler{
	private static Logger logger = LoggerFactory.getLogger(BookCrawler.class);
	private Dao dao=DB.getDao();

	
	public BookCrawler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookCrawler(BaseTask task) {
		super(task);
		// TODO Auto-generated constructor stub
	}

	public void crawl() throws Exception {
		BookTask task=(BookTask)super.task;
		String url=task.getUrl();
		String html="";
		html=Crawler.getHtml(url);
		Document doc=Jsoup.parse(html);
		
		//获得信息域
		Element info_ele=doc.select("div#info").first();
		//书名v:itemreviewed
		String name=doc.select("span[property=v:itemreviewed]").text();
		logger.info("######### 正在解析《"+name+"》 ##########");
		//地区&作者
		String area_author=info_ele.select("a").first().text();
		String area=Utils.regex("\\[(.*)\\]",area_author);
		String author=Utils.regex("\\](.*)", area_author).trim();
		if(StringUtils.isBlank(author))
			author=area_author;
		//译者
		Element translator_ele=info_ele.select("span:contains(译者)").first();
		String translator="";
		if(translator_ele!=null){
			Elements translator_list=translator_ele.select("a");
			for (int i = 0; i < translator_list.size(); i++) {
				Element e=translator_list.get(i);
				if(i!=translator_list.size()-1)
					translator+=e.text()+"/";
				else
					translator+=e.text();
			}
		}
		
		//评分
		String score_str=doc.select("strong.ll.rating_num").text();
		float score=Float.parseFloat(score_str);
		//评论数
		String comment_count_str=doc.select("span[property=v:votes]").text();
		int comment_count = Integer.parseInt(comment_count_str);
		//tags
		Elements tags_eles=doc.select("a.tag");
		String tags="";
		for (int i = 0; i < tags_eles.size(); i++) {
			Element tag=tags_eles.get(i);
			if(i!=tags_eles.size()-1)
				tags+=tag.text()+"/";
			else
				tags+=tag.text();
		}
		
		//以下数据不在标签内，用正则
		String info_str=info_ele.toString();
		//出版社
		String press=Utils.regex("出版社:</span>(.*)", info_str).trim();
		//原作名
		String original_name=Utils.regex("原作名:</span>(.*)", info_str).trim();
		//出版年
		String publish_time=Utils.regex("出版年:</span>(.*)", info_str).trim();
		//页数
		String pages_str=Utils.regex("页数:</span>(.*)", info_str).trim();
		int pages=Integer.parseInt(pages_str);
		//价格
		String price=Utils.regex("定价:</span>(.*)", info_str).trim();
		//ISBN
		String isbn=Utils.regex("ISBN:</span>(.*)", info_str).trim();
		
		
		//内容简介
		Elements eles=doc.select("div.intro");
		String description=eles.get(0).text();
		//作者简介
		String author_profile="";
		if(eles.size()>1)
			author_profile=eles.get(1).select("p").first().text();
		
		//入库
		BookInfo book=new BookInfo();
		book.setName(name);
		book.setArea(area);
		book.setAuthor(author);
		book.setPress(press);
		book.setOriginal_name(original_name);
		book.setTranslator(translator);
		book.setPublish_time(publish_time);
		book.setPages(pages);
		book.setPrice(price);
		book.setIsbn(isbn);
		book.setScore(score);
		book.setComment_count(comment_count);
		book.setDescription(description);
		book.setAuthor_profile(author_profile);
		book.setTags(tags);
		book.setData_id(task.getData_id());
		book.setStorage_time(new Date());
		book.setUrl(task.getUrl());
		dao.fastInsert(book);
		
	}
	
}
