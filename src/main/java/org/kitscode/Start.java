package org.kitscode;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author kevin
 * @date 2018年3月19日
 */
public class Start {
	public static void main(String[] args) {
		//分页任务1个线程，抓链接3个线程，抓详情3个线程
		/*new PageCrawler().start();
		ExecutorService link_pool = CrawlerPool.getCrawlerPool("link",3);
		Timer.startTask(link_pool, new LinkCrawler(), 30);
		ExecutorService book_pool = CrawlerPool.getCrawlerPool("book",3);*/
		Logger logger=LoggerFactory.getLogger(Start.class);
		logger.info("??");
		logger.error("???????????");
	}
}
