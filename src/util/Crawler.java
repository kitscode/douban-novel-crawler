package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author kevin
 * @date 2018/2/23/
 */
public class Crawler {
	public static String getHtml(String url) {
		BufferedReader in = null;
		StringBuffer result = null;
		URL real_url;
		try {
			real_url = new URL(url);
			URLConnection conn = real_url.openConnection();
			conn.connect();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
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
}
