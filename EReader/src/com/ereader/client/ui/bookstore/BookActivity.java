package com.ereader.client.ui.bookstore;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.ereader.client.R;
import com.ereader.client.service.AppController;
import com.ereader.client.ui.BaseActivity;
import com.ereader.client.ui.adapter.BookAdapter;
import com.ereader.client.ui.view.PullToRefreshView;
import com.ereader.client.ui.view.PullToRefreshView.OnFooterRefreshListener;
import com.ereader.client.ui.view.PullToRefreshView.OnHeaderRefreshListener;
import com.ereader.common.util.IntentUtil;
import com.ereader.common.util.ToastUtil;

public class BookActivity extends BaseActivity implements OnClickListener,
OnHeaderRefreshListener, OnFooterRefreshListener{
	private AppController controller;
	private Button main_top_right;
	private ListView lv_book;
	private PullToRefreshView pull_refresh_book;
	private List<String> mList = new ArrayList<String>();
	private BookAdapter adapter;
	
	
	public static final int REFRESH_DOWN_OK = 1; // 向下刷新
	public static final int REFRESH_UP_OK = 2;  //向上拉
	private Handler mhandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case REFRESH_DOWN_OK:
				ToastUtil.showToast(BookActivity.this, "刷新成功！", ToastUtil.LENGTH_LONG);
				pull_refresh_book.onHeaderRefreshComplete();
				break;
			case REFRESH_UP_OK:
				mList.add("赢");
				mList.add("赢");
				mList.add("赢");
				mList.add("赢");
				mList.add("赢");
				adapter.notifyDataSetChanged();
				pull_refresh_book.onFooterRefreshComplete();
				break;

			default:
				break;
			}
		};
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.book_layout);
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
		lv_book= (ListView)findViewById(R.id.lv_book);
		pull_refresh_book = (PullToRefreshView)findViewById(R.id.pull_refresh_book);
	}
	

	/**
	 * 
	  * 方法描述：初始化 View
	  * @author: why
	  * @time: 2015-2-10 下午1:37:06
	 */
	private void initView() {
		
		String title = getIntent().getExtras().getString("title");
		((TextView) findViewById(R.id.tv_main_top_title)).setText(title);
		main_top_right.setText("购物车");
		pull_refresh_book.setOnHeaderRefreshListener(this);
		pull_refresh_book.setOnFooterRefreshListener(this);
		mList.add("赢");
		mList.add("赢");
		mList.add("赢");
		mList.add("赢");
		mList.add("赢");
		mList.add("赢");
		mList.add("赢");
		mList.add("赢");
		mList.add("赢");
		mList.add("赢");
		adapter = new BookAdapter(BookActivity.this, mList);
		lv_book.setAdapter(adapter);
		lv_book.setOnItemClickListener(bookItemListener);
	}
	
	private OnItemClickListener bookItemListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			IntentUtil.intent(BookActivity.this, BookDetailActivity.class);
		}
	};

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case  R.id.textView1:
			break;
		default:
			break;
		}
	}

	@Override
	public void onFooterRefresh(PullToRefreshView view) {
		mhandler.sendEmptyMessageDelayed(REFRESH_UP_OK, 3000);
	}
	@Override
	public void onHeaderRefresh(PullToRefreshView view) {
		mhandler.sendEmptyMessageDelayed(REFRESH_DOWN_OK, 3000);
	}
}
