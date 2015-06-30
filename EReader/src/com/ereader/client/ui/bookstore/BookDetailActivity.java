package com.ereader.client.ui.bookstore;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.ereader.client.R;
import com.ereader.client.service.AppController;
import com.ereader.client.ui.BaseFragmentActivity;
import com.ereader.client.ui.adapter.BookDetailFragsAdapter;
import com.ereader.client.ui.adapter.BookDetailTabsAdapter;
import com.ereader.client.ui.buycar.BuyCarActivity;
import com.ereader.client.ui.my.CollectionActivity;
import com.ereader.client.ui.view.ScrollingTabsView;
import com.ereader.common.util.IntentUtil;
import com.ereader.common.util.ToastUtil;

public class BookDetailActivity extends BaseFragmentActivity implements OnClickListener {
	private ScrollingTabsView st_book_detail;
	private ViewPager vp_book_store;
	private AppController controller;
	private Button main_top_right;
	private List<String> mListTitle;
	private TextView tv_book_collection;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.book_detail_layout);
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
		st_book_detail = (ScrollingTabsView)findViewById(R.id.st_book_detail);
		vp_book_store = (ViewPager)findViewById(R.id.vp_book_store);
		tv_book_collection = (TextView)findViewById(R.id.tv_book_collection);
	}
	

	/**
	 * 
	  * 方法描述：初始化 View
	  * @author: why
	  * @time: 2015-2-10 下午1:37:06
	 */
	private void initView() {
		((TextView) findViewById(R.id.tv_main_top_title)).setText("书城");
		
		main_top_right.setText("购物车(1)");
		Drawable drawable= getResources().getDrawable(R.drawable.b5_03);
		/// 这一步必须要做,否则不会显示.
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		main_top_right.setCompoundDrawables(drawable,null,null,null);
		main_top_right.setTextColor(getResources().getColor(R.color.white));
		main_top_right.setOnClickListener(this);
		tv_book_collection.setOnClickListener(this);

		mListTitle = new ArrayList<String>();
		mListTitle.add("目录");
		mListTitle.add("内容简介");
		mListTitle.add("作者简介");
		mListTitle.add("书评");
		
		BookDetailFragsAdapter pageAdapter = new BookDetailFragsAdapter(getSupportFragmentManager(),mListTitle.size());
		vp_book_store.setAdapter(pageAdapter);
		
		// 设置缓存fragment的数量
		vp_book_store.setOffscreenPageLimit(2);
		vp_book_store.setCurrentItem(0);
		vp_book_store.setPageMargin(4);
		
		
		BookDetailTabsAdapter adapter = new BookDetailTabsAdapter(this,mListTitle);
		st_book_detail.setAdapter(adapter);
		st_book_detail.setViewPager(vp_book_store);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case  R.id.main_top_right:
			IntentUtil.intent(BookDetailActivity.this, BuyCarActivity.class);
			break;
		case R.id.tv_book_collection:
			ToastUtil.showToast(BookDetailActivity.this, "收藏成功", ToastUtil.LENGTH_LONG);
			IntentUtil.intent(BookDetailActivity.this, CollectionActivity.class);
			break;
		default:
			break;
		}
	}
}
