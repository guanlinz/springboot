package com.hp.service;

import com.hp.pojo.Goods;
import com.hp.vo.FileHelper;
import com.hp.vo.PageObject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface GoodsService {
    List<Goods> selectGoods();
    int insertGoods(String goods_name, MultipartFile goods_img, String add_time, String type, String goods_price);
    int deleteGoods(Goods goods);
    PageObject<Goods> selectGoodsByType(Integer startPage,String type,String title);
    int selectCount();

}
