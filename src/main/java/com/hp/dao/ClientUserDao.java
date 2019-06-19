package com.hp.dao;

import com.hp.pojo.ClientUser;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientUserDao {

    List<ClientUser> selectClientUser();
}
