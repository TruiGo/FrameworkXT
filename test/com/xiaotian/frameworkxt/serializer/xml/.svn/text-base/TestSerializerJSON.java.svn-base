package com.xiaotian.frameworkxt.serializer.xml;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.xiaotian.frameworkxt.common.MyOut;
import com.xiaotian.frameworkxt.serializer.json.JSONEntity;
import com.xiaotian.frameworkxt.serializer.json.JSONField;
import com.xiaotian.frameworkxt.serializer.json.JSONSerializer;
import com.xiaotian.frameworkxt.serializer.json.JSONSerializingException;

public class TestSerializerJSON {
	public static void main(String[] args) {
		String jsonString = "{success=true,message='success',resultCode=1,header={status=2,message='success'},body=[{name='zhangsan',phone='15936562361',loginDate='2014-5-6',id='56',isMaster=false},{name='liming',phone='15965623612',loginDate='2014-5-20',id='58',isMaster=true},{name='咳咳',phone='13425623610',loginDate='2013-5-36',id='51',isMaster=false}]}";
		JSONSerializer mJSONSerializer = new JSONSerializer();
		JSONTokener mJSONTokener = new JSONTokener(jsonString);
		try {
			JSONObject jsonRoot;
			JSONObject jsonHeader;
			JSONArray jsonBody;
			// JsonString -> Json Serializing
			jsonRoot = (JSONObject) mJSONTokener.nextValue();
			jsonHeader = jsonRoot.getJSONObject("header");
			jsonBody = jsonRoot.getJSONArray("body");
			// Json Object -> Entity Object
			Header header = mJSONSerializer.deSerialize(jsonHeader, Header.class);
			List<Person> listPerson = mJSONSerializer.deSerialize(jsonBody, Person.class);
			//
			MyOut.infoClassField(jsonRoot);
			MyOut.infoClassField(jsonHeader);
			MyOut.infoClassField(jsonBody);
			//
			MyOut.infoClassField(header);
			MyOut.infoClassField(listPerson);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (JSONSerializingException e) {
			e.printStackTrace();
		}
	}

	@JSONEntity
	public static class Header {
		@JSONField("message")
		String message;
		@JSONField("status")
		Integer status;
	}

	@JSONEntity
	public static class Person {
		@JSONField("id")
		Integer id;
		@JSONField("name")
		String name;
		@JSONField("phone")
		String phone;
		@JSONField("loginDate")
		String loginDate;
		@JSONField("isMaster")
		Boolean isMaster;
	}
}
