package com.hp.service;

import com.hp.pojo.ClientUserWithOrder;
import com.hp.vo.PageObject;

public interface OrderService {
    int getRowCount();
    PageObject<ClientUserWithOrder> getAllOrders(String sort, Integer currentPage, Integer pageSize, String content,String type);
}
