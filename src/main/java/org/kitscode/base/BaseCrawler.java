package org.kitscode.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author kevin
 * @date 2018年3月19日
 */
public abstract class BaseCrawler extends Thread {
	private static Logger logger = LoggerFactory.getLogger(BaseCrawler.class);
//	private Dao dao=DB.getDao();

	BaseTask task;
	public BaseCrawler(){
	}
	
	public BaseCrawler(BaseTask task) {
		this.task=task;
	}
	
	@Override
	public void run(){
		String task_name=task.toString();
		System.out.println(">>>>>>>>>>"+task_name);
//		dao.update(task, Chain.make("status",1), Cnd.where("id", "=",((BaseTask)task).getId()));
//		logger.info("#########"+task_name+"任务开始#########");
		try {
			crawl();
			//dao.update(SherpaRequest.class, Chain.make("status",2), Cnd.where("id", "=",task.getId()));
//			logger.info("#########"+task_name+"任务结束#########");
		} catch (Exception e) {
//			logger.error("#########"+task_name+"解析异常#########");
			e.printStackTrace();
			//dao.update(SherpaRequest.class, Chain.make("status",3), Cnd.where("id", "=",task.getId()));		
		}
	}
	public abstract void crawl() throws Exception;
	
}