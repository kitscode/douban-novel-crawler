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
	@Column
	private String url;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getData_id() {
		return data_id;
	}
	public void setData_id(long data_id) {
		this.data_id = data_id;
	}
	public Date getStorage_time() {
		return storage_time;
	}
	public void setStorage_time(Date storage_time) {
		this.storage_time = storage_time;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
