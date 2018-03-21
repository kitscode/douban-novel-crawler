package org.kitscode.base;

import org.nutz.dao.entity.annotation.Column;

/**
 * @author kevin
 * @date 2018/2/26
 */
public class BaseTask extends BaseModel{
	@Column
	private int status;
	@Column
	private String url;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return this.getClass().getName();
	}
	
}
