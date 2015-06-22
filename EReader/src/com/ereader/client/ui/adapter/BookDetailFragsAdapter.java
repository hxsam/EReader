package com.ereader.client.ui.adapter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ereader.client.ui.bookstore.BookDetailFragment;
import com.ereader.client.ui.bookstore.BookSPFragment;

public class BookDetailFragsAdapter extends FragmentStatePagerAdapter {

	private ArrayList<Fragment> fragments;

	public BookDetailFragsAdapter(FragmentManager fm,int length) {
		super(fm);
		fragments = new ArrayList<Fragment>();
		fragments.add(new BookDetailFragment()); 
		fragments.add(new BookDetailFragment());
		fragments.add(new BookDetailFragment());
		fragments.add(new BookSPFragment());
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
