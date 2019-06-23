package com.example.wsj.androidgaojikaoshi;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wsj.androidgaojikaoshi.adapter.VpAdapter;
import com.example.wsj.androidgaojikaoshi.fragment.BlankFragment;
import com.example.wsj.androidgaojikaoshi.fragment.BlankFragment2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTab;
    private Toolbar mToolbar;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mVp = findViewById(R.id.vp);
        mTab = findViewById(R.id.tab);
        mToolbar = findViewById(R.id.toolbar);
        mTv = findViewById(R.id.tv);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mTv.setText("123");
        ArrayList<String> list = new ArrayList<>();
        list.add("首页");
        list.add("网页");
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment2());
        VpAdapter adapter = new VpAdapter(getSupportFragmentManager(), list, fragments);
        mVp.setAdapter(adapter);
        mTab.setupWithViewPager(mVp);


        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getPosition()){
                    case 0:
                        Toast.makeText(MainActivity.this,"12",Toast.LENGTH_SHORT).show();
                        mTv.setText("首页");
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this,"aaa",Toast.LENGTH_SHORT).show();
                        mTv.setText("网页");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
