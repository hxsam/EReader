package com.ereader.client.ui.my;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.ereader.client.R;
import com.ereader.client.entities.Category;
import com.ereader.client.service.AppController;
import com.ereader.client.ui.BaseFragmentActivity;
import com.ereader.client.ui.adapter.BookTabsAdapter;
import com.ereader.client.ui.adapter.MessageFragsAdapter;
import com.ereader.client.ui.view.ScrollingTabsView;
import com.ereader.common.util.ToastUtil;
// 我的消息
public class MessageActivity extends BaseFragmentActivity implements OnClickListener {
	private AppController controller;
	private ScrollingTabsView stabs_message;
	private ViewPager vpager_message;
	private Button main_top_right;
	private List<Category> mListTitle;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_message_layout);
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
		main_top_right = (Button)findViewById(R.id.main_top_right);
		stabs_message = (ScrollingTabsView)findViewById(R.id.stabs_message);
		vpager_message = (ViewPager)findViewById(R.id.vpager_message);
	}
	

	/**
	 * 
	  * 方法描述：初始化 View
	  * @author: why
	  * @time: 2015-2-10 下午1:37:06
	 */
	private void initView() {
		((TextView) findViewById(R.id.tv_main_top_title)).setText("我的消息");
		main_top_right.setText("清空消息");
		main_top_right.setOnClickListener(this);
		mListTitle = new ArrayList<Category>();
			mListTitle.add(new Category("好友消息","1"));
			mListTitle.add(new Category("好友推荐","2"));
			mListTitle.add(new Category("连载更新","3"));
			mListTitle.add(new Category("系统消息","4"));
		MessageFragsAdapter orderAdapter = new MessageFragsAdapter(getSupportFragmentManager(),mListTitle.size());
		vpager_message.setAdapter(orderAdapter);
		
		// 设置缓存fragment的数量
		vpager_message.setOffscreenPageLimit(2);
		vpager_message.setCurrentItem(0);
		vpager_message.setPageMargin(4);
		
		
		BookTabsAdapter adapter = new BookTabsAdapter(this,mListTitle);
		stabs_message.setAdapter(adapter);
		stabs_message.setViewPager(vpager_message);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case  R.id.main_top_right:
			ToastUtil.showToast(MessageActivity.this, "清空成功", ToastUtil.LENGTH_LONG);
			break;
		default:
			break;
		}
	}
}
