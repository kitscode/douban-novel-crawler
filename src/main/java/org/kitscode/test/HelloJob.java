package org.kitscode.test;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author kevin
 * @date 2018年3月21日
 */
public class HelloJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("hello");
	}
	
}
