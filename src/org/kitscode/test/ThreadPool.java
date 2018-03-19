package org.kitscode.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.kitscode.crawler.PageCrawler;

/**
 * @author kevin
 * @date 2018年3月19日
 */
public class ThreadPool {
	@Test
	public void pool() throws Exception {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(1), new ThreadPoolExecutor.DiscardPolicy());
		pool.execute(new PageCrawler());
		pool.execute(new PageCrawler());
		pool.execute(new PageCrawler());
		pool.execute(new PageCrawler());
		pool.execute(new PageCrawler());
	}
}
