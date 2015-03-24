package com.xiaotian.frameworkxt.net;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version 1.0.0
 * @author XiaoTian
 * @name HttpAction
 * @description Http Action Annotation
 * @date 2013-12-24
 * @link gtrstudio@qq.com
 * @copyright Copyright © 2010-2013 小天天 Studio, All Rights Reserved.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface HttpAction {
	public static final String DEFAULT = "DEFAULT";
	public static final String METHOD_GET = "GET";
	public static final String METHOD_POST = "POST";

	public String serverName() default DEFAULT;

	public abstract String action() default "http://www.default.com";

	public String serverPort() default DEFAULT;

	public String value() default DEFAULT; // url http://servername:port/path

	public String method() default METHOD_GET;

}
