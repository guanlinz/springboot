package com.hp.pojo;


import java.io.Serializable;

public class Order implements Serializable {
    private static final long serialVersionUID = 7112882867233269918L;
    private String order_id;
    private String goods_id;
    private String goods_name;
    private String addr_name;
    private String add_time;
    private int status;
    private String express_dm;
    private String express_name;
    private String express_hm;
    private String oppen_id;

    public String getOppen_id() {
        return oppen_id;
    }

    public void setOppen_id(String oppen_id) {
        this.oppen_id = oppen_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getAddr_name() {
        return addr_name;
    }

    public void setAddr_name(String addr_name) {
        this.addr_name = addr_name;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getExpress_dm() {
        return express_dm;
    }

    public void setExpress_dm(String express_dm) {
        this.express_dm = express_dm;
    }

    public String getExpress_name() {
        return express_name;
    }

    public void setExpress_name(String express_name) {
        this.express_name = express_name;
    }

    public String getExpress_hm() {
        return express_hm;
    }

    public void setExpress_hm(String express_hm) {
        this.express_hm = express_hm;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", goods_id='" + goods_id + '\'' +
                ", addr_name='" + addr_name + '\'' +
                ", add_time='" + add_time + '\'' +
                ", status=" + status +
                ", express_dm='" + express_dm + '\'' +
                ", express_name='" + express_name + '\'' +
                ", express_hm='" + express_hm + '\'' +
                '}';
    }
}
