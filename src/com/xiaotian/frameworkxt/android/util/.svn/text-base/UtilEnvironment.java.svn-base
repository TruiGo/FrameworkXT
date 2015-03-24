package com.xiaotian.frameworkxt.android.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;

import com.xiaotian.frameworkxt.android.common.Mylog;

/**
 * @version 1.0.0
 * @author XiaoTian
 * @name UtilEnvironment
 * @description Environment Util By XiaoTian
 * @date 2014-4-15
 * @link gtrstudio@qq.com
 * @copyright Copyright © 2010-2014 小天天 Studio, All Rights Reserved.
 */
public class UtilEnvironment extends Environment {
	public static String externalStoragePathString = null;
	public static File externalStoragePath = null;

	/******************************************** Static Class Package Method ********************************************/
	public static List<ResolveInfo> getRunningMainLauncherAPP(Context context) {
		PackageManager pm = context.getPackageManager();
		Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
		mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		List<ResolveInfo> resolveInfo = pm.queryIntentActivities(mainIntent, PackageManager.MATCH_DEFAULT_ONLY);
		Collections.sort(resolveInfo, new ResolveInfo.DisplayNameComparator(pm));
		return resolveInfo;
	}

	public static List<ApplicationInfo> getInstalledAPP(Context context) {
		PackageManager pm = context.getPackageManager();
		List<ApplicationInfo> apps = pm.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
		Collections.sort(apps, new ApplicationInfo.DisplayNameComparator(pm));
		return apps;
	}

