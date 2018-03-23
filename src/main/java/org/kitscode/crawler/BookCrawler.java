package org.kitscode.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.kitscode.base.BaseCrawler;
import org.kitscode.util.Crawler;

/**
 * @author kevin
 * @date 2018年3月19日
 */
public class BookCrawler extends BaseCrawler{
	/*
	public BookCrawler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookCrawler(BaseTask task) {
		super(task);
		// TODO Auto-generated constructor stub
	}*/

	@Test
	public void crawl() throws Exception {
//		BookTask task=(BookTask)super.task;
//		String url=task.getUrl();
		String url="https://book.douban.com/subject/26340138/";
		String html="";
		html=Crawler.getHtml(url);
		Document doc=Jsoup.parse(html);
		
		//获得信息域
		Element info_area=doc.select("div#info").first();
		//地区&作者
		String area_author=info_area.select("span:contains(作者)").text();
		System.out.println(area_author);
	}
}
