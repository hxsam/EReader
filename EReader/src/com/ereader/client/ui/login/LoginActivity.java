package com.ereader.client.ui.login;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.ereader.client.R;
import com.ereader.client.service.AppController;
import com.ereader.client.ui.BaseActivity;
import com.ereader.common.util.ToastUtil;

public class LoginActivity extends BaseActivity implements OnClickListener {
	private AppController controller;
	private Button bt_login;
	private TextView tv_login_register;
	private TextView tv_login_findpwd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
		controller = AppController.getController(this);
		findView();
		initView();
	}
	/**
	 * 
	  * 方法描述：FindView
	  * @author: why
	  * @time: 2015-2-10 下午1:37:06
	 */
	private void findView() {
		bt_login = (Button)findViewById(R.id.bt_login);
		tv_login_register = (TextView)findViewById(R.id.tv_login_register);
		tv_login_findpwd = (TextView)findViewById(R.id.tv_login_findpwd);

	}
	

	/**
	 * 
	  * 方法描述：初始化 View
	  * @author: why
	  * @time: 2015-2-10 下午1:37:06
	 */
	private void initView() {
		((TextView) findViewById(R.id.tv_main_top_title)).setText("登录");
		bt_login.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case  R.id.bt_login:
			ToastUtil.showToast(this, "登录成功", ToastUtil.LENGTH_LONG);
			this.finish();
			break;
		case R.id.tv_login_findpwd:
			break;
		case R.id.tv_login_register:
			break;
		default:
			break;
		}
	}
}
