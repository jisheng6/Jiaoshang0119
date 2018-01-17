package com.bawei.jiaoshang0119.bean;

import java.util.List;

/**
 * Created by Menglucywhh on 2017/11/20.
 */
public class DingdanBean {

    /**
     * msg : 请求成功
     * code : 0
     * data : [{"createtime":"2017-10-19T20:28:43","orderid":20,"price":100,"status":1,"title":"订单标题测试3","uid":71},{"createtime":"2017-11-09T09:17:20","orderid":1446,"price":99.99,"status":1,"title":"订单标题测试","uid":71},{"createtime":"2017-11-09T09:20:58","orderid":1451,"price":999,"status":1,"title":"订单标题测试","uid":71},{"createtime":"2017-11-09T09:20:58","orderid":1452,"price":189,"status":1,"title":"订单标题测试","uid":71},{"createtime":"2017-11-09T09:20:58","orderid":1453,"price":126,"status":1,"title":"订单标题测试","uid":71},{"createtime":"2017-11-09T09:20:58","orderid":1457,"price":158,"status":1,"title":"订单标题测试","uid":71},{"createtime":"2017-11-09T09:22:41","orderid":1458,"price":999,"status":1,"title":"订单测试标题","uid":71},{"createtime":"2017-11-09T09:22:41","orderid":1463,"price":99.99,"status":1,"title":"订单测试标题","uid":71},{"createtime":"2017-11-09T09:22:41","orderid":1464,"price":156,"status":1,"title":"订单测试标题","uid":71},{"createtime":"2017-11-09T09:22:41","orderid":1465,"price":256,"status":1,"title":"订单测试标题","uid":71}]
     * page : 1
     */

    private String msg;
    private String code;
    private String page;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createtime : 2017-10-19T20:28:43
         * orderid : 20
         * price : 100.0
         * status : 1
         * title : 订单标题测试3
         * uid : 71
         */

        private String createtime;
        private int orderid;
        private double price;
        private int status;
        private String title;
        private int uid;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getOrderid() {
            return orderid;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
