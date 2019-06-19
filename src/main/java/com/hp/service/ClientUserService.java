package com.hp.service;

import com.hp.pojo.ClientUser;

import java.util.List;

public interface ClientUserService {
    List<ClientUser> selectClientUser();
    int selectUserCount();
}
