package com.hp.contorller;

import com.hp.pojo.ClientUser;
import com.hp.service.ClientUserService;
import com.hp.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ClientUserContorller {

    @Autowired
    private ClientUserService clientUserService;


    @GetMapping(value = "transaction/list")
    public JsonResult selectClientUser(){
        List<ClientUser> clientUsers = clientUserService.selectClientUser();

        return new JsonResult(1,clientUsers);
    }
}
