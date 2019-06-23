package com.example.wsj.androidgaojikaoshi.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.wsj.androidgaojikaoshi.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {


    private WebView mWeb;

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        initView(inflate);
        View inflate1 = inflater.inflate(R.layout.activity_main, null);
        TextView tv = inflate1.findViewById(R.id.tv);
        Toolbar t = inflate1.findViewById(R.id.toolbar);
        tv.setText("aaa");
        t.setTitle("aaa");
        return inflate;
    }

    private void initView(View inflate) {
        mWeb = inflate.findViewById(R.id.web);
        mWeb.loadUrl("https://www.baidu.com/?tn=78040160_15_pg&ch=12");
        mWeb.setWebViewClient(new WebViewClient());
        mWeb.setAddStatesFromChildren(true);

    }
}
