package com.ereader.client.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ereader.client.R;
import com.ereader.client.ui.view.TabsAdapter;

public class BookNewAdapter implements TabsAdapter{
	private LayoutInflater inflater;
	public String[] mTitles = { "首页", "推荐", "最新", "娱乐", "设置","更多","原木"};
	
	public BookNewAdapter(Context mContext) {
		inflater=LayoutInflater.from(mContext);
	}
	
	@Override
	public View getView(int position) {
		Button layout = (Button)inflater.inflate(R.layout.book_store_new_tab, null);
		layout.setText(mTitles[position]);
		return layout;
	}
}
