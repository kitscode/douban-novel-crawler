package org.kitscode.model;

import org.kitscode.base.BaseModel;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

/**
 * @author kevin
 * @date 2018/2/26
 */
@Table("book_info")
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
