package org.kitscode.scheduler;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author kevin
 * @date 2018年3月22日
 */
public class QuartzMaster {
	
	public static void runIt(String task,int task_count,String crawler,int thread_count,String cron) throws SchedulerException{
		
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        JobDetail jb = JobBuilder.newJob(CrawlerJob.class).build();
        JobDataMap data=new JobDataMap();//用来传递和设置Job的详细参数
        data.put("task",task);
        data.put("task_count",task_count);
        data.put("thread_allpath",crawler);
        data.put("thread_count",thread_count);
        jb.getJobDataMap().putAll(data);
        
        long time=  System.currentTimeMillis() + 3*1000L; //3秒后启动
        Date statTime = new Date(time);

		Trigger t ;
		if(cron!=null){
			t = TriggerBuilder.newTrigger().startAt(statTime)
					.withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();//有cron调度的
		}else{
			t = TriggerBuilder.newTrigger().startAt(statTime)
					.withSchedule(SimpleScheduleBuilder.simpleSchedule()).build();//这个只执行一次
		}
		
        scheduler.scheduleJob(jb, t);//有了JobDetail和Trigger，就可以开启任务了~
        scheduler.start();
        System.out.println("######### 爬虫启动 ########### 启动时间 ： " + new Date());
	}
}
