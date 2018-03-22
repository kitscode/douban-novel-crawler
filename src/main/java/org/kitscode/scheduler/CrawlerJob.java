package org.kitscode.scheduler;

import org.kitscode.base.BaseTask;
import org.kitscode.util.DB;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author kevin
 * @date 2018年3月22日
 */
public class CrawlerJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Dao dao=DB.getDao();
		JobDetail jobDetail = context.getJobDetail();
		System.out.println(jobDetail.getJobDataMap());
		System.out.println(jobDetail.getDescription());
		System.out.println(jobDetail.getClass());
		System.out.println(jobDetail.getJobBuilder());
		System.out.println(jobDetail.getJobClass());
		System.out.println(jobDetail.getKey());
		
		
//		try {
//			Class<?> task_class = Class.forName("");
//			BaseTask task=(BaseTask) dao.query(task_class, Cnd.where("status","=",0)).get(0);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}
	
	
}
