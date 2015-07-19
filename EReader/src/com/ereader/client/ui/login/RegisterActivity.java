package com.ereader.client.ui.login;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ereader.client.R;
import com.ereader.client.service.AppController;
import com.ereader.client.ui.BaseActivity;
import com.ereader.common.util.ProgressDialogUtil;
import com.ereader.common.util.StringUtil;
import com.ereader.common.util.ToastUtil;

public class RegisterActivity extends BaseActivity implements OnClickListener {
	private AppController controller;
	private TextView tv_regisrer_code;
	private Button bt_register;
	private EditText et_register_code;
	private EditText et_register;
	
	private RegisterCountDownTimer timer;
	private boolean is_validate_tip = true;
	public static final int CODE_OK = 5;  //验证码  成功
	
	private Handler mHandler = new Handler(){
			
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case CODE_OK:
					timer = new RegisterCountDownTimer(60000, 1000);
					timer.cancel();
					timer.onTick(59000);
					timer.start();
					break;
				default:
					break;
				}
			}
	};
	
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
		tv_regisrer_code = (TextView)findViewById(R.id.tv_regisrer_code);
		et_register_code = (EditText)findViewById(R.id.et_register_code);
		et_register = (EditText)findViewById(R.id.et_register);
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
		tv_regisrer_code.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case  R.id.tv_regisrer_code:
			if(!StringUtil.isMoblieInput(et_register.getText().toString())){
				ToastUtil.showToast(RegisterActivity.this, "手机号码不合法", ToastUtil.LENGTH_LONG);
				return;
			}else{
				controller.getContext().addBusinessData("regisrerPhone",et_register.getText().toString());
			}
			
			ProgressDialogUtil.showProgressDialog(this, "通信中…", false);
			new Thread(new Runnable() {
				@Override
				public void run() {
					controller.getCode(mHandler);
					ProgressDialogUtil.closeProgressDialog();
				}
			}).start();
			break;
		case R.id.bt_register:
			if(et_register_code.getText().toString().length() == 6){
				controller.getContext().addBusinessData("code",et_register_code.getText().toString());
			}else{
				ToastUtil.showToast(RegisterActivity.this, "验证码位数不正确", ToastUtil.LENGTH_LONG);
				return;
			}
				ProgressDialogUtil.showProgressDialog(this, "通信中…", false);
				new Thread(new Runnable() {
					@Override
					public void run() {
						controller.register();
						ProgressDialogUtil.closeProgressDialog();
					}
				}).start();
			break;
		default:
			break;
		}
	}
	
	/* 定义一个倒计时的内部类 */
	class RegisterCountDownTimer extends CountDownTimer {
		public RegisterCountDownTimer(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}

		@Override
		public void onFinish() {
			is_validate_tip = true;
			tv_regisrer_code.setText("获取验证码");
		}

		@Override
		public void onTick(long millisUntilFinished) {
			is_validate_tip = false;
			tv_regisrer_code.setText("倒计时"+millisUntilFinished / 1000 + "s");
		}
	}

}
