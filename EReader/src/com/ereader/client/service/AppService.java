package com.ereader.client.service;

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

}
