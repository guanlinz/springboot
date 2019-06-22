package com.hp.service;

import com.hp.pojo.ClientUser;

import java.util.List;

public interface ClientUserService {
    List<ClientUser> selectClientUser();
    List<ClientUser> selectClientUserFuzzy(String realname);
    int selectUserCount();
}