	/******************************************** Static Class APP Method ********************************************/
	// Action Bar Height
	public static int getActionBarHeight(Context context) {
		TypedValue tv = new TypedValue();
		if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
			return TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
		}
		return 0;
	}

	/******************************************** Static Class Environment Method ********************************************/
	// Android 4.0 Ever External Storage - External SDCard
	public static File getExternalStorageDirectory() {
		if (externalStoragePath != null) return externalStoragePath;
		try {
			// 扩展SD卡,从外挂载的系统文件截取
			String externalStoragePath = getExternalStoragePath();
			// 内部SD
			if (externalStoragePath == null) return Environment.getExternalStorageDirectory();
			File externalPath = new File(externalStoragePath);
			File tempExternalPathFile = new File(externalPath, "test.dat"); // 可以写访问,并创建
			if (tempExternalPathFile.createNewFile()) {
				// 截取的SD有效
				tempExternalPathFile.deleteOnExit();
				return externalPath;
			} else {
				// 截取的SD无效
				return Environment.getExternalStorageDirectory();
			}
		} catch (IOException e) {
			// 内部SD
			return Environment.getExternalStorageDirectory();
		}
	}

	public static String getSIMPhoneNumber(Context context) {
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return tm.getLine1Number();
	}

	// 根据挂载配置文件获取挂载的 SDCard[可能被篡改,不可用]
	private static String getExternalStoragePath() throws IOException {
		if (externalStoragePathString != null) return externalStoragePathString;
		String line;
		String sdCard = null;
		FileReader fr = null;
		BufferedReader br = null;
		String exts = Environment.getExternalStorageDirectory().getPath();
		try {
			// Mounts Config File
			fr = new FileReader(new File("/proc/mounts"));
			br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				if (line.contains("secure") || line.contains("asec")) continue;
				if (line.contains("fat")) { // TF Card
					String[] pars = line.split("\\s");
					if (pars.length < 2) continue;
					if (pars[1].equals(exts)) continue;
					sdCard = pars[1];
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fr.close();
			br.close();
		}
		return externalStoragePathString = sdCard;
	}

	protected static void getAllMountExternalStorage() throws IOException {
		Runtime runtime = Runtime.getRuntime();
		Process proc = runtime.exec("mount");
		InputStream is = proc.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		String line;
		String mount = new String();
		BufferedReader br = new BufferedReader(isr);
		while ((line = br.readLine()) != null) {
			Mylog.info(line);
			if (line.contains("secure")) continue;
			if (line.contains("asec")) continue;

			if (line.contains("fat")) {// TF card
				String columns[] = line.split(" ");
				if (columns != null && columns.length > 1) {
					mount = mount.concat("*" + columns[1] + "\n");
				}
			} else if (line.contains("fuse")) {// internal storage
				String columns[] = line.split(" ");
				if (columns != null && columns.length > 1) {
					mount = mount.concat(columns[1] + "\n");
				}
			}
		}
		Mylog.info(mount);
	}

	// 是否屏幕锁屏
	public static boolean isScreenOn(Context context) {
		PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
		return pm.isScreenOn();
	}

	// 唤醒屏幕
	public static void wakeLockScreen() {

	}

	// 解锁屏幕
	public static void unLockScreen() {

	}

	// 锁定屏幕
	public static void lockScreen() {

	}

	// The Application is available/can reachable the application
	public static boolean isAPPAvailable(Context context, String packageName) {
		PackageManager pm = context.getPackageManager();
		try {
			pm.getApplicationInfo(packageName, 0);
			return true;
		} catch (PackageManager.NameNotFoundException e) {
			return false;
		}
	}

	// 获取Environment 环境的硬件ID
	public static String getMachinecode(Context context) {
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return tm.getDeviceId();
	}

	// 程序信息,Application Info
	public static String getApplicationInfo(Context context) {
		return String.format("%s\n%s\n%s\n%s\n%s\n%s\n", getCountry(context), getBrandInfo(), getModeInfo(), getDeviceInfo(),
				getVersionInfo(context), getLocale(context));
	}

	// 屏幕亮度,Screen Brightness
	public static void changeScreenBrightness(Window window, float brightness) {
		WindowManager.LayoutParams params = window.getAttributes();
		params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
		params.screenBrightness = brightness; // 设置屏幕亮度[0.0-1.0]
		window.setAttributes(params);
	}

	// 主板信息
	public static String getBrandInfo() {
		return String.format("Brand: %s", Build.BRAND);
	}

	// 国家
	public static String getCountry(Context context) {
		TelephonyManager mTelephoneMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return String.format("Country: %s", mTelephoneMgr.getNetworkCountryIso());
	}

	public static String getDeviceInfo() {
		return String.format("Device: %s", Build.DEVICE);
	}

	// 型号
	public static String getModeInfo() {
		return String.format("Model: %s", Build.MODEL);
	}

	// 版本信息
	public static String getVersionInfo(Context context) {
		TelephonyManager mTelephoneMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return String.format("Version: %s", mTelephoneMgr.getDeviceSoftwareVersion());
	}

	// 所在地区
	public static String getLocale(Context context) {
		return String.format("Locale: %s", context.getResources().getConfiguration().locale.getDisplayName());
	}

	// 网络可用
	public static boolean networkAvailable(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		return (activeNetwork != null && activeNetwork.getState() == NetworkInfo.State.CONNECTED);
	}

	// WiFi网络
	public static boolean networkIsWiFi(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		if (activeNetwork != null && activeNetwork.getState() == NetworkInfo.State.CONNECTED) {
			WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
			return wifiManager.getWifiState() == WifiManager.WIFI_STATE_ENABLED;
		}
		return false;
	}

	public static String getCurrentVersionName(Context context, String... key) {
		String versionName = null;
		try {
			PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_CONFIGURATIONS);
			versionName = info.versionName;
			versionName = versionName.substring(0, 5);
		} catch (NameNotFoundException e) {
			Mylog.printStackTrace(e);
			versionName = "1.0.0";
		}
		if (key.length > 0) return key[0] + versionName;
		return versionName;
	}

	public static int getCurrentVersionCode(Context context) {
		int code = -1;
		try {
			PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_CONFIGURATIONS);
			code = info.versionCode;
		} catch (NameNotFoundException e) {
			Mylog.printStackTrace(e);
		}
		return code;
	}
}
