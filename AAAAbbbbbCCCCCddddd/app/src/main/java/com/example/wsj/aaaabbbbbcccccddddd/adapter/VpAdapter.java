package com.example.wsj.aaaabbbbbcccccddddd.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VpAdapter extends FragmentPagerAdapter{
    private final ArrayList<String> a;
    private final ArrayList<Fragment> b;

    public VpAdapter(FragmentManager fm, ArrayList<String> list, ArrayList<Fragment> fragments) {
        super(fm);
        this.a=list;
        this.b=fragments;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return a.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return b.get(position);
    }

    @Override
    public int getCount() {
        return b.size();
    }
}
