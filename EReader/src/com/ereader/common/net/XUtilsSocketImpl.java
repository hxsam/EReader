package com.ereader.common.net;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.impl.cookie.BasicClientCookie;

import android.text.TextUtils;

import com.ereader.client.service.AppController;
import com.ereader.common.exception.BusinessException;
import com.ereader.common.exception.ErrorMessage;
import com.ereader.common.util.Json_U;
import com.ereader.common.util.LogUtil;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseStream;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.util.PreferencesCookieStore;
//import com.lidroid.xutils.util.CookieUtils;

/******************************************
 * 类描述： XUtils 框架实现网络处理 类名称：XUtilsSocketImpl
 * 
 * @version: 1.0
 * @author: why
 * @time: 2014-2-12 上午10:46:38
 ******************************************/
public class XUtilsSocketImpl implements AppSocketInterface {
	private static HttpUtils httpUtils;
	public final static int TIMEOUT_SOCKET = 30 * 1000; // 超时时间，默认10秒
	public final static int RETRY_TIME = 3;// 重试次数
	public final static String CHARSET = "UTF-8";
	//private CookieUtils cookieUtils;
	private PreferencesCookieStore preferencesCookieStore;
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T shortConnect(Request<T> request) throws BusinessException {

		if (!NetWorkHelper.isNetworkAvailable(AppController.getController().getCurrentActivity())) {
			throw new BusinessException(new ErrorMessage("网络无法连接"));
		}
		String value = "";

		HttpUtils httpUtils = getHttpUtils();
		try {
			RequestParams params = new RequestParams();
			
			
			List<NameValuePair> nameValuePairs = (List<NameValuePair>) request
					.getParameter(Request.AJAXPARAMS);
			if (nameValuePairs == null) {
				nameValuePairs = new ArrayList<NameValuePair>();
			}
			params.addQueryStringParameter(nameValuePairs);
			LogUtil.Log("sendHttp", request.getUrl() + nameValuePairs.toString());
			ResponseStream responseStream = httpUtils.sendSync(HttpRequest.HttpMethod.POST,
					request.getUrl(), params);

			value = responseStream.readString();
			LogUtil.Log("XUtilsSocketImpl", value);
		} catch (com.lidroid.xutils.exception.HttpException e) {
			e.printStackTrace();
			throw new BusinessException(new ErrorMessage("网络故障，请您稍候再试"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new BusinessException(new ErrorMessage("网络故障，请您稍候再试"));
		}

		if (TextUtils.isEmpty(value)) {
			throw new BusinessException(new ErrorMessage("网络故障，请您稍候再试"));
		}
		return Json_U.parseJsonToObj(value, request.getR_calzz());
	}

	@Override
	public <T> T longConnect(Request<T> request) {
		// TODO Auto-generated method stub
		return null;
	}

	public synchronized HttpUtils getHttpUtils() {
		if (httpUtils == null) {
			preferencesCookieStore = new PreferencesCookieStore(AppController.getController().getCurrentActivity());
//			cookieUtils = new CookieUtils(AppController.getController().getCurrentActivity());
			 BasicClientCookie cookie = new BasicClientCookie("test", "download");
//		     cookie.setDomain(request.getUrl());
//		     cookie.setPath("/");
		     preferencesCookieStore.addCookie(cookie);
			httpUtils = new HttpUtils();
			httpUtils.configResponseTextCharset(CHARSET);
			httpUtils.configTimeout(TIMEOUT_SOCKET);
			httpUtils.configRequestRetryCount(RETRY_TIME);
			preferencesCookieStore.addCookie(cookie);
			httpUtils.configCookieStore(preferencesCookieStore);
		}
		return httpUtils;
	}
}
