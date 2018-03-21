package org.kitscode.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.kitscode.crawler.LinkCrawler;
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
	}
	
	 public static void main(String[] args) {  
	        ScheduledExecutorService schedulePool = Executors.newScheduledThreadPool(5);  
	        // 5秒后执行任务，以后每2秒执行一次  
	        schedulePool.scheduleAtFixedRate(new PageCrawler(), 5, 2, TimeUnit.SECONDS);  
	        schedulePool.scheduleAtFixedRate(new LinkCrawler(), 5, 1, TimeUnit.SECONDS);  
	    }  
}
