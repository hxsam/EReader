package com.ereader.client.ui.my;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.ereader.client.R;
import com.ereader.client.entities.Book;
import com.ereader.client.service.AppController;
import com.ereader.client.ui.BaseActivity;
import com.ereader.client.ui.adapter.CollectionAdapter;
import com.ereader.common.util.ProgressDialogUtil;
import com.ereader.common.util.ToastUtil;

// 我的收藏
public class CollectionActivity extends BaseActivity implements OnClickListener {
	private AppController controller;
	private ListView lv_my_collection;
	private CollectionAdapter adapter;
	private List<Book> mList = new ArrayList<Book>();
	private Handler mHandler = new Handler(){
		
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) { 
			case 0:
				mList.addAll((List<Book>)controller.getContext().getBusinessData("CollectionResp"));
				adapter.notifyDataSetChanged();
				break;
			case 1: // 删除
				mList.remove(mList.get((int)msg.what));
				adapter.notifyDataSetChanged();
				ToastUtil.showToast(CollectionActivity.this, "删除成功", ToastUtil.LENGTH_LONG);
				break;
			default:
				break;
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_collection_layout);
		controller = AppController.getController(this);
		findView();
		initView();
		getCollection();
	}

	private void getCollection() {
		ProgressDialogUtil.showProgressDialog(this, "努力加载中…", false);
		new Thread(new Runnable() {
			@Override
			public void run() {
				controller.getCollection(mHandler);
				ProgressDialogUtil.closeProgressDialog();
			}
		}).start();
	}
	/**
	 * 
	  * 方法描述：FindView
	  * @author: why
	  * @time: 2015-2-10 下午1:37:06
	 */
	private void findView() {
		lv_my_collection = (ListView)findViewById(R.id.lv_my_collection);
	}
	/**
	  * 方法描述：初始化 View
	  * @author: why
	  * @time: 2015-2-10 下午1:37:06
	 */
	private void initView() {
		((TextView) findViewById(R.id.tv_main_top_title)).setText("我的收藏");
		adapter = new CollectionAdapter(this,mHandler,mList);
		lv_my_collection.setAdapter(adapter);
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
