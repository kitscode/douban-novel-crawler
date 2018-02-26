package model;

import org.nutz.dao.entity.annotation.Column;

import base.BaseModel;

/**
 * @author kevin
 * @date 2018/2/26
 */
public class BookInfo extends BaseModel {
	@Column
	private String name;
	@Column
	private String area;
	@Column
	private String author;
	@Column
	private String press;
	@Column
	private String publish_time;
	@Column
	private float price;
	@Column
	private float score;
	@Column
	private int comment_sum;
	@Column
	private String description;
}
