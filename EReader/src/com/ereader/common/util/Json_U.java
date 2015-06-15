package com.ereader.common.util;

import com.google.gson.Gson;

/*****************************************
	 * 类描述： json数据 处理类
	 * 类名称：Json_U  
 	 * @version: 1.0
	 * @author: why
	 * @time: 2013-10-21 上午11:12:01 
******************************************/
public class Json_U {

	private Json_U() {
	}

	/**
	 * 
	 * @param jsonStr
	 *            待解析的json字符串
	 * @param clazz
	 *            待赋值的类
	 * @return T 异常则返回为null
	 */
	public static <T> T parseJsonToObj(String jsonStr, Class<T> clazz)  {
		try {
			Gson sGson = new Gson();
			return sGson.fromJson(jsonStr, clazz);
//			return JSON.parseObject(jsonStr, clazz);
		} catch (Exception e) {
			
		}
		return null;
	}

	/**
	 * 
	 * @param obj
	 *            待转换成json字符串的对象
	 * @return 异常返回为null
	 */

	public static String objToJsonStr(Object obj)  {
		try {
			Gson sGson = new Gson();
			return sGson.toJson(obj);
//			return JSON.toJSONString(obj);
		} catch (Exception e) {
			
		}
		return null;
	}
}
