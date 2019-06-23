package com.example.wsj.aaaabbbbbcccccddddd.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.wsj.aaaabbbbbcccccddddd.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {


    private WebView mWeb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mWeb = inflate.findViewById(R.id.web);
        mWeb.loadUrl("http://www.ysxs8.com/yousheng/6193_7.html");
        mWeb.setWebViewClient(new WebViewClient());
        mWeb.setAddStatesFromChildren(true);
    }
}
