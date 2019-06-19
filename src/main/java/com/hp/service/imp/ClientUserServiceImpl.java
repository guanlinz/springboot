package com.hp.service.imp;

import com.hp.dao.ClientUserDao;
import com.hp.pojo.ClientUser;
import com.hp.service.ClientUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientUserServiceImpl implements ClientUserService {

    @Autowired
    private ClientUserDao clientUserDao;

    @Override
    public List<ClientUser> selectClientUser() {
        return clientUserDao.selectClientUser();
    }
}
