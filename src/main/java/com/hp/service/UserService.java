package com.hp.service;

import com.hp.pojo.User;
import com.hp.pojo.UserPower;
import com.hp.vo.FaceResult;


import java.util.List;

public interface UserService {

    User selectUser(User user);
    List<UserPower> selectUserPower(UserPower userPower);
    FaceResult faceLogin(User user, String snapData);
    boolean faceRegister(User user,String snapData);
}
