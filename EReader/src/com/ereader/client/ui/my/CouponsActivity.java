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
import com.ereader.client.ui.adapter.CouponsFragsAdapter;
import com.ereader.client.ui.view.ScrollingTabsView;
// 我的优惠劵
public class CouponsActivity extends BaseFragmentActivity implements OnClickListener {
	private AppController controller;
	private ScrollingTabsView stabs_coupons;
	private ViewPager vpager_coupons;
	private Button main_top_right;
	private List<Category> mListTitle;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_coupons_layout);
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
		stabs_coupons = (ScrollingTabsView)findViewById(R.id.stabs_coupons);
		vpager_coupons = (ViewPager)findViewById(R.id.vpager_coupons);
	}
	

	/**
	 * 
	  * 方法描述：初始化 View
	  * @author: why
	  * @time: 2015-2-10 下午1:37:06
	 */
	private void initView() {
		((TextView) findViewById(R.id.tv_main_top_title)).setText("电子充值卡");
		mListTitle = new ArrayList<Category>();
			mListTitle.add(new Category("全部","1"));
			mListTitle.add(new Category("可用","2"));
			mListTitle.add(new Category("已使用","3"));
			mListTitle.add(new Category("已过期","4"));
		CouponsFragsAdapter orderAdapter = new CouponsFragsAdapter(getSupportFragmentManager(),mListTitle.size());
		vpager_coupons.setAdapter(orderAdapter);
		
		// 设置缓存fragment的数量
		vpager_coupons.setOffscreenPageLimit(2);
		vpager_coupons.setCurrentItem(0);
		vpager_coupons.setPageMargin(4);
		
		
		BookTabsAdapter adapter = new BookTabsAdapter(this,mListTitle);
		stabs_coupons.setAdapter(adapter);
		stabs_coupons.setViewPager(vpager_coupons);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case  R.id.main_top_right:
			break;
		default:
			break;
		}
	}
}
