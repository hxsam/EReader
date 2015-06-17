package com.ereader.client.ui.bookstore;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.ereader.client.R;
import com.ereader.client.service.AppController;
import com.ereader.client.ui.BaseActivity;
import com.ereader.client.ui.BaseFragmentActivity;
import com.ereader.client.ui.adapter.BookNewAdapter;
import com.ereader.client.ui.adapter.FragsNewAdapter;
import com.ereader.client.ui.view.ScrollingTabsView;

public class NewBookActivity extends BaseFragmentActivity implements OnClickListener {
	private AppController controller;
	private ScrollingTabsView st_book_new;
	private ViewPager vp_book_store;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.book_store_new_layout);
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
		st_book_new = (ScrollingTabsView)findViewById(R.id.st_book_new);
		vp_book_store = (ViewPager)findViewById(R.id.vp_book_store);
	}
	

	/**
	 * 
	  * 方法描述：初始化 View
	  * @author: why
	  * @time: 2015-2-10 下午1:37:06
	 */
	private void initView() {
		((TextView) findViewById(R.id.tv_main_top_title)).setText("最新上架");
		
		
		FragsNewAdapter pageAdapter = new FragsNewAdapter(getSupportFragmentManager());
		vp_book_store.setAdapter(pageAdapter);
		
		// 设置缓存fragment的数量
		vp_book_store.setOffscreenPageLimit(2);
		vp_book_store.setCurrentItem(0);
		vp_book_store.setPageMargin(4);
		
		
		BookNewAdapter adapter = new BookNewAdapter(this);
		st_book_new.setAdapter(adapter);
		st_book_new.setViewPager(vp_book_store);
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
