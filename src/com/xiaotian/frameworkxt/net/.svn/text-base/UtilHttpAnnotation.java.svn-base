package com.xiaotian.frameworkxt.net;

import java.lang.reflect.Method;

/**
 * @version 1.0.0
 * @author XiaoTian
 * @name UtilHttpAnnotation
 * @description HTTP Annotation Util
 * @date 2014-5-27
 * @link gtrstudio@qq.com
 * @copyright Copyright © 2010-2014 小天天 Studio, All Rights Reserved.
 */
public class UtilHttpAnnotation {
	public static HttpServer getHttpServer(Class<?> clazz) {
		while (clazz != null) {
			HttpServer annotationServer = clazz.getAnnotation(HttpServer.class);
			if (annotationServer != null) return annotationServer;
			clazz = clazz.getSuperclass();
		}
		return null;
	}

	public static HttpAction getInvokeHttpAction(Class<?> clazz, StackTraceElement[] stes) {
		Method methodInvoke = null;
		for (int i = 2; i < stes.length; i++) {
			StackTraceElement st = stes[i];
			methodInvoke = getMethodIgnoreParams(clazz, st.getMethodName());
			if (methodInvoke == null) continue;
			HttpAction annotationAction = methodInvoke.getAnnotation(HttpAction.class);
			if (annotationAction != null) return annotationAction;
		}
		throw new RuntimeException("@Action annotation exection. Can't found the action annotaion.");
	}

	public static Method getMethodIgnoreParams(Class<?> clazz, String name) {
		Method[] ms = getDecaredMethods(clazz);
		for (int i = 0; i < ms.length; i++) {
			if (ms[i].getName().equals(name)) return ms[i];
		}
		return null;
	}

	public static Method[] getDecaredMethods(Class<?> clazz) {
		return clazz.getMethods();
	}
}
