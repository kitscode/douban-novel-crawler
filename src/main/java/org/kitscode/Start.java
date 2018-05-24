package org.kitscode;

import org.kitscode.scheduler.QuartzMaster;
import org.quartz.SchedulerException;

/**
 * @author kevin
 * @date 2018年3月19日
 */
public class Start {
	public static void main(String[] args) throws SchedulerException {
		//分页，执行一次即可
		QuartzMaster.runIt("org.kitscode.model.PageTask", 1,"org.kitscode.crawler.PageCrawler", 1,null);
		//抓取每页所有图书链接，每20秒抓2个
		QuartzMaster.runIt("org.kitscode.model.LinkTask", 2,"org.kitscode.crawler.LinkCrawler", 2,"0/30 * * * * ?");
//		//抓取图书详情，每20秒抓5个
		QuartzMaster.runIt("org.kitscode.model.BookTask", 5,"org.kitscode.crawler.BookCrawler", 5,"0/20 * * * * ?");
	}
}
