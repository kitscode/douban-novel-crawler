package org.kitscode.base;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;

/**
 * @author kevin
 * @date 2018/2/26
 */
public class BaseModel {
	@Id
	private long id;
	@Column
	private long data_id;
	@Column
	private Date storage_time;
	
}
