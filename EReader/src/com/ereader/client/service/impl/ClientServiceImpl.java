package com.ereader.client.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.ereader.client.EReaderApplication;
import com.ereader.client.entities.json.BaseResp;
import com.ereader.client.service.AppContext;
import com.ereader.client.service.ClientService;
import com.ereader.common.net.Request;
import com.ereader.common.util.Config;

public class ClientServiceImpl implements ClientService {
	private AppContext context;


	public ClientServiceImpl(AppContext context) {
		this.context = context;
	}

	@Override
	public void login() throws Exception {
		Request<BaseResp> request = new Request<BaseResp>();
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("deviceNo", "BaseResp"));
		request.addParameter(Request.AJAXPARAMS, nameValuePairs);
		request.setUrl(Config.HTTP_USER_MOBLIE_LOGIN);
		request.setR_calzz(BaseResp.class);
		BaseResp resp = EReaderApplication.getAppSocket().shortConnect(request);
		if ("success".equals(resp.getResult())) {
			
		} else if ("failure".equals(resp.getResult())) {
			
		}
	}
}
