package com.bawei.jiaoshang0119.model;

import com.bawei.jiaoshang0119.bean.DeleteBean;
import com.bawei.jiaoshang0119.retrofit.MyApp;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Menglucywhh on 2017/12/11.
 */

public class DeleteCartModel {

    public void delete(String pid,String uid, final DeleteCartModelCallBack deleteCartModelCallBack) {
        //https://www.zhaoapi.cn/product/deleteCart?uid=1650&pid=58
        Map<String,String> map = new HashMap<>();
        map.put("source","android");
        map.put("uid",uid);
        map.put("pid",pid);

        MyApp.inters.deleteCart(map).enqueue(new Callback<DeleteBean>() {
            @Override
            public void onResponse(Call<DeleteBean> call, Response<DeleteBean> response) {
                DeleteBean deleteBean = response.body();
                deleteCartModelCallBack.success(deleteBean);
            }

            @Override
            public void onFailure(Call<DeleteBean> call, Throwable t) {
                deleteCartModelCallBack.failure();
            }
        });
    }

}
