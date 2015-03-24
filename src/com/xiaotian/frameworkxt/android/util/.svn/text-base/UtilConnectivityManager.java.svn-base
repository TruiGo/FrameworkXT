package com.xiaotian.frameworkxt.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @version 1.0.0
 * @author XiaoTian
 * @name UtilConnectivityManager
 * @description 网络管理
 * @date Nov 24, 2014
 * @link gtrstudio@qq.com
 * @copyright Copyright © 2009-2014 广州隽永贸易科技 Ltd, All Rights Reserved.
 */
public class UtilConnectivityManager {
	//
	public boolean netWorkIsConnected(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		return activeNetwork != null && activeNetwork.getState() == NetworkInfo.State.CONNECTED;
	}
}
