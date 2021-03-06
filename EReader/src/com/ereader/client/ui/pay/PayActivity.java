package com.ereader.client.ui.pay;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.ereader.client.R;
import com.ereader.client.service.AppController;
import com.ereader.client.ui.BaseActivity;
import com.ereader.common.util.IntentUtil;
import com.ereader.common.util.ProgressDialogUtil;

public class PayActivity extends BaseActivity implements OnClickListener {
	private AppController controller;
	private TextView tv_pay_money;
	private TextView tv_pay_all_money;// 实际付款
	private CheckBox ck_pay_point;
	private EditText et_pay_point;
	private TextView tv_pay_point;
	private TextView tv_pay_point_sum;
	private Button main_top_right;
	private String money;
	private int point = 0;
	
	
	private Handler mHandler = new Handler() {

		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0:

				break;

			default:
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pay_layout);
		controller = AppController.getController(this);
		findView();
		initView();
	}

	/**
	 * 
	 * 方法描述：FindView
	 * 
	 * @author: why
	 * @time: 2015-2-10 下午1:37:06
	 */
	private void findView() {
		tv_pay_money = (TextView) findViewById(R.id.tv_pay_money);
		tv_pay_all_money = (TextView) findViewById(R.id.tv_pay_all_money);
		ck_pay_point = (CheckBox) findViewById(R.id.ck_pay_point);
		et_pay_point = (EditText) findViewById(R.id.et_pay_point);
		tv_pay_point = (TextView) findViewById(R.id.tv_pay_point);
		tv_pay_point_sum = (TextView) findViewById(R.id.tv_pay_point_sum);
		main_top_right = (Button) findViewById(R.id.main_top_right);
	}

	/**
	 * 
	 * 方法描述：初始化 View
	 * 
	 * @author: why
	 * @time: 2015-2-10 下午1:37:06
	 */
	private void initView() {
		((TextView) findViewById(R.id.tv_main_top_title)).setText("支付");
		main_top_right.setOnClickListener(this);
		main_top_right.setText("充值");
		money = getIntent().getExtras().getString("money");
		point = 60;
		tv_pay_money.setText("¥ " + money);
		tv_pay_all_money.setText("¥ " + money);
		tv_pay_point.setText("(可用"+point+"点)");
		tv_pay_point_sum.setText("-¥ 0.00");
	}

	private void getList() {
		ProgressDialogUtil.showProgressDialog(this, "努力加载中…", false);
		new Thread(new Runnable() {
			@Override
			public void run() {
				controller.featuredList(mHandler);
				ProgressDialogUtil.closeProgressDialog();
			}
		}).start();
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.main_top_right:
			IntentUtil.intent(PayActivity.this, RechargeActivity.class);
			break;
		default:
			break;
		}
	}
}
