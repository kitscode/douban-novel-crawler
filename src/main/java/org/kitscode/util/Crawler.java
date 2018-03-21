package org.kitscode.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author kevin
 * @date 2018/2/23/
 */
public class Crawler {
	//Connection打开流的方式
	public static String getHtml0(String url,String charSet) {
		if(charSet==null)
			charSet="UTF-8";
		BufferedReader in = null;
		StringBuffer result = null;
		URL real_url;
		try {
			real_url = new URL(url);
			URLConnection conn = real_url.openConnection();
			conn.connect();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream(),charSet));
			result = new StringBuffer();
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		// System.out.println(result);
		return result.toString();
	}
	
	//HttpClient
	public static String getHtml(String url,String charSet) throws Exception{
		CloseableHttpClient http_client=HttpClients.createDefault();
		HttpGet get=new HttpGet(url);
		CloseableHttpResponse response = http_client.execute(get);
		HttpEntity entity = response.getEntity();
		String html=EntityUtils.toString(entity);
		response.close();
		http_client.close();
		return html;
	}
	
	public static String getHtml(String url) throws Exception{
		return getHtml(url, null);
	}
}
