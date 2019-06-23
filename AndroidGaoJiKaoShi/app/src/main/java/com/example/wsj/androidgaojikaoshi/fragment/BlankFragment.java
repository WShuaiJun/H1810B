package com.example.wsj.androidgaojikaoshi.fragment;


import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.wsj.androidgaojikaoshi.R;
import com.example.wsj.androidgaojikaoshi.adapter.RlvAdapter;
import com.example.wsj.androidgaojikaoshi.bean.Bean;
import com.example.wsj.androidgaojikaoshi.model.ImpModel;
import com.example.wsj.androidgaojikaoshi.preseter.ImpPreseter;
import com.example.wsj.androidgaojikaoshi.view.MyView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements MyView {


    private RecyclerView mRlv;
    private TextView mTv;
    private View mInflate;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);
        FragmentActivity activity = getActivity();
        View inflate1 = inflater.inflate(R.layout.activity_main, null);
        TextView tv = inflate1.findViewById(R.id.tv);
        Toolbar t = inflate1.findViewById(R.id.toolbar);
        tv.setText("aaa");
        t.setTitle("aaa");
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRlv = inflate.findViewById(R.id.rlv);
        mTv = inflate.findViewById(R.id.tv);
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        ImpPreseter impPreseter = new ImpPreseter(new ImpModel(), this);
        impPreseter.getData();
    }

    @Override
    public void view(Bean bean) {
        List<Bean.DataBean.DatasBean> list = bean.getData().getDatas();
        Log.d("TAG", "数据：" + list.toString());
        RlvAdapter adapter = new RlvAdapter(getContext(), list);
        mRlv.setAdapter(adapter);

        adapter.setOnLongClickListement(new RlvAdapter.OnLongClickListement() {
            @Override
            public void OnLongClick(int position) {
                final PopupWindow popupWindow = new PopupWindow(getContext());
                mInflate = LayoutInflater.from(getContext()).inflate(R.layout.popwindow, null, false);
                popupWindow.setContentView(mInflate);
                popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAtLocation(mRlv,Gravity.CENTER,0,0);



                Button bt = mInflate.findViewById(R.id.bt);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        download();
                    }
                });
            }
        });
    }

    private void download() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .get()
                .url("http://cdn.banmi.com/banmiapp/apk/banmi_330.apk")
                .build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                InputStream inputStream = response.body().byteStream();
                save(inputStream, Environment.getExternalStorageDirectory() + "/cctv.apk", body.contentLength());
            }
        });
    }

    private void save(InputStream inputStream, String s, final long l) {
        long count = 0;
        try {
            FileOutputStream outputStream = new FileOutputStream(s);
            int length = -1;
            byte[] bytes = new byte[1024 * 10];
            while ((length = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
                count += length;
                Log.d("下载", "下载进度： " + count + "max:" + l);

                final long finalCount = count;
                final long finalCount1 = count;
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ProgressBar pb = mInflate.findViewById(R.id.pb);
                        TextView tv = mInflate.findViewById(R.id.tv);
                        pb.setMax((int) l);
                        pb.setProgress((int) finalCount1);
                        int l1 = (int) (100 * finalCount / l);
                        tv.setText("下载进度： " + l1 + "%");
                    }
                });
            }

            inputStream.close();
            outputStream.close();
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
        Toast.makeText(getContext(), "下载完成", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
