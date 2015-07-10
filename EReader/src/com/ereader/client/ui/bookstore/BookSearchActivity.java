package com.ereader.client.ui.bookstore;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.ereader.client.R;
import com.ereader.client.service.AppController;
import com.ereader.client.ui.BaseActivity;
import com.ereader.client.ui.adapter.BookAdapter;
import com.ereader.common.util.IntentUtil;

// 搜索 
public class BookSearchActivity extends BaseActivity implements
		OnClickListener {
	private AppController controller;
	private ListView lv_book_search;
	private List<String> mList = new ArrayList<String>();
	private BookAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.book_search_layout);
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
		lv_book_search = (ListView)findViewById(R.id.lv_book_search);
	}

	/**
	 * 
	 * 方法描述：初始化 View
	 * 
	 * @author: why
	 * @time: 2015-2-10 下午1:37:06
	 */
	private void initView() {
		mList.add("赢");
		mList.add("赢");
		mList.add("赢");
		mList.add("赢");
		mList.add("赢");
		mList.add("赢");
		mList.add("赢");
		mList.add("赢");
	//	adapter = new BookAdapter(BookSearchActivity.this, mList);
		lv_book_search.setAdapter(adapter);
		lv_book_search.setOnItemClickListener(bookItemListener);
	}
	
	private OnItemClickListener bookItemListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			IntentUtil.intent(BookSearchActivity.this, BookDetailActivity.class);
		}
	};
	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.textView1:
			break;
		default:
			break;
		}
	}
}
