package com.bawei.jiaoshang0119.present;


import com.bawei.jiaoshang0119.bean.AddCartBean;
import com.bawei.jiaoshang0119.view.AddCartViewCallBack;
import com.bawei.jiaoshang0119.model.AddCartModel;
import com.bawei.jiaoshang0119.model.AddCartModelCallBack;

/**
 * Created by Menglucywhh on 2017/12/7.
 */

public class AddCartPresenter {
    AddCartModel addCartModel = new AddCartModel();

    AddCartViewCallBack addCartViewCallBack;
    public AddCartPresenter(AddCartViewCallBack addCartViewCallBack) {
        this.addCartViewCallBack = addCartViewCallBack;
    }


    public void getData(String pid,String uid) {

        addCartModel.getData(pid,uid, new AddCartModelCallBack() {
            @Override
            public void success(AddCartBean addCartBean) {
                addCartViewCallBack.success(addCartBean);
            }

            @Override
            public void failure() {
                addCartViewCallBack.failure();
            }
        });

    }
}
