package com.xiaotian.frameworkxt.android.util;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;

/**
 * 
 * @version 1.0.0
 * @author XiaoTian
 * @name UtilTextFace
 * @description Text 格式化
 * @date Nov 12, 2014
 * @link gtrstudio@qq.com
 * @copyright Copyright © 2009-2014 广州隽永贸易科技 Ltd, All Rights Reserved.
 */
public class UtilTextFace {
	// 对Text应用Span
	// 直接子类
	// BackgroundColorSpan, ClickableSpan, ForegroundColorSpan, MaskFilterSpan,
	// MetricAffectingSpan, RasterizerSpan, StrikethroughSpan, SuggestionSpan,
	// UnderlineSpan
	// 简介子类
	// AbsoluteSizeSpan, DynamicDrawableSpan, ImageSpan, LocaleSpan,
	// RelativeSizeSpan, ReplacementSpan, ScaleXSpan, StyleSpan, SubscriptSpan,
	// SuperscriptSpan, TextAppearanceSpan, TypefaceSpan, URLSpan

	// 颜色Span
	protected CharSequence getColorSpanText(String text) {
		ForegroundColorSpan colorSpan;
		SpannableString spannable = new SpannableString(text);
		int start = 2;
		int length = 3;
		colorSpan = new ForegroundColorSpan(UtilColor.randomColor());
		spannable.setSpan(colorSpan, start, start + length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 设置Span
		return spannable;
	}

	// 图片Span

	// 字体Span
	public static String getText(String nullAbleText) {
		return nullAbleText == null ? "" : nullAbleText;
	}

	// ClickAble TextView
	public static abstract class MyClickableSpan<T> extends ClickableSpan {
		// 设置CharSequence时必须设置TextView开启接受活动事件方法:
		// TextView.setMovementMethod(LinkMovementMethod.getInstance());
		T[] params;

		public MyClickableSpan(T... params) {
			this.params = params;
		}

		T getInitParam(int index) {
			return params[index];
		}

		@Override
		public void updateDrawState(TextPaint ds) {
			ds.setColor(ds.linkColor); // 设置Text颜色
			ds.setUnderlineText(true); // 设置Text下划线
		}
	}
}
