package com.arrayprolc.se.texthandler;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Web {

	public static void download(String url, String loc)
			throws MalformedURLException, IOException {
		java.io.BufferedInputStream in = new java.io.BufferedInputStream(
				new java.net.URL(url).openStream());
		java.io.FileOutputStream fos = new java.io.FileOutputStream(loc);
		java.io.BufferedOutputStream bout = new BufferedOutputStream(fos);
		byte data[] = new byte[1024];
		int read;
		while ((read = in.read(data, 0, 1024)) >= 0) {
			bout.write(data, 0, read);
		}
		bout.close();
		in.close();
	}

	public static String get(String webPage) {
		String text = null;
		try {
			URL url = new URL(webPage);
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			int numRead;
			char[] charArray = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numRead = isr.read(charArray)) > 0) {
				sb.append(charArray, 0, numRead);
			}
			text = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return text;

	}

}
