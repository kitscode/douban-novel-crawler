package org.kitscode.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.nutz.dao.impl.NutDao;

/**
 * @author kevin
 * @date 2018年1月18日
 */
public class DB {
    
    public static NutDao getDao() {
        long t = System.currentTimeMillis();
        BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/db_novel?useUnicode=true&characterEncoding=utf-8&useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");
        NutDao dao = new NutDao(ds);
        System.out.println("连接数据库耗时：" + (System.currentTimeMillis() - t) + "毫秒");
        return dao;
    }
}
