package com.xiaotian.frameworkxt.android.util;

import java.util.Set;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;

/**
 * @version 1.0.0
 * @author XiaoTian
 * @name UtilUseShareProperty
 * @description 用户共享数据工具
 * @date 2014-7-1
 * @link gtrstudio@qq.com
 * @copyright Copyright © 2010-2014 小天天 Studio, All Rights Reserved.
 */
@SuppressLint("NewApi")
public class UtilUseShareProperty {
	public static final String KEY_LONG = "com.xiaotian.framework.util.long";
	public static final String KEY_FLOAT = "com.xiaotian.framework.util.float";
	public static final String KEY_STRING = "com.xiaotian.framework.util.string";
	public static final String KEY_BOOLEAN = "com.xiaotian.framework.util.boolean";
	public static final String KEY_INTEGER = "com.xiaotian.framework.util.integer";
	public static final String KEY_STRING_SET = "com.xiaotian.framework.util.string_set";
	//
	protected SharedPreferences preferences;
	protected Context context;

	//
	public UtilUseShareProperty(Context context) {
		this.context = context;
		preferences = PreferenceManager.getDefaultSharedPreferences(context);
	}

	// GET
	public boolean getBooleanValue(String... keyWord) {
		return preferences.getBoolean(keyWord.length > 0 ? keyWord[0] : KEY_BOOLEAN, false);
	}

	public String getStringValue(String... keyWord) {
		return preferences.getString(keyWord.length > 0 ? keyWord[0] : KEY_STRING, null);
	}

	public int getIntValue(String... keyWord) {
		return preferences.getInt(keyWord.length > 0 ? keyWord[0] : KEY_INTEGER, Integer.MIN_VALUE);
	}

	public float getFloatValue(String... keyWord) {
		return preferences.getFloat(keyWord.length > 0 ? keyWord[0] : KEY_FLOAT, Float.MIN_VALUE);
	}

	public long getLongValue(String... keyWord) {
		return preferences.getLong(keyWord.length > 0 ? keyWord[0] : KEY_LONG, Long.MIN_VALUE);
	}

	public Set<String> getStringSetValue(String... keyWord) {
		return preferences.getStringSet(keyWord.length > 0 ? keyWord[0] : KEY_STRING_SET, null);
	}

	public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
		preferences.registerOnSharedPreferenceChangeListener(listener);
	}

	public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
		preferences.registerOnSharedPreferenceChangeListener(listener);
	}

	// SET
	public Boolean setBooleanValue(Boolean value, String... keyWord) {
		Editor editor = preferences.edit();
		editor.putBoolean(keyWord.length > 0 ? keyWord[0] : KEY_BOOLEAN, value);
		// editor.apply(); // 缓冲到内存,异步保存磁盘
		// 同步保存数据到磁盘
		return editor.commit();
	}

	public Boolean setStringValue(String value, String... keyWord) {
		Editor editor = preferences.edit();
		editor.putString(keyWord.length > 0 ? keyWord[0] : KEY_STRING, value);
		return editor.commit();
	}

	public Boolean setIntValue(int value, String... keyWord) {
		Editor editor = preferences.edit();
		editor.putInt(keyWord.length > 0 ? keyWord[0] : KEY_INTEGER, value);
		return editor.commit();
	}

	public Boolean setFloatValue(float value, String... keyWord) {
		Editor editor = preferences.edit();
		editor.putFloat(keyWord.length > 0 ? keyWord[0] : KEY_FLOAT, value);
		return editor.commit();
	}

	public Boolean setLongValue(long value, String... keyWord) {
		Editor editor = preferences.edit();
		editor.putLong(keyWord.length > 0 ? keyWord[0] : KEY_LONG, value);
		return editor.commit();
	}

	public Boolean setStringSetValue(Set<String> value, String... keyWord) {
		Editor editor = preferences.edit();
		editor.putStringSet(keyWord.length > 0 ? keyWord[0] : KEY_STRING_SET, value);
		return editor.commit();
	}
}
