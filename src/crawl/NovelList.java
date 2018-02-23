package crawl;

import org.junit.Test;

import util.Crawler;

/**
 * @author kevin
 * @date 2018/2/22
 */
public class NovelList {
	@Test
	public void testName(){
		//https://book.douban.com/tag/小说
		String url="https://book.douban.com/tag/%E5%B0%8F%E8%AF%B4";
		System.out.println(Crawler.getHtml(url));
	}
}
