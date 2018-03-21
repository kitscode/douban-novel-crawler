package org.kitscode;

import java.util.concurrent.ExecutorService;

import org.kitscode.crawler.BookCrawler;
import org.kitscode.crawler.LinkCrawler;
import org.kitscode.crawler.PageCrawler;
import org.kitscode.scheduler.CrawlerPool;
import org.kitscode.scheduler.Timer;

/**
 * @author kevin
 * @date 2018年3月19日
 */
public class Start {
	public static void main(String[] args) {
		//分页任务1个线程，抓链接3个线程，抓详情3个线程
		new PageCrawler().start();
		ExecutorService link_pool = CrawlerPool.getCrawlerPool("link",3);
		Timer.startTask(link_pool, new LinkCrawler(), 30);
		ExecutorService book_pool = CrawlerPool.getCrawlerPool("book",3);
	}
}
