package com.bawei.jiaoshang0119.retrofit;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Adminjs on 2017/12/21.
 */

public class MyApp extends Application{
    public static IGetDataBase inters;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://120.27.23.105")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        inters = retrofit.create(IGetDataBase.class);
    }
}
