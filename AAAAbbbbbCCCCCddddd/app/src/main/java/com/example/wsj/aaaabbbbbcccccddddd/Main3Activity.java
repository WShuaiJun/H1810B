package com.example.wsj.aaaabbbbbcccccddddd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Main3Activity extends AppCompatActivity {

    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        mIv = findViewById(R.id.iv);
        Intent intent = getIntent();
        String aa = intent.getStringExtra("aa");
        Glide.with(this).load(aa).into(mIv);
    }
}
