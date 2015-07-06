package com.ereader.client.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.ereader.client.EReaderApplication;
import com.ereader.client.entities.json.BaseResp;
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
		nameValuePairs.add(new BasicNameValuePair("loginname", account));
		nameValuePairs.add(new BasicNameValuePair("password", password));
		request.addParameter(Request.AJAXPARAMS, nameValuePairs);
		request.setUrl(Config.HTTP_USER_MOBLIE_LOGIN);
		request.setR_calzz(BaseResp.class);
		BaseResp resp = EReaderApplication.getAppSocket().shortConnect(request);
		if (BaseResp.SUCCESS.equals(resp.getStatus())) {
			
		} else {
			throw new BusinessException(new ErrorMessage(resp.getStatus(), resp.getMessage()));
		}
	}
}
