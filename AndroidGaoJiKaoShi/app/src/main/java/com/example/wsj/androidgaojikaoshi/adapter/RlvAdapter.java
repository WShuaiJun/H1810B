package com.example.wsj.androidgaojikaoshi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wsj.androidgaojikaoshi.R;
import com.example.wsj.androidgaojikaoshi.bean.Bean;

import java.util.List;

public class RlvAdapter extends RecyclerView.Adapter {
    private final Context mContext;
    private final List<Bean.DataBean.DatasBean> mData;
    private OnLongClickListement mListement;

    public RlvAdapter(Context context, List<Bean.DataBean.DatasBean> list) {
        this.mContext=context;
        this.mData=list;
    }

    public interface OnLongClickListement{
        void OnLongClick(int position);
    }

    public void setOnLongClickListement(OnLongClickListement listement){
        this.mListement=listement;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null, false);
        return new ViewHoldr(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
            ViewHoldr holdr= (ViewHoldr) holder;
            holdr.mTv.setText(mData.get(position).getAuthor());
        Glide.with(mContext).load(mData.get(position).getEnvelopePic()).into(holdr.mIv);
        holdr.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mListement.OnLongClick(position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHoldr extends RecyclerView.ViewHolder{

        private final ImageView mIv;
        private final TextView mTv;

        public ViewHoldr(View itemView) {
            super(itemView);
            mIv = itemView.findViewById(R.id.iv);
            mTv = itemView.findViewById(R.id.tv);
        }
    }
}
