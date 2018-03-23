package org.kitscode.scheduler;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kevin
 * @date 2018年3月19日
 */
public class CrawlerPool {
	private static Map<String, ExecutorService> MAP = new Hashtable<String, ExecutorService>();

	public static ExecutorService getCrawlerPool(String crawler_name, int thread_count) {
		ExecutorService pool = null;
		pool = MAP.get(crawler_name);
		if (pool == null) {
			pool = Executors.newFixedThreadPool(thread_count); 
			MAP.put(crawler_name, pool);
		}
		return pool;
	}
}
