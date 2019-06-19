package com.hp.service.imp;

import com.hp.dao.UserDao;
import com.hp.dao.UserPowerDao;
import com.hp.pojo.User;
import com.hp.pojo.UserPower;
import com.hp.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServerImpl implements UserServer {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserPowerDao userPowerDao;

    @Override
    public User selectUser(User user) {
        return userDao.selectUser(user) ;
    }

    @Override
    public List<UserPower> selectUserPower(UserPower userPower) {
        return userPowerDao.selectUserPower(userPower);
    }
}
