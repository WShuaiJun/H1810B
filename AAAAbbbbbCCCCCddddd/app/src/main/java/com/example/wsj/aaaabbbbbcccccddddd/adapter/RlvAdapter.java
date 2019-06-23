package com.example.wsj.aaaabbbbbcccccddddd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wsj.aaaabbbbbcccccddddd.R;
import com.example.wsj.aaaabbbbbcccccddddd.bean.Bean;

import java.util.List;

public class RlvAdapter extends RecyclerView.Adapter{
    public final List<Bean.DataBean.DatasBean> a;
    private final Context b;
    private OnClickListemen mm;

    public RlvAdapter(List<Bean.DataBean.DatasBean> list, Context context) {
        this.a=list;
        this.b=context;
    }

    public interface OnClickListemen{
        void OnClickement(int position);
    }

    public void setOnClickListemen(OnClickListemen onClickListemen){
        this.mm=onClickListemen;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holder1= (ViewHolder) holder;
        holder1.mTv.setText(a.get(position).getTitle());
        holder1.mTv2.setText(a.get(position).getId()+"");
        Glide.with(b).load(a.get(position).getEnvelopePic()).into(holder1.mIv);
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mm.OnClickement(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return a.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView mIv;
        private final TextView mTv;
        private final TextView mTv2;

        public ViewHolder(View itemView) {
            super(itemView);
            mIv = itemView.findViewById(R.id.iv);
            mTv = itemView.findViewById(R.id.tv1);
            mTv2 = itemView.findViewById(R.id.tv2);
        }
    }
}
