package org.kitscode.util;

import org.junit.Test;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;

/**
 * @author kevin
 * @date 2018年3月19日
 */
public class CreateTable {
	@Test
	public void createTables() throws Exception {
		Dao dao=DB.getDao();
		System.out.println("####### 开始建表 ######");
		Daos.createTablesInPackage(dao, "org.kitscode.task", false);
		System.out.println("####### 建表成功 ######");
	}
}
