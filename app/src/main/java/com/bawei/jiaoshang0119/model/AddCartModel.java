package com.bawei.jiaoshang0119.model;

import com.bawei.jiaoshang0119.bean.AddCartBean;
import com.bawei.jiaoshang0119.retrofit.MyApp;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Menglucywhh on 2017/12/7.
 */

public class AddCartModel {

  public void getData(String pid,String uid, final AddCartModelCallBack addCartModelCallBack) {
      // https://www.zhaoapi.cn/product/addCart?source=android&uid=1650&pid=57
      //"uid": 1650,
      // "token": "2FC3EF31EA25696D2715A971ADE38DE1",
      //"pid":57

        Map<String,String> map = new HashMap<>();
        map.put("source","android");
        map.put("uid",uid);
        map.put("token","2FC3EF31EA25696D2715A971ADE38DE1");
        map.put("pid",pid);

      MyApp.inters.addCart(map).enqueue(new Callback<AddCartBean>() {
            @Override
            public void onResponse(Call<AddCartBean> call, Response<AddCartBean> response) {
                AddCartBean addCartBean = response.body();
                addCartModelCallBack.success(addCartBean);
            }

            @Override
            public void onFailure(Call<AddCartBean> call, Throwable t) {
                addCartModelCallBack.failure();
            }
        });
    }
}
