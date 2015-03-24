package com.xiaotian.frameworkxt.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.xiaotian.frameworkxt.common.MyOut;

public class TestPattern {
	public static void main(String[] args) {
		new TestPattern().matching();
	}

	void matching() {
		Pattern pattern = Pattern.compile("[0-9]{4,11}");
		Matcher m = pattern.matcher("【正在帮您找回密码,您的新密码为:012224（请勿转发泄密）");
		if (m.find()) {
			MyOut.info(m.group(0));

		}
	}
}
