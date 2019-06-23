package com.example.myapplication22;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private Button mBt;

    //    https://api.apiopen.top/getJoke?page=1&count=2&type=video
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBt = findViewById(R.id.bt);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)//设置连接时间
                .readTimeout(5,TimeUnit.SECONDS)//设置读取时间
                .writeTimeout(5,TimeUnit.SECONDS)//设置写出时间
                .build();

        FormBody body = new FormBody.Builder()
                .add("page", "1")
                .add("count", "2")
                .add("type", "video")
                .build();


        Request request = new Request.Builder()
                .url("https://api.apiopen.top/getJoke?")
                .addHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8")
                .header("User-Agent","OkHttp Example")
                .post(body)
                .build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.d("TAG", "" +response.protocol()+
                        "\n" +response.code()+
                        "\n" +response.message()+
                        "\n"+"数据------------"+string);
            }
        });
    }
}
