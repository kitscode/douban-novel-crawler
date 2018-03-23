package org.kitscode.scheduler;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.concurrent.ExecutorService;

import org.kitscode.base.BaseCrawler;
import org.kitscode.base.BaseTask;
import org.kitscode.util.DB;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kevin
 * @date 2018年3月22日
 */
public class CrawlerJob implements Job{
	private static Logger logger = LoggerFactory.getLogger(CrawlerJob.class);
	private Dao dao=DB.getDao();
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		JobDetail jobDetail = context.getJobDetail();
		String task = (String)jobDetail.getJobDataMap().get("task");
		int count=(int) jobDetail.getJobDataMap().get("task_count");
		String thread_allpath =(String)jobDetail.getJobDataMap().get("thread_allpath");
		int thread_count=(int)jobDetail.getJobDataMap().get("thread_count");
		
		try {
			Class<?> task_class = Class.forName(task);
			dao.update(task_class, Chain.make("status", 0), Cnd.where("status", "=", 1));
			List<BaseTask> task_list=(List<BaseTask>)dao.query(task_class, Cnd.where("status","=",0).limit(1,count));
			logger.info("\n########### "+getTaskName(task_class.toString())
					+":选中"+task_list.size()+"条记录,开始执行任务 ###########");
			runTask(task_list,thread_allpath,thread_count);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void runTask(List<BaseTask> task_list,String thread_allpath,int thread_count) {
		ExecutorService pool = CrawlerPool.getCrawlerPool(thread_allpath,thread_count);
		for (BaseTask task : task_list) {
			BaseCrawler crawler = null;
			Class<?> thread_class = null;
			try {
				thread_class = Class.forName(thread_allpath);
				Constructor<?> cs = thread_class.getConstructor(BaseTask.class);
				crawler = (BaseCrawler) cs.newInstance(task);
				pool.execute(crawler);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private String getTaskName(String all_path_name) {
			return all_path_name.substring(all_path_name.lastIndexOf(".")+1);
	}
}
