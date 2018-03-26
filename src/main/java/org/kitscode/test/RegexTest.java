package org.kitscode.test;

import static org.junit.Assert.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.kitscode.util.Utils;

/**
 * @author kevin
 * @date 2018年3月26日
 */
public class RegexTest {
	@Test
	public void press() throws Exception {
		String info_str = "<div id=\"info\" class=\"\"> \n"
				+ " <span class=\"pl\">作者:</span>&nbsp; \n"
				+ " <a href=\"https://book.douban.com/author/256773/\"> [美] 加·泽文</a> \n"
				+ " <br> \n"
				+ " <span class=\"pl\">出版社:</span> 江苏凤凰文艺出版社\n"
				+ " <br> \n"
				+ " <span class=\"pl\">原作名:</span> The Storied Life of A. J. Fikry\n"
				+ " <br> \n"
				+ " <span> <span class=\"pl\"> 译者</span>: <a class=\"\" href=\"/search/%E5%AD%99%E4%BB%B2%E6%97%AD\">孙仲旭</a> / <a class=\"\" href=\"/search/%E6%9D%8E%E7%8E%89%E7%91%B6\">李玉瑶</a> </span>\n"
				+ " <br> \n"
				+ " <span class=\"pl\">出版年:</span> 2015-5-1\n"
				+ " <br> \n"
				+ " <span class=\"pl\">页数:</span> 271\n"
				+ " <br> \n"
				+ " <span class=\"pl\">定价:</span> CNY 35.00\n"
				+ " <br> \n"
				+ " <span class=\"pl\">装帧:</span> 平装\n"
				+ " <br> \n"
				+ " <span class=\"pl\">丛书:</span>&nbsp;\n"
				+ " <a href=\"https://book.douban.com/series/34361\">读客全球顶级畅销小说文库：加·泽文作品</a>\n"
				+ " <br> \n"
				+ " <span class=\"pl\">ISBN:</span> 9787539971810\n"
				+ " <br> \n" + "</div>";
		String press=Utils.regex("出版社:</span>(.*)", info_str).trim();
		System.out.println(press);
	}
	
}
