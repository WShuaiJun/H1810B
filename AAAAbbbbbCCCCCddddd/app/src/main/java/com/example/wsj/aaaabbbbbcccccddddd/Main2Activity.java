package com.example.wsj.aaaabbbbbcccccddddd;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class Main2Activity extends AppCompatActivity {

    private ProgressBar mPb;
    private TextView mTv;
    private Button mBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mPb = findViewById(R.id.pb);
        mTv = findViewById(R.id.tv);
        mBt = findViewById(R.id.bt);
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aaa();
            }
        });
    }

    private void aaa() {
        OkHttpClient build = new OkHttpClient.Builder().build();

        Request request = new Request.Builder()
                .url("http://cdn.banmi.com/banmiapp/apk/banmi_330.apk")
                .get()
                .build();

        Call call = build.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                InputStream inputStream = response.body().byteStream();
                save(inputStream, Environment.getExternalStorageDirectory()+"/ll.apk",body.contentLength());
            }
        });
    }

    private void save(InputStream inputStream, String s, final long l) {
        long count=0;
        try {
            FileOutputStream outputStream = new FileOutputStream(s);
            int length=-1;
            byte[] bytes = new byte[1024 * 10];
            while ((length=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,length);
                count+=length;
                final int a=(int)(count/l)*100;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTv.setText("下载进度："+a+"%");
                    }
                });
                Log.d("TAG", "下载进度："+count+"   max:"+l);
            }
            outputStream.close();
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
