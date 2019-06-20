package com.hp.contorller;

import com.hp.pojo.ClientUserWithOrder;
import com.hp.service.OrderService;
import com.hp.vo.JsonResult;
import com.hp.vo.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
