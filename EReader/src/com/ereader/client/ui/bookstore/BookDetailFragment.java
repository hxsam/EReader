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
import android.widget.Button;
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

public class BookDetailFragment extends Fragment implements OnClickListener{
	private View view;
	private Context mContext;
	private AppController controller;
	private List<String> mList = new ArrayList<String>();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.book_detail_fragment, container, false);
		controller = AppController.getController(getActivity());
		mContext = getActivity();
		findView();
		initView();
		return view;
	}
	private void findView() {
		
	}
	
	private void initView() {
		
	}
	
	
	
	@Override
	public void onClick(View v) {
		
	}

}
