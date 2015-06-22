package com.ereader.client.ui.bookstore;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.ereader.client.R;
import com.ereader.client.service.AppController;
import com.ereader.client.ui.adapter.BookSPAdapter;
import com.ereader.client.ui.view.PullToRefreshView;
import com.ereader.client.ui.view.PullToRefreshView.OnFooterRefreshListener;
import com.ereader.client.ui.view.PullToRefreshView.OnHeaderRefreshListener;
// 书评
public class BookSPFragment extends Fragment implements OnClickListener{
	private View view;
	private Context mContext;
	private AppController controller;
	private ListView lv_book_sp;
	private List<String> mList = new ArrayList<String>();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.book_sp_fragment, container, false);
		controller = AppController.getController(getActivity());
		mContext = getActivity();
		findView();
		initView();
		return view;
	}
	private void findView() {
		lv_book_sp = (ListView)view.findViewById(R.id.lv_book_sp);
	}
	private void initView() {
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
		BookSPAdapter adapter = new BookSPAdapter(mContext, mList);
		lv_book_sp.setAdapter(adapter);
		lv_book_sp.setOnItemClickListener(bookItemListener);
		
	}
	
	private OnItemClickListener bookItemListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
		}
	};
	
	
	
	
	@Override
	public void onClick(View v) {
		
	}
}
