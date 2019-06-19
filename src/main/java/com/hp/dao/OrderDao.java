package com.hp.dao;

import com.hp.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    List<Order> selAllOrders(@Param("sort") String sort,
                             @Param("startIndex") Integer startIndex,
                             @Param("pageSize") Integer pageSize);
    int selCount();
}
