package com.xiaotian.frameworkxt.serializer.xml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xiaotian.frameworkxt.common.MyOut;

public class TestSerializerXML {

	public static void main(String[] args) {
		XMLSerializer mXMLSerializer = new XMLSerializer();
		String xmlString = "<?xml version='1.0' encoding='utf-8' standalone='yes' ?><operation_response><msgheader><au_token>autoken001</au_token><req_token>reqtoken001</req_token><req_bkenv>00</req_bkenv><req_uploadurl>http://192.168.1.150:66/junyongpic/</req_uploadurl><retinfo><rettype>0</rettype><retcode>0</retcode><retmsg>读取成功！</retmsg></retinfo></msgheader><msgbody><msgchild><procaid>1</procaid><procano>1</procano><procaname>纸皮</procaname><procalogoid>644</procalogoid><procalogopicurl>http://192.168.1.150:66/junyongpic/20141124143714552BT3.jpg</procalogopicurl></msgchild><msgchild><procaid>2</procaid><procano>2</procano><procaname>花纸</procaname><procalogoid>645</procalogoid><procalogopicurl>http://192.168.1.150:66/junyongpic/20141125100112990gS.jpg</procalogopicurl></msgchild><msgchild><procaid>145</procaid><procano>3</procano><procaname>办公室废纸</procaname><procalogoid>646</procalogoid><procalogopicurl>http://192.168.1.150:66/junyongpic/201411251345142777Jb.jpg</procalogopicurl></msgchild><msgchild><procaid>150</procaid><procano>4</procano><procaname>纸筒</procaname><procalogoid>650</procalogoid><procalogopicurl>http://192.168.1.150:66/junyongpic/20141125143938273t7e.jpg</procalogopicurl></msgchild><msgchild><procaid>147</procaid><procano>5</procano><procaname>卡纸</procaname><procalogoid>648</procalogoid><procalogopicurl>http://192.168.1.150:66/junyongpic/20141125140633340G.jpg</procalogopicurl></msgchild><msgchild><procaid>146</procaid><procano>6</procano><procaname>白纸</procaname><procalogoid>647</procalogoid><procalogopicurl>http://192.168.1.150:66/junyongpic/2014112514023060566.jpg</procalogopicurl></msgchild><msgchild><procaid>149</procaid><procano>7</procano><procaname>报纸</procaname><procalogoid>649</procalogoid><procalogopicurl>http://192.168.1.150:66/junyongpic/20141125140931468TEu.jpg</procalogopicurl></msgchild><result>success</result><message>读取成功！</message></msgbody></operation_response>";
		Map<String, Class<?>> mappedClass = new HashMap<String, Class<?>>();
		mappedClass.put("operation_response", XMLDocumentation.class);
		mappedClass.put("msgheader", Header.class);
		mappedClass.put("retinfo", HeaderInfo.class);
		mappedClass.put("msgbody", Body.class);
		mappedClass.put("msgchild", Item.class);
		try {
			XMLDocumentation doc = mXMLSerializer.deSerializeXMLDocumentation(xmlString, mappedClass);
			Header header = doc.get("msgheader");
			HeaderInfo headerInfo = (HeaderInfo) header.get().get(0);
			Body body = doc.get("msgbody");
			List<Item> listData = body.get();
			//
			MyOut.infoClassField(header);
			MyOut.infoClassField(headerInfo);
			//
			MyOut.infoClassField(body);
			MyOut.infoClassField(listData);

		} catch (XMLSerializingException e) {
			MyOut.printStackTrace(e);
		}
	}

	// 容器
	@XMLEntity(name = "msgheader")
	public static class Header extends XMLDocumentation.XMLElementContainer {
		@XMLElement(name = "au_token")
		String auToken;
		@XMLElement(name = "message")
		String message;
		@XMLElement(name = "req_uploadurl")
		String reqUrl;
	}

	@XMLEntity(name = "msgbody")
	public static class Body extends XMLDocumentation.XMLElementContainer {
		@XMLElement(name = "result")
		String result;
		@XMLElement(name = "message")
		String message;
	}

	// 实体
	@XMLEntity("retinfo")
	public static class HeaderInfo {
		@XMLElement("rettype")
		String retType;
		@XMLElement("retcode")
		String retCode;
		@XMLElement("retmsg")
		String retMessage;
	}

	@XMLEntity("msgchild")
	public static class Item {
		@XMLElement("procaid")
		Integer id;
		@XMLElement("procano")
		String no;
		@XMLElement("procaname")
		String name;
		@XMLElement("procalogoid")
		Integer logoId;
		@XMLElement("procalogopicurl")
		String logoUrl;
	}
}
