package org.kitscode.test;

import org.junit.Test;
import org.kitscode.base.BaseTask;
import org.kitscode.scheduler.Tasker;

/**
 * @author kevin
 * @date 2018年3月21日
 */
public class TaskTest {
	@Test
	public void testName() throws Exception {
		BaseTask task = Tasker.getTask("org.kitscode.task.PageTask");
		System.out.println(task.getData_id());
	}
}
