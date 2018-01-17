package com.bawei.jiaoshang0119.view;


import com.bawei.jiaoshang0119.bean.DingdanBean;

/**
 * Created by Menglucywhh on 2017/11/20.
 */
public interface MyViewCallBack {
    public void viewSuccess(DingdanBean dingdanBean);
    public void viewFail(Exception e);
}
