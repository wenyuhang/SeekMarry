package com.wl.seekmarry.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ${温宇航} on 2018/5/27.
 * fragment适配器
 */

public class MyPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public MyPageAdapter(List<Fragment> fragments,FragmentManager fm) {
        super(fm);
        this.fragments =fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
