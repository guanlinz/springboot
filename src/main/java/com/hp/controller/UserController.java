package com.hp.controller;

import com.hp.pojo.User;
import com.hp.pojo.UserPower;
import com.hp.service.UserServer;
import com.hp.vo.JsonResult;
import com.hp.vo.TokenBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:9528",
//        maxAge = 3600,
//        methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE,RequestMethod.OPTIONS})
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServer userServer;




    @PostMapping(value = "login")
    public JsonResult selectUser(@RequestParam("username") String username,@RequestParam("password") int password){
        User user = new User();
        user.setUserName(username);
        user.setPassWord(password);

        User newUser = userServer.selectUser(user);

        return newUser != null? new JsonResult(1,newUser): new JsonResult(2,newUser);
    }

    @PostMapping(value = "info")
    public JsonResult selectUserPower(@RequestParam("token") String token){
        UserPower userPower = new UserPower();
        userPower.setPower(token);
        List<UserPower> userPowers = userServer.selectUserPower(userPower);

        TokenBean bean = new TokenBean();
        bean.setIntroduction("i am a administrator");
        bean.setName("admin");
        String[] arr = new String[userPowers.size()];

        for (int i = 0; i < userPowers.size(); i++) {
            arr[i] = userPowers.get(i).getRoles();
        }
        bean.setRoles(arr);
        return new JsonResult(1,bean);
    }

    @GetMapping(value = "resetToken")
    public JsonResult selectUserPower(){
        return new JsonResult(1,"admin-token","admin-token");
    }

    @PostMapping("logout")
    public JsonResult logOut(){
        return new JsonResult(1,"ok");
    }

}
