package com.ereader.client.ui.buycar;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.ereader.client.R;
import com.ereader.client.service.AppController;
import com.ereader.client.ui.BaseActivity;
import com.ereader.client.ui.adapter.BuyCarAdapter;

// 购物车
public class BuyCarActivity extends BaseActivity implements OnClickListener {
	private AppController controller;
	private TextView textView1;
	private ListView lv_buy_car;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buy_car_layout);
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
		lv_buy_car = (ListView)findViewById(R.id.lv_buy_car);
		textView1 = (TextView)findViewById(R.id.textView1);
	}
	

	/**
	 * 
	  * 方法描述：初始化 View
	  * @author: why
	  * @time: 2015-2-10 下午1:37:06
	 */
	private void initView() {
		((TextView) findViewById(R.id.tv_main_top_title)).setText("购物车");
		textView1.setOnClickListener(this);
		List<String> list = new ArrayList<String>();
		list.add("ttt");
		list.add("ttt");
		list.add("ttt");
		list.add("ttt");
		BuyCarAdapter adapter = new BuyCarAdapter(this, list);
		lv_buy_car.setAdapter(adapter);
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
