package org.kitscode.scheduler;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
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
public class QuartzManager {
	
	public static void main(String[] args) throws SchedulerException{
		
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        JobDetail jb = JobBuilder.newJob(CrawlerJob.class)
                .withDescription("org.kitscode.task.PageTask") 
                .build();

        long time=  System.currentTimeMillis() + 5*1000L; //5秒后启动任务
        Date statTime = new Date(time);

        Trigger t = TriggerBuilder.newTrigger()
                    .startAt(statTime)
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")) //两秒执行一次
                    .build();

        //5.注册任务和定时器
        scheduler.scheduleJob(jb, t);

        //6.启动 调度器
        scheduler.start();
        System.out.println("启动时间 ： " + new Date());
	}
}
