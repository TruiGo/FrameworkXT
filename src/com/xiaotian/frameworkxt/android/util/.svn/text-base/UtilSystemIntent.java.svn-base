package com.xiaotian.frameworkxt.android.util;

import java.io.File;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;

public class UtilSystemIntent {

	// 选择发送 Email
	public static void sendEmailIntent(Context context, String[] receiveEmail, String intentTitle, String emailSubject, String emailBody) {
		Intent msg = new Intent(Intent.ACTION_SEND);
		msg.putExtra(Intent.EXTRA_EMAIL, receiveEmail);
		msg.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
		msg.putExtra(Intent.EXTRA_TEXT, emailBody);
		msg.setType("message/rfc822"); // 消息
		context.startActivity(Intent.createChooser(msg, intentTitle));
	}

	// Android市场下载 APP
	public static void downloadAPPFromMarket(Context context, String packageName) {
		Uri uri = Uri.parse(String.format("market://details?id=?", packageName));
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		try {
			context.startActivity(intent);
		} catch (ActivityNotFoundException e) {
			Toast.makeText(context, "Market not installed", Toast.LENGTH_SHORT).show();
		}
	}

	// 剪切照片
	public static void cropImage(Context context, String imagePath, String savePath, int imageWidth, int imageHeight) {
		File fileTo = new File(savePath);
		File fileFrom = new File(imagePath);
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setData(Uri.fromFile(fileFrom));
		intent.putExtra("crop", "true");
		intent.putExtra("scale", true);
		// this defines the aspect ration
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		// this defines the output bitmap size
		intent.putExtra("outputX", 60);
		intent.putExtra("outputY", 60);
		// true to return a Bitmap, false to directly save the cropped iamge
		intent.putExtra("return-data", false);
		// save output image in uri
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(fileTo));
		context.startActivity(intent);
	}

	// 打电话
	public static void dialing(Context context, String phoneNumber) {
		Uri callUri = Uri.parse("tel:" + phoneNumber);
		Intent intent = new Intent(Intent.ACTION_DIAL, callUri);
		context.startActivity(intent);
	}

	// 发短信
	public static void sendSMS(Context context, String phoneNumber, String sms) {
		Uri callUri = Uri.parse("sms:" + phoneNumber);
		Intent intent = new Intent(Intent.ACTION_VIEW, callUri);
		intent.putExtra("sms_body", sms);
		intent.setType("vnd.android-dir/mms-sms");
		context.startActivity(intent);
	}

	// 安装APK
	public static void installingAPK(Context context, File apkFile) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
		context.startActivity(intent);
	}
}
