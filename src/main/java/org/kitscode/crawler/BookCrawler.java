package org.kitscode.crawler;

import org.kitscode.base.BaseCrawler;
import org.kitscode.base.BaseTask;
import org.kitscode.task.PageTask;

/**
 * @author kevin
 * @date 2018年3月19日
 */
public class BookCrawler extends BaseCrawler{
	
	public BookCrawler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookCrawler(BaseTask task) {
		super(task);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crawl() throws Exception {
			System.out.println("333");
	}
}
