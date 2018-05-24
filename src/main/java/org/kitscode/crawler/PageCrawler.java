package org.kitscode.crawler;

import java.util.Date;

import org.kitscode.base.BaseCrawler;
import org.kitscode.base.BaseTask;
import org.kitscode.model.LinkTask;
import org.kitscode.model.PageTask;
import org.kitscode.util.DB;
import org.nutz.dao.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kevin
 * @date 2018年3月19日
 */
public class PageCrawler extends BaseCrawler {
	private static Logger logger = LoggerFactory.getLogger(PageCrawler.class);
	private Dao dao=DB.getDao();

	public PageCrawler(BaseTask task) {
		super(task);
	}

	@Override
	public void crawl() throws Exception {
		task = (PageTask) super.task;
		String url=task.getUrl();
		//分100页
		for (int i = 0; i < 100; i++) {
			String page_url=url.replaceFirst("start=\\d+","start="+20*i);
			LinkTask link=new LinkTask();
			link.setUrl(page_url);
			link.setPage(i+1);
			link.setData_id(task.getData_id());
			link.setStorage_time(new Date());
			dao.fastInsert(link);
		}
	}

}
