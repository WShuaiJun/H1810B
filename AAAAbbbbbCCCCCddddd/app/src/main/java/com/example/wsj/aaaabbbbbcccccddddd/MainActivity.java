package com.example.wsj.aaaabbbbbcccccddddd;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.wsj.aaaabbbbbcccccddddd.adapter.VpAdapter;
import com.example.wsj.aaaabbbbbcccccddddd.fragment.BlankFragment;
import com.example.wsj.aaaabbbbbcccccddddd.fragment.BlankFragment2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVp = findViewById(R.id.vp);
        mTab = findViewById(R.id.tab);

        ArrayList<String> list = new ArrayList<>();
        ArrayList<Fragment> fragments = new ArrayList<>();
        list.add("首页");
        list.add("网页");
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment2());

        VpAdapter adapter = new VpAdapter(getSupportFragmentManager(),list,fragments);
        mVp.setAdapter(adapter);
        mTab.setupWithViewPager(mVp);

    }
}
