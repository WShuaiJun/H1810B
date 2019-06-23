package com.example.wsj.androidgaojikaoshi.preseter;

import com.example.wsj.androidgaojikaoshi.bean.Bean;
import com.example.wsj.androidgaojikaoshi.callback.CallBack;
import com.example.wsj.androidgaojikaoshi.model.ImpModel;
import com.example.wsj.androidgaojikaoshi.view.MyView;

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
