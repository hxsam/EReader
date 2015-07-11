package com.ereader.client.service;

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
	/**最新上架**/
	public void latest()throws Exception ;
	/**=获取书**/
	public void latest(String cate_id)throws Exception ;

}
