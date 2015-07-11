package com.ereader.client.ui.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ereader.client.R;
import com.ereader.client.entities.Category;
import com.ereader.client.ui.view.TabsAdapter;

public class BookTabsAdapter implements TabsAdapter{
	private LayoutInflater inflater;
	public List<Category> mlist;
	
	public BookTabsAdapter(Context mContext,List<Category> mlist) {
		inflater=LayoutInflater.from(mContext);
		this.mlist = mlist;
	}
	
	@Override
	public View getView(int position) {
		Button layout = (Button)inflater.inflate(R.layout.book_store_new_tab, null);
		layout.setText(mlist.get(position).getName());
		return layout;
	}
}
