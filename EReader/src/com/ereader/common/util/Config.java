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
	public final static String HTTP_BOOK_DISCOUNT_CATE= MY_SERVICE+ "/Api/product/discount_category"; // 特价专区类别
	public final static String HTTP_BOOK_DISCOUNT= MY_SERVICE+ "/Api/product/discount"; // 特价专区
	public final static String HTTP_BOOK_COLLECTION= MY_SERVICE+ "/api/product/favourite"; // 获取收藏夹
	public final static String HTTP_BOOK_DELETE_COLLECTION= MY_SERVICE+ "/api/product/delFromFavourite"; // 删除收藏夹
	public final static String HTTP_BOOK_CATEGORY= MY_SERVICE+ "/Api/product/category"; //  商品分类
	public final static String HTTP_BOOK_SEARCH = MY_SERVICE+ "/api/product/search"; //  搜索列表
}
