package com.ereader.client.ui.adapter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class FragsNewAdapter extends FragmentStatePagerAdapter {

	private ArrayList<Fragment> fragments;

	public FragsNewAdapter(FragmentManager fm) {
		super(fm);
		/*fragments = new ArrayList<Fragment>();
		for (int i = 0; i < scrollingTabsAdapter.mTitles.length; i++) {
			fragments.add(new MyFragment(i));
		}*/
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
