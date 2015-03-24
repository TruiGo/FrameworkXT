package com.xiaotian.frameworkxt.android.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.Resources;

/**
 * @version 1.0.0
 * @author XiaoTian
 * @name UtilRawResource
 * @description Raw Bittery Resource
 * @date 2014-7-10
 * @link gtrstudio@qq.com
 * @copyright Copyright © 2010-2014 小天天 Studio, All Rights Reserved.
 */
public class UtilRawResource {
	// Read the files in : /res/xml/xxx.xml [R.raw.xxx]

	Context context;

	public UtilRawResource(Context context) {
		this.context = context;
	}

	String getStringFromRawFile(int rawResource) throws IOException {
		Resources r = context.getResources();
		InputStream is = r.openRawResource(rawResource);
		String myText = convertStreamToString(is);
		is.close();
		return myText;
	}

	String convertStreamToString(InputStream is) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i = is.read();
		while (i != -1) {
			baos.write(i);
			i = is.read();
		}
		return baos.toString();
	}
}
