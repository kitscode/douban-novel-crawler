package org.kitscode.crawler;

import org.kitscode.base.BaseCrawler;
import org.kitscode.base.BaseTask;
import org.kitscode.task.PageTask;

/**
 * @author kevin
 * @date 2018年3月19日
 */
public class PageCrawler extends BaseCrawler {

	public PageCrawler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageCrawler(BaseTask task) {
		super(task);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crawl() throws Exception {
		task = (PageTask) super.task;
		System.out.println("111"+task.getData_id());
	}

}
