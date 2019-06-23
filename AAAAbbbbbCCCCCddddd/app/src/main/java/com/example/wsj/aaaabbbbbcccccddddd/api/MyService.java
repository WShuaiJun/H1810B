package com.example.wsj.aaaabbbbbcccccddddd.api;

import com.example.wsj.aaaabbbbbcccccddddd.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyService {
    String Url="https://www.wanandroid.com/";
//    http://cdn.banmi.com/banmiapp/apk/banmi_330.apk
    @GET("project/list/1/json?cid=294")
    Observable<Bean> getData();


}
