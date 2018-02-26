package base;

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
}
