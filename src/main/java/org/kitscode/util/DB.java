package org.kitscode.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.nutz.dao.impl.NutDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kevin
 * @date 2018年1月18日
 */
public class DB {
	private static Logger logger = LoggerFactory.getLogger(DB.class);
	private static NutDao dao;
	
    public static NutDao getDao() {
    	if(dao!=null)
    		return dao;
    	else{
    		long t = System.currentTimeMillis();
    		BasicDataSource ds = new BasicDataSource();
    		ds.setDriverClassName("com.mysql.jdbc.Driver");
    		ds.setUrl("jdbc:mysql://127.0.0.1:3306/db_novel?useUnicode=true&characterEncoding=utf-8&useSSL=false");
    		ds.setUsername("root");
    		ds.setPassword("root");
    		dao = new NutDao(ds);
    		logger.info("连接数据库耗时：" + (System.currentTimeMillis() - t) + "毫秒");
    		return dao;
    	}
    }
}
