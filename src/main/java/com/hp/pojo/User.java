package com.hp.pojo;

import java.io.Serializable;

public class User implements Serializable {


    private static final long serialVersionUID = 4569824782919360473L;
    private int id;
    private String userName;
    private int passWord;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public int getPassWord() {
        return passWord;
    }

    public void setPassWord(int passWord) {
        this.passWord = passWord;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
