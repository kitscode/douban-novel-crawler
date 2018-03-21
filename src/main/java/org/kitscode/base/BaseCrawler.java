package org.kitscode.base;

import org.apache.log4j.Logger;


/**
 * @author kevin
 * @date 2018年3月19日
 */
public class BaseCrawler extends Thread {
//	private static Logger logger = Logger.getLogger(BaseCrawler.class);
//	private Dao dao=DB.getDao();

	BaseTask task;
	public BaseCrawler(){
	}
	
	public BaseCrawler(BaseTask task) {
		this.task=task;
	}
	
	@Override
	public void run(){
		Logger logger = Logger.getLogger(BaseCrawler.class);
//		logger.info("#########任务开始#########");
		String task_name=task.toString();
		System.out.println(">>>>>>>>>>"+task_name);
		q();
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
	
	public void q(){
		System.out.println("qqqqqqqqq");
	}
	public void crawl() throws Exception {
		System.out.println(">>>>>>>>>base");
	};
}
