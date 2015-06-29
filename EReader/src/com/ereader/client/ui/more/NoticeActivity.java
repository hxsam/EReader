package com.ereader.client.ui.more;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.ereader.client.R;
import com.ereader.client.service.AppController;
import com.ereader.client.ui.BaseActivity;
import com.ereader.client.ui.adapter.NoticeAdapter;
import com.ereader.common.util.IntentUtil;

public class NoticeActivity extends BaseActivity implements OnClickListener {
	private AppController controller;
	private ListView lv_more_notice;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.more_notice_layout);
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
		lv_more_notice = (ListView)findViewById(R.id.lv_more_notice);
	}
	

	/**
	 * 
	  * 方法描述：初始化 View
	  * @author: why
	  * @time: 2015-2-10 下午1:37:06
	 */
	private void initView() {
		((TextView) findViewById(R.id.tv_main_top_title)).setText("公告");
		List<String> mList = new ArrayList<String>();
		mList.add("");
		mList.add("");
		mList.add("");
		mList.add("");
		mList.add("");
		mList.add("");
		
		NoticeAdapter adapter = new NoticeAdapter(this,mList);
		lv_more_notice.setAdapter(adapter);
		lv_more_notice.setOnItemClickListener(noticeItemListener);
	}
	
	private OnItemClickListener noticeItemListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			IntentUtil.intent(NoticeActivity.this,NoticeDetailActivity.class);
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
}
