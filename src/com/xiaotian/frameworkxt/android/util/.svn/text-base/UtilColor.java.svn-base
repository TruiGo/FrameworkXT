package com.xiaotian.frameworkxt.android.util;

import android.graphics.Color;

/**
 * @version 1.0.0
 * @author XiaoTian
 * @name UtilColor
 * @description Color Util
 * @date 2014-6-7
 * @link gtrstudio@qq.com
 * @copyright Copyright © 2010-2014 小天天 Studio, All Rights Reserved.
 */
public class UtilColor {
	public static int randomColor() {
		return Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
	}

	public static int rgb(int red, int green, int blue) {
		return Color.rgb(red, green, blue);
	}

	public static int rgb(int alpha, int red, int green, int blue) {
		return Color.argb(alpha, red, green, blue);
	}

	public static int parse(String colorString) {
		return Color.parseColor(colorString);

	}

	/**
	 * HSV 360度彩虹色环
	 */
	public static int rainbowColor(float current, float count) {
		// current 当前索引
		// count 最大索引
		float wheelPosition = current / count * 360.0f;
		return Color.HSVToColor(new float[] { wheelPosition, 1.0f, 1.0f });
	}
}
