package com.example.wsj.aaaabbbbbcccccddddd.preseter;

import com.example.wsj.aaaabbbbbcccccddddd.bean.Bean;
import com.example.wsj.aaaabbbbbcccccddddd.callback.CallBack;
import com.example.wsj.aaaabbbbbcccccddddd.model.ImpModel;
import com.example.wsj.aaaabbbbbcccccddddd.view.MyView;

public class ImpPreseter implements MyPreseter, CallBack {
    private ImpModel mImpModel;
    private MyView mMyView;

    public ImpPreseter(ImpModel impModel, MyView myView) {
        mImpModel = impModel;
        mMyView = myView;
    }

    @Override
    public void getData() {
        if (mImpModel!=null){
            mImpModel.model(this);
        }
    }

    @Override
    public void callback(Bean bean) {
        mMyView.view(bean);
    }
}
