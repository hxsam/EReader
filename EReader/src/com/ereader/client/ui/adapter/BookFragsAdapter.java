package com.ereader.client.ui.adapter;

import java.util.ArrayList;

import com.ereader.client.ui.bookstore.BookFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class BookFragsAdapter extends FragmentStatePagerAdapter {

	private ArrayList<Fragment> fragments;

	public BookFragsAdapter(FragmentManager fm,int length) {
		super(fm);
		fragments = new ArrayList<Fragment>();
		for (int i = 0; i < length; i++) {
			fragments.add(new BookFragment()); 
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
