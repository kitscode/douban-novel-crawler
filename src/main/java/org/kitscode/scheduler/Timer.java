package org.kitscode.scheduler;

import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.kitscode.base.BaseCrawler;
import org.kitscode.base.BaseTask;
import org.kitscode.task.PageTask;

/**
 * @author kevin
 * @date 2018年3月21日
 */
public class Timer {
	public static void startTask(ExecutorService pool,Runnable crawler, int seconds) {
		ScheduledExecutorService schedulePool = (ScheduledExecutorService) pool;
		//5秒后执行，间隔seconds后再执行
		schedulePool.scheduleAtFixedRate(crawler, 5, seconds,TimeUnit.SECONDS);
	}
	
	@Test
	public static void main(String a[]) throws Exception {
		Class<?> task_class=Class.forName("org.kitscode.crawler.PageCrawler");
		Constructor<?> cs = task_class.getConstructor(BaseTask.class);
		BaseCrawler crawler=(BaseCrawler)cs.newInstance(new PageTask());
		crawler.start();
	}
}
