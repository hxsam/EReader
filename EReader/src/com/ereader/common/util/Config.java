package com.ereader.common.util;

import java.io.File;

import android.os.Environment;

/**
 * **************************************** 类描述： 配置信息类 类名称：Config
 * 
 * @version: 1.0
 * @author: why
 * @time: 2014-2-14 下午3:32:29
 ***************************************** 
 */
public class Config {

	/** 是否调试. */
	public final static boolean DEBUG = true;

	public final static String SECRET = "yidingying"; // 对称 测试

	// 开发环境
	// public final static String MY_SERVICE = "http://10.106.4.56:5050";
	// 测试环境
	public final static String MY_SERVICE = "http://10.106.4.154:7070";

	/** 临时文件保存路径. */
	// 下载包保存路径
	public static final String PATH_SDCARD = Environment
			.getExternalStorageDirectory().getAbsolutePath()
			+ File.separator
			+ "CreditWealth";
	// 更新APK
	public static final String PATH_UPDATE_APK = PATH_SDCARD + File.separator
			+ "Update";
	

	public final static String HTTP_USER_MOBLIE_LOGIN = MY_SERVICE
			+ "/p2puserController/p2puserLogin.action"; // 登录宜人贷接口

}