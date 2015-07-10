package com.ereader.client.ui.bookstore;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.ereader.client.R;
import com.ereader.client.service.AppController;
import com.ereader.client.ui.adapter.BookAdapter;
import com.ereader.client.ui.view.PullToRefreshView;
import com.ereader.client.ui.view.PullToRefreshView.OnFooterRefreshListener;
import com.ereader.client.ui.view.PullToRefreshView.OnHeaderRefreshListener;
import com.ereader.common.util.IntentUtil;
import com.ereader.common.util.ToastUtil;

public class BookFragment extends Fragment implements OnClickListener,
OnHeaderRefreshListener, OnFooterRefreshListener{
	private View view;
	private Context mContext;
	private AppController controller;
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
				ToastUtil.showToast(mContext, "刷新成功！", ToastUtil.LENGTH_LONG);
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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.book_store_new_fragment, container, false);
		controller = AppController.getController(getActivity());
		mContext = getActivity();
		findView();
		initView();
		return view;
	}
	private void findView() {
		lv_book= (ListView)view.findViewById(R.id.lv_book);
		pull_refresh_book = (PullToRefreshView)view.findViewById(R.id.pull_refresh_book);
	}
	private void initView() {
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
		//adapter = new BookAdapter(mContext, mList);
		lv_book.setAdapter(adapter);
		lv_book.setOnItemClickListener(bookItemListener);
		
	}
	
	private OnItemClickListener bookItemListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			IntentUtil.intent(mContext, BookDetailActivity.class);
		}
	};
	
	
	
	
	@Override
	public void onClick(View v) {
		
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
