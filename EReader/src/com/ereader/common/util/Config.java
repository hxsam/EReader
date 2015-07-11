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

	// 正式环境
	// public final static String MY_SERVICE = "http://10.106.4.56:5050";
	// 测试环境
	public final static String MY_SERVICE = "http://bookshop.0ett.com";

	/** 临时文件保存路径. */
	// 下载包保存路径
	public static final String PATH_SDCARD = Environment
			.getExternalStorageDirectory().getAbsolutePath()
			+ File.separator
			+ "CreditWealth";
	// 更新APK
	public static final String PATH_UPDATE_APK = PATH_SDCARD + File.separator
			+ "Update";
	

	public final static String HTTP_LOGIN = MY_SERVICE+ "/api/index/login"; // 登录接口
	public final static String HTTP_REGISTER = MY_SERVICE+ "/api/index/reg"; //注册接口
	public final static String HTTP_BOOK_FEATURED= MY_SERVICE+ "/api/product/featured"; // 经典热销
	public final static String HTTP_BOOK_LATEST_CATE= MY_SERVICE+ "/Api/product/latest_category"; // 最新上架类别
	public final static String HTTP_BOOK_LATEST= MY_SERVICE+ "/Api/product/latest"; // 最新上架

}
