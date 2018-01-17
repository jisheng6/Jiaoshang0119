package com.bawei.jiaoshang0119.present;

import com.bawei.jiaoshang0119.bean.ShopBean;
import com.bawei.jiaoshang0119.model.MainModel;
import com.bawei.jiaoshang0119.model.MainModelCallBack;
import com.bawei.jiaoshang0119.view.MainViewListener;

/**
 * Created by Adminjs on 2017/12/19.
 */

public class MainPresente {
    private MainViewListener listener;
    private MainModel mainModel;

    public MainPresente(MainViewListener listener) {
        this.listener = listener;
        this.mainModel = new MainModel();
    }

    public void getData(String uid){
        mainModel.getData(uid,new MainModelCallBack() {
            @Override
            public void success(ShopBean bean) {
                if (listener != null){
                    listener.success(bean);
                }
            }

            @Override
            public void failure(Exception e) {
                if (listener != null){
                    listener.failure(e);
                }
            }
        });
    }
    public void detach(){
        listener = null;
    }
}
