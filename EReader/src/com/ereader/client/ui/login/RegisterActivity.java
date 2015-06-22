package com.ereader.client.ui.login;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.ereader.client.R;
import com.ereader.client.service.AppController;
import com.ereader.client.ui.BaseActivity;

public class RegisterActivity extends BaseActivity implements OnClickListener {
	private AppController controller;
	private TextView textView1;
	private Button bt_register;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_register_layout);
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
		bt_register= (Button)findViewById(R.id.bt_register);
		textView1 = (TextView)findViewById(R.id.textView1);
	}
	

	/**
	 * 
	  * 方法描述：初始化 View
	  * @author: why
	  * @time: 2015-2-10 下午1:37:06
	 */
	private void initView() {
		((TextView) findViewById(R.id.tv_main_top_title)).setText("注册");
		bt_register.setOnClickListener(this);
		textView1.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case  R.id.textView1:
			break;
		default:
			break;
		}
	}

}
