package com.hp.dao;

import com.hp.pojo.ClientUser;
import com.hp.vo.PageObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientUserDao {
    List<ClientUser> selectClientUser();
    int selectUserCount();
    ClientUser selectClientUserByOpenid(@Param("openid") String openid);
    ClientUser selectClientUserByRealName(@Param("realname") String realname);
    List<ClientUser> selectClientUserFuzzy(@Param("realname") String realname);
    List<ClientUser> ClientUserSupervise(@Param("startIndex") Integer startIndex,
                                               @Param("pageSize") Integer pageSize);

}
