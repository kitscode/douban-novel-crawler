package org.kitscode.base;

import org.kitscode.util.DB;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author kevin
 * @date 2018年3月19日
 */
public abstract class BaseCrawler extends Thread {
	private static Logger logger = LoggerFactory.getLogger(BaseCrawler.class);
	private Dao dao=DB.getDao();

	public BaseCrawler(){
	}
	
	protected BaseTask task;
	public BaseCrawler(BaseTask task) {
		this.task=task;
	}
	
	@Override
	public void run(){
		String task_name=task.getTaskName();
		dao.update(task.getClass(), Chain.make("status",1), Cnd.where("id", "=",((BaseTask)task).getId()));
		try {
			logger.info("#########"+task_name+"任务开始#########");
			crawl();
			dao.update(task.getClass(), Chain.make("status",2), Cnd.where("id", "=",task.getId()));
			logger.info("#########"+task_name+"任务结束#########");
		} catch (Exception e) {
			logger.error("#########"+task_name+"解析异常#########");
			e.printStackTrace();
			dao.update(task.getClass(), Chain.make("status",3), Cnd.where("id", "=",task.getId()));		
		}
	}
	
	public abstract void crawl() throws Exception;
}