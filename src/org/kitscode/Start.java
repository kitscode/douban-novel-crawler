package org.kitscode;

import java.util.concurrent.ExecutorService;

import org.kitscode.crawler.BookCrawler;
import org.kitscode.crawler.LinkCrawler;
import org.kitscode.crawler.PageCrawler;
import org.kitscode.util.CrawlerPool;

/**
 * @author kevin
 * @date 2018年3月19日
 */
public class Start {
	public static void main(String[] args) {
		//1个1,3个2和3
		ExecutorService crawlerPool1 = CrawlerPool.getCrawlerPool(PageCrawler.class,1);
		crawlerPool1.execute(new PageCrawler());
		crawlerPool1.execute(new PageCrawler());
		crawlerPool1.execute(new PageCrawler());
		ExecutorService crawlerPool2 = CrawlerPool.getCrawlerPool(PageCrawler.class,3);
		crawlerPool2.execute(new LinkCrawler());
		ExecutorService crawlerPool3 = CrawlerPool.getCrawlerPool(PageCrawler.class,3);
		crawlerPool3.execute(new BookCrawler());
	}
}
