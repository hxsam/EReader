package com.ereader.client.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.ereader.client.EReaderApplication;
import com.ereader.client.entities.DisCategory;
import com.ereader.client.entities.json.BaseResp;
import com.ereader.client.entities.json.BookResp;
import com.ereader.client.entities.json.CategoryResp;
import com.ereader.client.entities.json.DisCategoryResp;
import com.ereader.client.service.AppContext;
import com.ereader.client.service.AppService;
import com.ereader.common.exception.BusinessException;
import com.ereader.common.exception.ErrorMessage;
import com.ereader.common.net.Request;
import com.ereader.common.util.Config;

public class AppServiceImpl implements AppService {
	private AppContext context;


	public AppServiceImpl(AppContext context) {
		this.context = context;
	}

	@Override
	public void login() throws Exception {
		String account = (String)context.getBusinessData("user.account");
		String password = (String)context.getBusinessData("user.password");
		Request<BaseResp> request = new Request<BaseResp>();
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("password", password));
		nameValuePairs.add(new BasicNameValuePair("loginname", account));
		request.addParameter(Request.AJAXPARAMS, nameValuePairs);
		request.setUrl(Config.HTTP_LOGIN);
		request.setR_calzz(BaseResp.class);
		BaseResp resp = EReaderApplication.getAppSocket().shortConnect(request);
		if (BaseResp.SUCCESS.equals(resp.getStatus())) {
			EReaderApplication.getInstance().setLogin(true);
			
		} else {
			throw new BusinessException(new ErrorMessage(resp.getStatus(), resp.getMessage()));
		}
	}
	
	@Override
	public void register() throws Exception {

		Request<BaseResp> request = new Request<BaseResp>();
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("phone", "1820000001"));
		nameValuePairs.add(new BasicNameValuePair("password", "111111"));
		nameValuePairs.add(new BasicNameValuePair("email", "111111@163.com"));
		nameValuePairs.add(new BasicNameValuePair("nickname", "111"));
		request.addParameter(Request.AJAXPARAMS, nameValuePairs);
		request.setUrl(Config.HTTP_REGISTER);
		request.setR_calzz(BaseResp.class);
		BaseResp resp = EReaderApplication.getAppSocket().shortConnect(request);
		if (BaseResp.SUCCESS.equals(resp.getStatus())) {
			EReaderApplication.getInstance().setLogin(true);
		} else {
			throw new BusinessException(new ErrorMessage(resp.getStatus(), resp.getMessage()));
		}
	
	}
	
	@Override
	public void featuredList() throws Exception {
		Request<BookResp> request = new Request<BookResp>();
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("page", "1"));
		nameValuePairs.add(new BasicNameValuePair("per_page", "10"));
		request.addParameter(Request.AJAXPARAMS, nameValuePairs);
		request.setUrl(Config.HTTP_BOOK_FEATURED);
		request.setR_calzz(BookResp.class);
		BookResp resp = EReaderApplication.getAppSocket().shortConnect(request);
		if (BaseResp.SUCCESS.equals(resp.getStatus())) {
			context.addBusinessData("BookFeaturedResp", resp);
		} else {
			throw new BusinessException(new ErrorMessage(resp.getStatus(), resp.getMessage()));
		}
	}
	@Override
	public void latest() throws Exception {
		Request<CategoryResp> request = new Request<CategoryResp>();
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		request.addParameter(Request.AJAXPARAMS, nameValuePairs);
		request.setUrl(Config.HTTP_BOOK_LATEST_CATE);
		request.setR_calzz(CategoryResp.class);
		CategoryResp resp = EReaderApplication.getAppSocket().shortConnect(request);
		if (BaseResp.SUCCESS.equals(resp.getStatus())) {
			context.addBusinessData("CategoryResp", resp.getData());
		} else {
			throw new BusinessException(new ErrorMessage(resp.getStatus(), resp.getMessage()));
		}
	}
	
	@Override
	public void latest(String cate_id) throws Exception {

		Request<BookResp> request = new Request<BookResp>();
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("category_id", cate_id));
		nameValuePairs.add(new BasicNameValuePair("page", "1"));
		nameValuePairs.add(new BasicNameValuePair("per_page", "10"));
		request.addParameter(Request.AJAXPARAMS, nameValuePairs);
		request.setUrl(Config.HTTP_BOOK_LATEST);
		request.setR_calzz(BookResp.class);
		BookResp resp = EReaderApplication.getAppSocket().shortConnect(request);
		if (BaseResp.SUCCESS.equals(resp.getStatus())) {
			context.addBusinessData("BookFeaturedResp", resp);
		} else {
			throw new BusinessException(new ErrorMessage(resp.getStatus(), resp.getMessage()));
		}
	}
	@Override
	public void discount() throws Exception {

		Request<DisCategoryResp> request = new Request<DisCategoryResp>();
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		request.addParameter(Request.AJAXPARAMS, nameValuePairs);
		request.setUrl(Config.HTTP_BOOK_DISCOUNT_CATE);
		request.setR_calzz(DisCategoryResp.class);
		DisCategoryResp resp = EReaderApplication.getAppSocket().shortConnect(request);
		if (BaseResp.SUCCESS.equals(resp.getStatus())) {
			context.addBusinessData("DisCategoryResp", resp.getData());
		} else {
			throw new BusinessException(new ErrorMessage(resp.getStatus(), resp.getMessage()));
		}
	
	}
	
	@Override
	public void discountBook(DisCategory mDisCate) throws Exception {


		Request<BookResp> request = new Request<BookResp>();
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("min", mDisCate.getMin()));
		nameValuePairs.add(new BasicNameValuePair("max", mDisCate.getMax()));
		nameValuePairs.add(new BasicNameValuePair("page", "1"));
		nameValuePairs.add(new BasicNameValuePair("per_page", "10"));
		request.addParameter(Request.AJAXPARAMS, nameValuePairs);
		request.setUrl(Config.HTTP_BOOK_DISCOUNT);
		request.setR_calzz(BookResp.class);
		BookResp resp = EReaderApplication.getAppSocket().shortConnect(request);
		if (BaseResp.SUCCESS.equals(resp.getStatus())) {
			context.addBusinessData("BookFeaturedResp", resp);
		} else {
			throw new BusinessException(new ErrorMessage(resp.getStatus(), resp.getMessage()));
		}
	}
}
