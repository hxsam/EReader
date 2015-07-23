package com.ereader.client.ui.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.ereader.client.R;
import com.ereader.client.entities.Book;

public class BuyCarAdapter extends BaseAdapter {
	private LayoutInflater inflater;
	private List<Book> mList ;

	public BuyCarAdapter(Context mContext,List<Book>  list) {
		inflater=LayoutInflater.from(mContext);
		mList = list;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Book book = mList.get(position);
		ViewHolder holder;
		if(convertView == null){
			convertView =inflater.inflate(R.layout.buy_car_item, null);
			holder = new ViewHolder();
			holder.findView(convertView);
			convertView.setTag(holder);
		}else {
			holder=(ViewHolder) convertView.getTag();
		}	
		holder.cbox_buy_choose.setSelected(book.isSelect());
		holder.tv_book_name.setText(book.getInfo().getName());
		holder.tv_book_money.setText("￥"+book.getPrice());
		return convertView;
	}
	class ViewHolder{
		private TextView tv_book_name; 
		private TextView tv_book_money;
		private ImageView iv_book;
		private CheckBox cbox_buy_choose;
		
		public void findView(View view){
			tv_book_name = (TextView)view.findViewById(R.id.tv_book_name);
			tv_book_money = (TextView)view.findViewById(R.id.tv_book_money);
			iv_book = (ImageView)view.findViewById(R.id.iv_book);
			cbox_buy_choose = (CheckBox)view.findViewById(R.id.cbox_buy_choose);
		}
	}

}
