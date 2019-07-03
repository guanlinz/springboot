package com.hp.service.imp;

import com.hp.dao.ClientUserDao;
import com.hp.pojo.ClientUser;
import com.hp.service.ClientUserService;
import com.hp.vo.PageObject;
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

    @Override
    public List<ClientUser> selectClientUserFuzzy(String realname) {
        return clientUserDao.selectClientUserFuzzy(realname);
    }

    @Override
    public int selectUserCount() {
        return clientUserDao.selectUserCount();
    }

    @Override
    public PageObject<ClientUser> ClientUserSupervise(Integer startPage, Integer pageSize) {
        int rowCount = clientUserDao.selectUserCount();
        int startIndex = (startPage - 1) * pageSize;
        int pageCount = rowCount/pageSize;
        if (rowCount % pageSize != 0){
            pageCount++;
        }
        List<ClientUser> clientUsers = clientUserDao.ClientUserSupervise(startIndex,pageSize);
        PageObject<ClientUser> pageObject = new PageObject<>();
        pageObject.setItems(clientUsers);
        pageObject.setPageCurrent(startPage);
        pageObject.setPageCount(pageCount);
        pageObject.setTotal(rowCount);
        return pageObject;
    }
}
