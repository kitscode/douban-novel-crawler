package org.kitscode.scheduler;

import org.kitscode.base.BaseTask;
import org.kitscode.util.DB;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;

/**
 * @author kevin
 * @date 2018年3月21日
 */
public class Tasker {
	
	//通过类名去相应的任务表中取一条空闲的任务
	public static BaseTask getTask(String task_allpath){
		Dao dao=DB.getDao();
		try {
			Class<?> task_class = Class.forName(task_allpath);
			BaseTask task=(BaseTask) dao.query(task_class, Cnd.where("status","=",0)).get(0);
			return task;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null; 
		}
	}
}
