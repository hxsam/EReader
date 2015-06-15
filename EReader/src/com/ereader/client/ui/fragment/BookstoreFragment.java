package com.ereader.client.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ereader.client.R;
import com.ereader.client.service.AppController;

public class BookstoreFragment  extends Fragment{
	private View view;
	private Context mContext;
	private AppController controller;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.book_shelf_fragment, container, false);
		controller = AppController.getController(getActivity());
		mContext = getActivity();
		findView();
		initView();
		return view;
	}
	private void findView() {
		
	}
	private void initView() {
		((TextView) view.findViewById(R.id.tv_main_top_title)).setText("书城");
	}

}
