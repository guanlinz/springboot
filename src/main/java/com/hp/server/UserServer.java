package com.hp.server;

import com.hp.pojo.User;
import com.hp.pojo.UserPower;

import java.util.List;

public interface UserServer {

    User selectUser(User user);
    List<UserPower> selectUserPower(UserPower userPower);
}
