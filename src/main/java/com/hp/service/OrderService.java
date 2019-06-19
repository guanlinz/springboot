package com.hp.service;

import com.hp.pojo.Order;
import com.hp.vo.PageObject;

import java.util.List;

public interface OrderService {
    int getRowCount();
    PageObject<Order> getAllOrders(String sort, Integer currentPage, Integer pageSize);
}
