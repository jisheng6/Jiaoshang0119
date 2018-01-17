package com.bawei.jiaoshang0119.model;

import com.bawei.jiaoshang0119.bean.ShopBean;
import com.bawei.jiaoshang0119.okhttp.AbstractUiCallBack;
import com.bawei.jiaoshang0119.okhttp.OkhttpUtils;
import com.bawei.jiaoshang0119.retrofit.MyApp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2017/12/19.
 */

public class MainModel {

    public void getData(String uid,final MainModelCallBack callBack) {
        MyApp.inters.getCare(uid,"android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShopBean>() {
                    @Override
                    public void accept(ShopBean bean) throws Exception {
                        callBack.success(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

}
