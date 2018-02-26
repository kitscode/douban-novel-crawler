package model;

import org.nutz.dao.entity.annotation.Column;

import base.BaseTask;

/**
 * @author kevin
 * @date 2018/2/26
 */
public class BookTask extends BaseTask{
	@Column
	private String name;

}
