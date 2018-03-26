package org.kitscode.model;

import org.kitscode.base.BaseTask;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Index;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.TableIndexes;

/**
 * @author kevin
 * @date 2018年3月21日
 * 状态4为没有内容的页面
 */
@Table("link_task")
@TableIndexes({@Index(name="unique_page",fields={"url"},unique=true)})
public class LinkTask extends BaseTask{
	@Column
	int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
}
