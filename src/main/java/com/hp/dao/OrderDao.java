package com.hp.dao;

import com.hp.pojo.ClientUser;
import com.hp.pojo.ClientUserWithOrder;
import com.hp.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    List<ClientUserWithOrder> selAllOrders(@Param("sort") String sort,
                                           @Param("startIndex") Integer startIndex,
                                           @Param("pageSize") Integer pageSize,
                                           @Param("title") String title,
                                           @Param("type") String type);
    int selCount();
}
