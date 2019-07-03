package com.hp.service;

import com.hp.pojo.ClientUser;
import com.hp.vo.PageObject;

import java.util.List;

public interface ClientUserService {
    List<ClientUser> selectClientUser();
    List<ClientUser> selectClientUserFuzzy(String realname);
    int selectUserCount();
    PageObject<ClientUser> ClientUserSupervise(Integer startPage,Integer pageSize);
}
