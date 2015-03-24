package com.xiaotian.frameworkxt.net;

/**
 * @version 1.0.0
 * @author XiaoTian
 * @name HttpParam
 * @description Http Request Param Package
 * @date 2013-12-14
 * @link gtrstudio@qq.com
 * @copyright Copyright © 2010-2013 小天天 Studio, All Rights Reserved.
 */
public class HttpParam implements Cloneable {
	private String name;
	private String value;

	public HttpParam(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return getName() + "=" + getValue();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public int hashCode() {
		return name.hashCode() & value.hashCode();
	}
}
