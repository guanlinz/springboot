package com.hp.contorller;

import com.hp.pojo.ClientUser;
import com.hp.service.ClientUserService;
import com.hp.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/transaction")
public class ClientUserController {

    @Autowired
    private ClientUserService clientUserService;


    @GetMapping(value = "list")
    public JsonResult selectClientUser(){
        List<ClientUser> clientUsers = clientUserService.selectClientUser();

        return new JsonResult(1,clientUsers);
    }


    @GetMapping(value = "count")
    public JsonResult selectUserCount(){
        int count = clientUserService.selectUserCount();
        return new JsonResult(1,count);
    }

    @GetMapping(value = "fuzzyList")
    public JsonResult selectClientUserFuzzy(@RequestParam("realname") String realname) {
        List<ClientUser> resultList = clientUserService.selectClientUserFuzzy(realname);
        return new JsonResult(1,resultList);
    }
}
