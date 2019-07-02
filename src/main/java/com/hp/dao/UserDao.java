package com.hp.dao;

import com.hp.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User selectUserByFace(User user);
    User selectUser(User user);
    int insertNewUser(User user);
}
