package org.kitscode.crawl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.kitscode.util.Crawler;

/**
 * @author kevin
 * @date 2018/2/22
 */
public class NovelList {
	@Test
	public void testName(){
		String url="https://book.douban.com/tag/小说";
		String html="";
		try {
			html=Crawler.getHtml(url);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("#######网络解析异常######");
		}
		Document doc=Jsoup.parse(html);
		//获得图书列表
		Element book_list=doc.select("ul.subject-list").first();
		//遍历获得每本书的详情链接
		Elements books=book_list.select("li.subject-item");
		for (int i = 0; i < books.size(); i++) {
			Element book=books.get(i);
			String book_url=book.select("div.info>h2>a").attr("href");
			System.out.println(book_url);
		}
	}
}
