package com.hp.contorller;

import com.hp.pojo.ClientUserWithOrder;
import com.hp.pojo.Order;
import com.hp.service.OrderService;
import com.hp.vo.JsonResult;
import com.hp.vo.PageObject;
import com.hp.vo.TimeFormatHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("list")
    public JsonResult getOrderList(@RequestParam(value = "page") int page,
                                   @RequestParam(value = "limit") int limit,
                                   @RequestParam(value = "sort") String sortOrder,
                                   @RequestParam(value = "title",required = false) String title,
                                   @RequestParam(value = "type",required = false) String type) {
        if(sortOrder.equals(" id")){
            sortOrder = "+id";
        }
        PageObject<ClientUserWithOrder> pageObject = orderService.getAllOrders(sortOrder,page,limit,title,type);
        return new JsonResult(1,pageObject);
    }


    @PostMapping("save")
    public JsonResult saveOrder(@RequestParam("goodsName") String goods_name,
                                @RequestParam("realName") String realname,
                                @RequestParam("cityName") String cityName,
                                @RequestParam("deliverTime")String time) {

        Order order = new Order();
        order.setOrder_id(TimeFormatHelper.getCurrentTimeStamp());
        order.setGoods_name(goods_name);
        order.setGoods_id(String.valueOf(goods_name.hashCode()));
        order.setAddr_name(cityName);
        int result = orderService.saveOrder(order, realname);
        return result == 1 ? new JsonResult(1,"保存成功"):
                             new JsonResult(0,"保存失败");
    }
}
