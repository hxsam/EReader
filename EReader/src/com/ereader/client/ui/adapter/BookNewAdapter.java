package com.ereader.client.ui.adapter;

import com.ereader.client.R;
import com.ereader.client.ui.view.TabsAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class BookNewAdapter implements TabsAdapter{
	private LayoutInflater inflater;
	public String[] mTitles = { "首页", "推荐", "最新", "娱乐", "设置" };
	
	public BookNewAdapter(Context mContext) {
		inflater=LayoutInflater.from(mContext);
	}
	
	@Override
	public View getView(int position) {
		TextView title = (TextView)inflater.inflate(R.layout.book_my_item, null).findViewById(R.id.tv_book_title);
		title.setText(mTitles[position]);
		return title;
	}
}
