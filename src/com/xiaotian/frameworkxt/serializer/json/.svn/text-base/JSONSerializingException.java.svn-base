package com.xiaotian.frameworkxt.serializer.json;

/**
 * @version 1.0.0
 * @author XiaoTian
 * @name JSONSerializingException
 * @description JSON异常
 * @date 2014-4-15
 * @link gtrstudio@qq.com
 * @copyright Copyright © 2010-2014 小天天 Studio, All Rights Reserved.
 */
public class JSONSerializingException extends Exception {
	private static final long serialVersionUID = 1L;
	public static final int UNSUPEREXCEPTION = 0X001;
	public static final int FIELDEXCEPTION = 0X002;
	public static final int JSONEXCEPTION = 0X003;

	public JSONSerializingException(int key) {
		super(exceptionMessage(key));
	}

	public JSONSerializingException(int key, Throwable e) {
		super(exceptionMessage(key), e);
	}

	public static String exceptionMessage(int key) {
		switch (key) {
		case UNSUPEREXCEPTION:
			return "Un supper the class json serializable,be sure the serialized class has mapping by @JSONSerialize!";
		case FIELDEXCEPTION:
			return "When pass the class field exception,be sure the class's field has mapping by @JSONField or the field's type is Object";
		case JSONEXCEPTION:
			return "When excute the class data translate to json data cause exception!";
		}
		return "Un Deceal Exception!";
	}
}
