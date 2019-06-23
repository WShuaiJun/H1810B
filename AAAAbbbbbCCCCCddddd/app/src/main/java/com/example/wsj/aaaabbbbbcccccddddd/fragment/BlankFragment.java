package com.example.wsj.aaaabbbbbcccccddddd.fragment;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wsj.aaaabbbbbcccccddddd.Main2Activity;
import com.example.wsj.aaaabbbbbcccccddddd.Main3Activity;
import com.example.wsj.aaaabbbbbcccccddddd.R;
import com.example.wsj.aaaabbbbbcccccddddd.adapter.RlvAdapter;
import com.example.wsj.aaaabbbbbcccccddddd.bean.Bean;
import com.example.wsj.aaaabbbbbcccccddddd.model.ImpModel;
import com.example.wsj.aaaabbbbbcccccddddd.preseter.ImpPreseter;
import com.example.wsj.aaaabbbbbcccccddddd.view.MyView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements MyView {

    private RecyclerView mRlv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRlv = inflate.findViewById(R.id.rlv);
        ImpPreseter impPreseter = new ImpPreseter(new ImpModel(), this);
        impPreseter.getData();
    }

    @Override
    public void view(Bean bean) {
        List<Bean.DataBean.DatasBean> list = bean.getData().getDatas();

        final RlvAdapter adapter = new RlvAdapter(list,getContext());
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        mRlv.setAdapter(adapter);
        adapter.setOnClickListemen(new RlvAdapter.OnClickListemen() {
            @Override
            public void OnClickement(int position) {
                /*Notification notification = new Notification();
                Intent inte=new Intent(getContext(),Main3Activity.class);
                PendingIntent intent=PendingIntent.getActivity(getContext(),11,inte,PendingIntent.FLAG_CANCEL_CURRENT);
                Notification build = new NotificationCompat.Builder(getContext(), "11")
                        .setContentTitle("通知")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setPublicVersion(notification)
                        .setContentIntent(intent)
                        .build();*/
                int id = adapter.a.get(position).getId();
                if (id%2==0){
                    startActivity(new Intent(getContext(), Main2Activity.class));
                }else {
                    Intent intent = new Intent(getContext(), Main3Activity.class);
                    intent.putExtra("aa",adapter.a.get(position).getEnvelopePic());
                    startActivity(intent);
                }
            }
        });
    }
}
