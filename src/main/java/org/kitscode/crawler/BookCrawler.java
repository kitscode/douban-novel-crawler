package org.kitscode.crawler;

import org.kitscode.base.BaseCrawler;
import org.kitscode.task.PageTask;

/**
 * @author kevin
 * @date 2018年3月19日
 */
public class BookCrawler extends BaseCrawler{
	PageTask task;
	public BookCrawler(PageTask task) {
		super(task);
	}
	
	@Override
	public void crawl() throws Exception {
			System.out.println("333");
	}
}
