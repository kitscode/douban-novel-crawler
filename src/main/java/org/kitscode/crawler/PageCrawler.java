package org.kitscode.crawler;

import org.kitscode.base.BaseCrawler;
import org.kitscode.base.BaseTask;

/**
 * @author kevin
 * @date 2018年3月19日
 */
public class PageCrawler extends BaseCrawler{
	
	public PageCrawler() {
		super();
	}
	
	public PageCrawler(BaseTask task) {
		super(task);
	}


	@Override
	public void crawl() throws Exception {
			System.out.println("111");
	}
	
}
