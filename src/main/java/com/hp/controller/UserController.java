package com.hp.controller;

import com.hp.pojo.User;
import com.hp.pojo.UserPower;
import com.hp.service.UserService;
import com.hp.vo.FaceResult;
import com.hp.vo.JsonResult;
import com.hp.vo.TokenBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "login")
    public JsonResult selectUser(@RequestParam("username") String username,@RequestParam("password") int password){
        User user = new User();
        user.setUserName(username);
        user.setPassWord(password);

        User newUser = userService.selectUser(user);

        return newUser != null? new JsonResult(1,newUser): new JsonResult(2,newUser);
    }

    @PostMapping(value = "info")
    public JsonResult selectUserPower(@RequestParam("token") String token){
        UserPower userPower = new UserPower();
        userPower.setPower(token);
        List<UserPower> userPowers = userService.selectUserPower(userPower);

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

    @PostMapping("faceLogin")
    public JsonResult faceLogin(@RequestParam("snapData") String snapData,
                                @RequestParam("username") String username,
                                @RequestParam(value = "password",required = false) String password) throws Exception{
        User tmpUser = new User();
        tmpUser.setUserName(username);
        FaceResult faceResult = userService.faceLogin(tmpUser, snapData);
        tmpUser.setToken(faceResult.getToken());
        String resultMessage = faceResult.getErrorMsg() + " score: " + faceResult.getScore();
        return new JsonResult(faceResult.getState(),resultMessage,tmpUser);
    }

    @PostMapping("faceRegister")
    public JsonResult faceRegister(@RequestParam("snapData") String snapData,
                                   @RequestParam("username") String username) {
        User tmpUser = new User();
        tmpUser.setUserName(username);
        return userService.faceRegister(tmpUser, snapData) ?
               new JsonResult(1,"注册成功") :
               new JsonResult(0,"注册失败");
    }

}
