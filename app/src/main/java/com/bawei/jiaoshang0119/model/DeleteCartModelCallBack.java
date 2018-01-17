package com.bawei.jiaoshang0119.model;

import com.bawei.jiaoshang0119.bean.DeleteBean;

/**
 * Created by Menglucywhh on 2017/12/11.
 */

public interface DeleteCartModelCallBack {
    public void success(DeleteBean deleteBean);
    public void failure();
}
