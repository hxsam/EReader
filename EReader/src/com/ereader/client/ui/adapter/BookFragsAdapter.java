package com.ereader.client.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import com.ereader.client.entities.Category;
import com.ereader.client.ui.bookstore.BookFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class BookFragsAdapter extends FragmentStatePagerAdapter {

	private ArrayList<Fragment> fragments;

	public BookFragsAdapter(FragmentManager fm,List<Category> list) {
		super(fm);
		fragments = new ArrayList<Fragment>();
		for (int i = 0; i < list.size(); i++) {
			fragments.add(new BookFragment(list.get(i))); 
		}
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}
}
