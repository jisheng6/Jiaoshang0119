package com.bawei.jiaoshang0119.model;


import com.bawei.jiaoshang0119.bean.AddCartBean;

/**
 * Created by Menglucywhh on 2017/12/7.
 */

public interface AddCartModelCallBack {
    public void success(AddCartBean addCartBean);
    public void failure();

}
