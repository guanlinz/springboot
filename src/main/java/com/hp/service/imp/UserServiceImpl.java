package com.hp.service.imp;

import com.baidu.aip.face.AipFace;
import com.hp.dao.UserDao;
import com.hp.dao.UserPowerDao;
import com.hp.pojo.User;
import com.hp.pojo.UserPower;
import com.hp.service.UserService;
import com.hp.vo.FaceResult;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserPowerDao userPowerDao;

    @Override
    public User selectUser(User user) {
        return userDao.selectUser(user) ;
    }

    @Override
    public List<UserPower> selectUserPower(UserPower userPower) {
        return userPowerDao.selectUserPower(userPower);
    }

    @Override
    public FaceResult faceLogin(User user, String snapData) {
        //使用Ajax提交base64字符串，需要经过去头转码
        String img_data = snapData.substring(22);
        AipFace client = initAipFace();
        HashMap<String, String> options;  //请求预置参数
        options = new HashMap<>();


        options.put("liveness_control", "NORMAL");   //活体检测，级别低到高：LOW，NORMAL，HIGH
        options.put("quality_control", "NORMAL");
        options.put("user_id", user.getUserName());

        JSONObject serverJSON = client.search(img_data, "BASE64", "admin", options);

        int matchScore = 0;
        String errorMsg = serverJSON.getString("error_msg");

        FaceResult result = new FaceResult();

        JSONObject resultJSON = null;
        if ((resultJSON = serverJSON.optJSONObject("result")) != null) {
            JSONArray userList = resultJSON.getJSONArray("user_list");
            JSONObject firstObjectInList = (JSONObject) userList.get(0);
            matchScore = firstObjectInList.getInt("score");

            if (matchScore >= 80) {
                result.setState(1);
                User tmpUser = new User();
                tmpUser.setUserName("admin");
                result.setToken(userDao.selectUserByFace(tmpUser).getToken());
            }
        }
        result.setErrorMsg(errorMsg);
        result.setScore(matchScore);
        return result;
    }


    @Override
    public boolean faceRegister(User user, String snapData) {
        //使用Ajax提交base64字符串，需要经过去头转码
        String img_data = snapData.substring(22);
        AipFace client = initAipFace();
        HashMap<String, String> options = new HashMap<>();
        options.put("user_info", "zgl's info");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "NORMAL");

        String image = snapData;
        String imageType = "BASE64";
        String groupId = "admin";
        String userId = user.getUserName();

        JSONObject serverJSON = client.addUser(img_data, "BASE64", "admin", userId, options);
        return true;
    }

    private static AipFace initAipFace() {
        return new AipFace(
                "16646819",
                "QVvgCnkMiixV5iYPP2qBLHVZ",
                "B8OkXNUla8Ki3X8bMMaEpvtcOV5aOyvd");
    }
}
