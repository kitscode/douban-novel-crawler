package org.kitscode.crawler;

import org.kitscode.base.BaseCrawler;
import org.kitscode.base.BaseTask;
import org.kitscode.task.LinkTask;

/**
 * @author kevin
 * @date 2018年3月19日
 */
public class LinkCrawler extends BaseCrawler {

	public LinkCrawler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LinkCrawler(BaseTask task) {
		super(task);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crawl() throws Exception {
		LinkTask task=(LinkTask)super.task;
		task.getPage();
		System.out.println("222");
	}
}
