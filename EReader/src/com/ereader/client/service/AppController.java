package com.ereader.client.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Message;

import com.ereader.client.service.impl.ClientServiceImpl;
import com.ereader.client.ui.MainActivity;
import com.ereader.common.exception.BusinessException;

/***
 * 控制层 该类保存客户端控制器
 * 
 * @author why
 * @time 2011-9-22
 */
public class AppController {
	/**
	 * 客户端上下文，该对象用来缓存客户端业务数据和参数配置
	 */
	private AppContext context;
	/** 服务对象 **/
	private ClientService service;

	public AppContext getContext() {
		return context;
	}

	public void setContext(AppContext context) {
		this.context = context;
	}

	/***
	 * 控制器单例对象
	 */
	private static AppController controller = null;

	/***
	 * 当前android的活动对象
	 */
	private Activity currentActivity;

	private AppController(Activity act) {
		this.currentActivity = act;
		createContext();
		service = new ClientServiceImpl(context);
	}

	/**
	 * 初始化客户端配置信息
	 */
	private void createContext() {
		context = new AppContext();
		context.setConfigProerties(getProperties());
	}

	private Properties getProperties() {
		Properties pro = new Properties();

		try {
			// 建立资源对象 读取资源
			AssetManager am = currentActivity.getAssets();
			InputStream in = am.open("config/client_config.properties");
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}

	/**
	 * 得到单例的controller对象
	 * 
	 * @return
	 */
	public synchronized static AppController getController() {
		if (controller == null) {
			controller = new AppController(null);
		}
		return controller;
	}

	/**
	 * 得到单例controller对象，并设置当前controller当前关联的Activity活动对象
	 */
	public synchronized static AppController getController(Activity act) {
		if (controller == null) {
			controller = new AppController(act);
		} else {
			controller.setCurrentActivity(act);
		}
		return controller;
	}

	public Activity getCurrentActivity() {
		return currentActivity;
	}

	public void setCurrentActivity(Activity currentActivity) {
		this.currentActivity = currentActivity;
	}
	
	
	private Handler handler = new Handler(){
		
		/* (non-Javadoc)
		 * @see android.os.Handler#handleMessage(android.os.Message)
		 */
		@Override
		public void handleMessage(Message msg) {
			
		}
	};

	/***
	 * 方法描述: 可以自己定制信息显示 只要填入字符串类型 就可以提示 方法名称: builderErrorMessage
	 * 
	 * @param message
	 *            返回类型:void
	 */

	public void builderErrorMessage(String message) {
		Builder b = new AlertDialog.Builder(currentActivity);
		b.setTitle("错误提示");
		b.setMessage(message);
		b.setPositiveButton("确定", new OnClickListener() {
			public void onClick(DialogInterface arg0, int arg1) {
			}
		});
		b.create().show();
	}

	/***
	 * 方法描述: 可以自己定制信息显示 只要填入字符串类型 就可以提示 方法名称: builderErrorMessage
	 * 
	 * @param message
	 *            返回类型:void
	 */

	public void builderMessage(String message) {
		Builder b = new AlertDialog.Builder(currentActivity);
		b.setTitle("提示");
		b.setMessage(message);
		b.setPositiveButton("确定", new OnClickListener() {
			public void onClick(DialogInterface arg0, int arg1) {
				
			}
		});
		b.create().show();
	}

	public void login() {
		try {
			service.login();
			Intent intent = new Intent(currentActivity,MainActivity.class);
			currentActivity.startActivity(intent);
		} catch (BusinessException e) {
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
