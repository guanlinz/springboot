package com.hp.dao;

import com.hp.pojo.ClientUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientUserDao {

    List<ClientUser> selectClientUser();
    int selectUserCount();
    ClientUser selectClientUserByOpenid(@Param("openid") String openid);

}
