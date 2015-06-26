package com.ereader.client.ui.my;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.ereader.client.R;
import com.ereader.client.service.AppController;
import com.ereader.client.ui.BaseActivity;
import com.ereader.client.ui.adapter.FriendsAdapter;
import com.ereader.common.util.ToastUtil;

// 我的好友
public class FriendsActivity extends BaseActivity implements OnClickListener {
	private AppController controller;
	private ListView lv_my_friends;
	private Button main_top_right;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_friends_layout);
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
		lv_my_friends = (ListView)findViewById(R.id.lv_my_friends);
		main_top_right = (Button)findViewById(R.id.main_top_right);
	}
	

	/**
	 * 
	  * 方法描述：初始化 View
	  * @author: why
	  * @time: 2015-2-10 下午1:37:06
	 */
	private void initView() {
		((TextView) findViewById(R.id.tv_main_top_title)).setText("我的好友");
		main_top_right.setText("添加好友");
		main_top_right.setOnClickListener(this);
		List<String> mList = new ArrayList<String>();
		mList.add("");
		mList.add("");
		mList.add("");
		mList.add("");
		mList.add("");
		mList.add("");
		FriendsAdapter adapter = new FriendsAdapter(this, mList);
		lv_my_friends.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case  R.id.main_top_right:
			// 
			ToastUtil.showToast(FriendsActivity.this, "添加成功", ToastUtil.LENGTH_LONG);
			break;
		default:
			break;
		}
	}
}