package com.bawei.jiaoshang0119.present;


import com.bawei.jiaoshang0119.bean.DeleteBean;
import com.bawei.jiaoshang0119.model.DeleteCartModel;
import com.bawei.jiaoshang0119.model.DeleteCartModelCallBack;
import com.bawei.jiaoshang0119.view.DeleteCartViewCallBack;

/**
 * Created by Menglucywhh on 2017/12/11.
 */

public class DeleteCartPresenter {

    DeleteCartModel deleteCartModel = new DeleteCartModel();
    DeleteCartViewCallBack deleteCartViewCallBack;
    public DeleteCartPresenter(DeleteCartViewCallBack deleteCartViewCallBack) {
        this.deleteCartViewCallBack = deleteCartViewCallBack;
    }

    public void delete(String pid,String uid) {
        deleteCartModel.delete(pid,uid, new DeleteCartModelCallBack() {
            @Override
            public void success(DeleteBean deleteBean) {
            deleteCartViewCallBack.success(deleteBean);
            }

            @Override
            public void failure() {
            deleteCartViewCallBack.failure();
            }
        });
    }
}
