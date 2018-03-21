package org.kitscode.scheduler;

import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.kitscode.base.BaseCrawler;
import org.kitscode.base.BaseTask;
import org.kitscode.task.PageTask;

/**
 * @author kevin
 * @date 2018年3月21日
 */
public class Timer {
	public static void startTask(ExecutorService pool, String crawler_allpath,int wait_seconds) {
		BaseCrawler crawler = null;
		Class<?> crawler_class = null;
		try {
			crawler_class = Class.forName(crawler_allpath);
			Constructor<?> cs = crawler_class.getConstructor(BaseTask.class);
			PageTask task=new PageTask();
			task.setData_id(123);
			crawler = (BaseCrawler) cs.newInstance(task);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ScheduledExecutorService schedulePool = (ScheduledExecutorService) pool;
		// 5秒后执行，间隔wait_seconds后再执行
		schedulePool.scheduleAtFixedRate(crawler, 5, wait_seconds, TimeUnit.SECONDS);
	}
}