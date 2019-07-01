package com.hp.controller;

import com.hp.pojo.Goods;
import com.hp.service.GoodsService;
import com.hp.vo.JsonResult;
import com.hp.vo.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/api/goods")
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping(value = "getGoods")
    public JsonResult geiGoods(){
        List<Goods> goods = goodsService.selectGoods();
        return new JsonResult(1,goods);
    }

    @PostMapping("deleteGoods")
    public JsonResult deleteGoods(@RequestParam("goods_id") String goods_id,@RequestParam("goods_name") String goods_name){

       Goods good = new Goods();
       good.setGoods_id(goods_id);
       good.setGoods_name(goods_name);
        int count = goodsService.deleteGoods(good);
        return count == 1? new JsonResult(1,"删除成功") : new JsonResult(0,"删除失败");
    }

    @PostMapping("insertGoods")
    public JsonResult insertGoods(@RequestParam("goods_name")String goods_name,
                                  @RequestParam("goods_img") MultipartFile goods_img,
                                  @RequestParam("add_time") String add_time,
                                  @RequestParam("type") String type,
                                  @RequestParam("goods_price") String goods_price){

        int count = goodsService.insertGoods(goods_name,goods_img,add_time,type,goods_price);

        return count == 1? new JsonResult(1,"ok") : new JsonResult(0,"error");

    }

    @PostMapping("selectGoods")
    public JsonResult selectGoods(@RequestParam("startPage") Integer startPage,
                                  @RequestParam("type") String type,
                                  @RequestParam("title") String title){
        PageObject<Goods> goodsPageObject = goodsService.selectGoodsByType(startPage,type,title);
        return new JsonResult(1,goodsPageObject);
    }
}
