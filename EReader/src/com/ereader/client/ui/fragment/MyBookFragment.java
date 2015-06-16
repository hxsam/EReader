package com.ereader.client.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.ereader.client.R;
import com.ereader.client.service.AppController;
import com.ereader.client.ui.adapter.MyBookAdapter;
import com.ereader.client.ui.more.MoreActivity;
import com.ereader.common.util.IntentUtil;
import com.ereader.common.util.ToastUtil;

public class MyBookFragment  extends Fragment implements OnClickListener {
	private View view;
	private Context mContext;
	private AppController controller;
	private ListView  lv_mybook;
	private Button main_top_right;
	private Button main_top_left;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.book_my_fragment, container, false);
		controller = AppController.getController(getActivity());
		mContext = getActivity();
		findView();
		initView();
		return view;
	}
	private void findView() {
		lv_mybook = (ListView)view.findViewById(R.id.lv_mybook);
		main_top_right= (Button)view.findViewById(R.id.main_top_right);
		main_top_left= (Button)view.findViewById(R.id.main_top_left_text);
	}
	private void initView() {
		((TextView) view.findViewById(R.id.tv_main_top_title)).setText("用户名");
		main_top_right.setText("充值");
		main_top_left.setText("更多");
		String[] mList  = getResources().getStringArray(R.array.myBook);
		MyBookAdapter adapter = new MyBookAdapter(mContext, mList);
		lv_mybook.setAdapter(adapter);
		main_top_left.setOnClickListener(this);
		main_top_right.setOnClickListener(this);
		lv_mybook.setOnItemClickListener(bookItemListener);
	}
	
	private OnItemClickListener bookItemListener = new  OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			ToastUtil.showToast(mContext, getResources().getStringArray(R.array.myBook)[position], ToastUtil.LENGTH_LONG);
		}
	};
	
	
	
	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case  R.id.main_top_left_text:
			IntentUtil.intent(mContext, MoreActivity.class);
			break;
		default:
			break;
		}
	}

}
