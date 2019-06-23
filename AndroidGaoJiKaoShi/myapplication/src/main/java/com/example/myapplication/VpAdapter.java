package com.example.myapplication;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VpAdapter extends FragmentPagerAdapter{


    private final ArrayList<Fragment> mFragment;

    public VpAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.mFragment=fragments;
    }



    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }
}
