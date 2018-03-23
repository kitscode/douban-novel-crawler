package org.kitscode.crawler;

import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.kitscode.base.BaseCrawler;
import org.kitscode.base.BaseTask;
import org.kitscode.model.BookTask;
import org.kitscode.model.LinkTask;
import org.kitscode.util.Crawler;
import org.kitscode.util.DB;
import org.nutz.dao.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kevin
 * @date 2018年3月19日
 */
public class LinkCrawler extends BaseCrawler {
	private static Logger logger = LoggerFactory.getLogger(LinkCrawler.class);
	private Dao dao=DB.getDao();
	
	public LinkCrawler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LinkCrawler(BaseTask task) {
		super(task);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crawl() throws Exception {
		LinkTask task=(LinkTask)super.task;
		String url=task.getUrl();
		String html="";
		html=Crawler.getHtml(url);
		Document doc=Jsoup.parse(html);
		//获得图书列表
		Element book_list=doc.select("ul.subject-list").first();
		//遍历获得每本书的详情链接
		Elements books=book_list.select("li.subject-item");
		for (int i = 0; i < books.size(); i++) {
			Element book=books.get(i);
			String book_url=book.select("div.info>h2>a").attr("href");
			BookTask book_task=new BookTask();
			book_task.setData_id(task.getData_id());
			book_task.setStorage_time(new Date());
			book_task.setUrl(book_url);
			dao.fastInsert(book_task);
		}
	}
}
