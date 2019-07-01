package com.hp.dao;

import com.hp.pojo.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao {
    List<Goods> selectGoods();
    int insertGoods(Goods goods);
    int deleteGoods(Goods goods);
    List<Goods> selectGoodsByType(@Param("startIndex") Integer startIndex,
                                  @Param("pageSize") Integer pageSize,
                                  @Param("type") String type,
                                  @Param("title") String title);
    int selectCount();

}
