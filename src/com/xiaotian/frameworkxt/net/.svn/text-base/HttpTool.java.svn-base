package com.xiaotian.frameworkxt.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpTool {

	public static String sendRequest(String urlPath, String method, String params) throws HttpNetworkException {
		HttpURLConnection conn = null;
		OutputStream os = null;
		InputStream is = null;
		String result = null;
		URL url = null;
		try {
			url = new URL(urlPath);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod(method == null || method.equals("") ? "GET" : method);
			conn.setDoOutput((method != null && method.equals("POST")) ? true : false);
			conn.setReadTimeout(20 * 1000);
			conn.setConnectTimeout(20 * 1000);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			conn.setRequestProperty("Connection", "keep-alive");
			conn.setRequestProperty("Charsert", "UTF-8");
			String length = params == null ? "0" : String.valueOf(params.trim().getBytes().length);
			conn.setRequestProperty("Content-Length", length);
			if (params != null && !"".equals(params)) {
				os = conn.getOutputStream();
				os.write(params.getBytes());
				os.flush();
			}
			if (200 == conn.getResponseCode()) {
				is = conn.getInputStream();
				byte[] temp = readStream(is);
				result = new String(temp);
			}
		} catch (MalformedURLException e) {
			throw new HttpNetworkException(e);
		} catch (IOException e) {
			throw new HttpNetworkException(e);
		} catch (Exception e) {
			throw new HttpNetworkException(e);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				throw new HttpNetworkException(e);
			}
		}
		return result;
	}

	public static byte[] readStream(InputStream is) throws Exception {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		byte[] buffer = new byte[2048];
		int len = 0;
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		is.close();
		return os.toByteArray();
	}
}
