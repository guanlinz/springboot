package com.hp.pojo;

import java.io.Serializable;

public class ClientUser implements Serializable {

    private static final long serialVersionUID = -2898061659282589461L;
    private int user_id;
    private String oppen_id;
    private String realname;
    private String add_time;
    private String cityName;
    private String province;
    private String head_img;
    private int status;
    private int integral;
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public String getStatus() {
        if (status == 1){
            return "存在";
        }
        return "注销";
    }

    public void setStatus(int  status) {
        this.status = status;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getOppen_id() {
        return oppen_id;
    }

    public void setOppen_id(String oppen_id) {
        this.oppen_id = oppen_id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
