package org.kitscode.base;


/**
 * @author kevin
 * @date 2018年3月19日
 */
public abstract class BaseCrawler extends Thread {
//	private Dao dao=DB.getDao();

	@Override
	public void run(){
		synchronized (this) {
			System.out.println("任务开始了");
			try {
				System.out.println("I am " + Thread.currentThread().getName());
				crawl();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	protected abstract void crawl() throws Exception;
}
