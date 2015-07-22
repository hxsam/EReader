package com.ereader.client.service;

import android.os.Handler;

import com.ereader.client.entities.DisCategory;

public interface AppService {

	/**
	 * 登陆
	 * @throws Exception
	 */
	public void login() throws Exception ;

	/**经典热销**/
	public void featuredList()throws Exception ;
	/**注册**/
	public void register()throws Exception ;
	/**最新上架类别**/
	public void latest()throws Exception ;
	/**=获取书**/
	public void latest(String cate_id)throws Exception;
	/**特价专区类别**/
	public void discount()throws Exception;
	/**特价专区类书**/
	public void discountBook(DisCategory mDisCate)throws Exception;
	/**获取收藏夹**/
	public void getCollection()throws Exception;
	/**删除收藏夹**/
	public void deleteCollection()throws Exception;
	/**2.2.1.	商品分类**/
	public void getCategory()throws Exception;
	/**2.2.1搜索列表**/
	public void search(String value)throws Exception;
	/**获取验证码**/
	public void getCode()throws Exception;
	/**添加到收藏夹**/
	public void addCollection(String id)throws Exception;
	/**添我的书评**/
	public void getSP()throws Exception;
	/**我的购物车**/
	public void buyCar()throws Exception;
	/**添加购物车**/
	public void addBuyCar()throws Exception;
	/**删除购物车**/
	public void deleteBuyCar()throws Exception;
	/**商品书评**/
	public void getComment(String id)throws Exception;

}
