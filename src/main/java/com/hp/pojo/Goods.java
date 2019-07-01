package com.hp.pojo;

import java.io.Serializable;

public class Goods implements Serializable {
    private static final long serialVersionUID = 8925018312158880473L;
    private String goods_id;
    private String goods_name;
    private String goods_spe;
    private String goods_price;
    private String goods_img;
    private String add_time;
    private String type;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_spe() {
        return goods_spe;
    }

    public void setGoods_spe(String goods_spe) {
        this.goods_spe = goods_spe;
    }

    public String getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(String goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods_id" +goods_id+
                ",goods_name"+ goods_name+
                ",goods_spe"+goods_spe+
                ",goods_price"+ goods_price+
                ",goods_img"+goods_img+
                ",goods_addtime"+
                "}";
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
