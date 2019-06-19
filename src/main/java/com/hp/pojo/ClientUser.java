package com.hp.pojo;

import javax.xml.crypto.Data;

public class ClientUser {

    private int user_id;
    private String oppen_id;
    private String realname;
    private String add_time;
    private String cityName;


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
}
