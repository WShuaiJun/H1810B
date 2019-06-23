package com.example.wsj.androidgaojikaoshi.api;

import com.example.wsj.androidgaojikaoshi.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyService {
    String Url="https://www.wanandroid.com/";
    @GET("project/list/1/json?cid=294")
    Observable<Bean> getData();
}
