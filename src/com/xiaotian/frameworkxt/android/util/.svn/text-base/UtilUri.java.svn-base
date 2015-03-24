package com.xiaotian.frameworkxt.android.util;

import android.net.Uri;

/**
 * @version 1.0.0
 * @author XiaoTian
 * @name UtilUri
 * @description Uri Util
 * @date 2014-7-8
 * @link gtrstudio@qq.com
 * @copyright Copyright © 2010-2014 小天天 Studio, All Rights Reserved.
 */
public class UtilUri {

	public Uri parse(String uriString, String... path) {
		Uri uri = Uri.parse(uriString);
		// 添加Path参数在URI的末尾,构造新的URI
		for (String p : path) {
			uri = Uri.withAppendedPath(uri, p);
		}
		return uri;
	}

	public Uri withAppendedPath(Uri uri, String... path) {
		for (String p : path) {
			uri = Uri.withAppendedPath(uri, p);
		}
		return uri;
	}
}
