package org.kitscode.crawler;

import org.kitscode.base.BaseCrawler;
import org.kitscode.task.LinkTask;

/**
 * @author kevin
 * @date 2018年3月19日
 */
public class LinkCrawler extends BaseCrawler {
	LinkTask task;

	@Override
	public void crawl() throws Exception {
		task=(LinkTask)super.task;
		System.out.println("222");
	}
}
