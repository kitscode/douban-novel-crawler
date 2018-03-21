package org.kitscode.task;

import org.kitscode.base.BaseTask;
import org.nutz.dao.entity.annotation.Table;

/**
 * @author kevin
 * @date 2018年3月21日
 */
@Table("link_task")
public class LinkTask extends BaseTask{
	int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
}
