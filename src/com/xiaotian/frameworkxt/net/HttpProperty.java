package com.xiaotian.frameworkxt.net;

/**
 * @version 1.0.0
 * @author XiaoTian
 * @name HttpMIME
 * @description Http Request Content Property Type And Value
 * @date 2014-4-2
 * @link gtrstudio@qq.com
 * @copyright Copyright © 2010-2014 小天天 Studio, All Rights Reserved.
 */
public class HttpProperty {
	public static final String PROPERTY_CAHRTSET = "Charsert";
	public static final String PROPERTY_CONNECTION = "Connection";
	public static final String PROPERTY_CONTENT_TYPE = "Content-Type";
	public static final String PROPERTY_TRANSFER_ENCODING = "Content-Transfer-Encoding";

	public static class MIME {
		// mime 1.0
		public static final String TEXT_PLAN = "text/plain";
		public static final String TEXT_HTML = "text/html";
		public static final String IMAGE_GIF = "image/gif";
		public static final String IMAGE_PNG = "image/png";
		public static final String IMAGE_JPG = "image/jpeg";
		public static final String VIDEO_MPEG = "video/mpeg";
		public static final String MESSAGE_RFC822 = "message/rfc822";
		public static final String APPLICATION_PDF = "application/pdf";
		public static final String APPLICATION_JSON = "application/json";
		public static final String APPLICATION_WORD = "application/msword";
		public static final String APPLICATION_XHTML = "application/xhtml+xml";
		public static final String APPLICATION_WAP_HTML_10 = "application/vnd.wap.xhtml+xml";
		public static final String APPLICATION_WAP_HTML_20 = "application/xhtml+xml";
		public static final String APPLICATION_STREAM = "application/octet-stream";
		public static final String MULTIPART_ALTERNATIVE = "multipart/alternative";
		public static final String MULTIPART_FORM_DATA = "multipart/form-data";
		public static final String APPLICATION_FORM_URLENCODEED = "application/x-www-form-urlencoded;charset=utf-8";
	}

	public static class TRANSFER_ENCODING {
		public static final String BIT_7 = "7bit"; // 7 BIT ASCII
		public static final String BIT_8 = "8bit"; // 8 BIT ASCII
		public static final String BINARY = "binary";
		public static final String BASE64 = "base64";
		public static final String QUOTED_PRINTABLE = "quoted-printable";
	}

	public static class CHARTSET {
		public static final String UTF_8 = "UTF-8";
	}

	public static class METHOD {
		public static final String POST = "POST";
		public static final String GET = "GET";

	}
}
