package com.xiaotian.frameworkxt.util;

import it.sauronsoftware.base64.Base64;

/**
 * @version 1.0.0
 * @author XiaoTian
 * @name UtilBase64
 * @description Base 64 转码器
 * @date 2014-1-23
 * @link gtrstudio@qq.com
 * @copyright Copyright © 2010-2014 小天天 Studio, All Rights Reserved.
 */
public class UtilSecurity {
	private UtilRC4Encrypt rc4;

	// String -> Base64 String
	public String encodeUTF8ToBase64(String codeUTF8Data) {
		// TODO 源为UTF-8码进行Base64编码
		return Base64.encode(codeUTF8Data, "UTF-8");
	}

	// Base64 String - > String
	public String decodeBase64ToUTF8(String codeBase64Data) {
		// TODO 源为Base64解码为UTF-8
		return Base64.decode(codeBase64Data, "UTF-8");
	}

	public byte[] encodeByteToBase64Byte(byte[] byteData, int... start) {
		if (start.length > 0) {
			return Base64.encode(byteData, start[0]);
		} else {
			return Base64.encode(byteData);
		}
	}

	// String字符串 -> Base64 -> RC4 加密 [加密]
	public String encryptUTF8Base64RC4(String RC4Key, String encodeData) {
		return getUtilRC4(RC4Key).Encrypt(Base64.encode(encodeData, "UTF-8"));
	}

	// RC4加密字符串 -> 解密 -> Base64 -> String [解密]
	public String decryptUTF8RC4Base64(String RC4Key, String decodeData) {
		return Base64.decode(getUtilRC4(RC4Key).Decrypt(decodeData), "UTF-8");
	}

	UtilRC4Encrypt getUtilRC4(String key) {
		if (rc4 != null) return rc4;
		return rc4 = new UtilRC4Encrypt(key);
	}
}
