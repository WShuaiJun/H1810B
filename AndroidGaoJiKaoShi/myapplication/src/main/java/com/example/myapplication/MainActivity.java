package com.example.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTab = findViewById(R.id.tab);
        mVp = findViewById(R.id.vp);


        mTab.newTab().setCustomView(R.layout.layout);
        mTab.newTab().setCustomView(R.layout.layout);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment2());
        VpAdapter adapter = new VpAdapter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(adapter);
        mTab.setupWithViewPager(mVp);
    }
}
