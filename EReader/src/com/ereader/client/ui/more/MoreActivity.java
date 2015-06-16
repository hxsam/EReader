package com.ereader.client.ui.more;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ereader.client.R;
import com.ereader.client.service.AppController;
import com.ereader.client.ui.BaseActivity;
import com.ereader.common.util.IntentUtil;

public class MoreActivity  extends BaseActivity implements OnClickListener {
	private AppController controller;
	private RelativeLayout rl_more_update;
	private RelativeLayout rl_more_help;
	private RelativeLayout rl_more_exit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.more_layout);
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
		rl_more_update  = (RelativeLayout)findViewById(R.id.rl_more_update);
		rl_more_help  = (RelativeLayout)findViewById(R.id.rl_more_help);
		rl_more_exit  = (RelativeLayout)findViewById(R.id.rl_more_exit);
	}
	

	/**
	 * 
	  * 方法描述：初始化 View
	  * @author: why
	  * @time: 2015-2-10 下午1:37:06
	 */
	private void initView() {
		((TextView) findViewById(R.id.tv_main_top_title)).setText("更多");
		rl_more_update.setOnClickListener(this);
		rl_more_help.setOnClickListener(this);
		rl_more_exit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case  R.id.rl_more_help:
			IntentUtil.intent(this, HelpActivity.class);
			break;
		default:
			break;
		}
	}

}
