package org.kitscode;

import java.util.concurrent.ExecutorService;

import org.kitscode.scheduler.CrawlerPool;
import org.kitscode.scheduler.Timer;

/**
 * @author kevin
 * @date 2018年3月19日
 */
public class Start {
	public static void main(String[] args) {
		ExecutorService page_pool = CrawlerPool.getCrawlerPool("page",3);
		Timer.startTask(page_pool,"org.kitscode.crawler.PageCrawler", 5);
	}
}
