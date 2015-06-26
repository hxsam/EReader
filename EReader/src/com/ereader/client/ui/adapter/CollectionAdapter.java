package com.ereader.client.ui.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.ereader.client.R;
import com.ereader.common.util.ToastUtil;

public class CollectionAdapter extends BaseAdapter {
	private LayoutInflater inflater;
	private List<String> mList ;
	private Context mContext;

	public CollectionAdapter(Context mContext,List<String>  list) {
		inflater=LayoutInflater.from(mContext);
		mList = list;
		this.mContext = mContext;
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
		ViewHolder holder;
		if(convertView == null){
			convertView =inflater.inflate(R.layout.my_collection_item, null);
			holder = new ViewHolder();
			holder.findView(convertView);
			convertView.setTag(holder);
		}else {
			holder=(ViewHolder) convertView.getTag();
		}	
		holder.tv_collection_buycar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ToastUtil.showToast(mContext, "添加购物车成功", ToastUtil.LENGTH_LONG);
			}
		});
		return convertView;
	}
	class ViewHolder{
		private Button tv_collection_buycar;
		public void findView(View view){
			tv_collection_buycar = (Button)view.findViewById(R.id.tv_collection_buycar);
		}
	}

}