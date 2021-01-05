package com.xde.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xde.entity.ResponseMessage;
import com.xde.entity.User;
import com.xde.service.UserService;
import com.xde.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * date: 2021/1/5 16:20
 * 说明: 控制层，
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    // 自动装配业务层
    UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // 用户名查重
    @RequestMapping("/findUser/{name}")
    public String getUser(@PathVariable String name){
        User user = userService.findUser(name);
        ResponseMessage success;
        if (user == null){
            // 如果用户名为空
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("isRe",true);
            success = ResultUtil.success(jsonObject);
        }else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("isRe",false);
            success = ResultUtil.success(jsonObject);
        }
        return JSON.toJSONString(success);
    }

    // 用户登录判断
    @RequestMapping(method = RequestMethod.POST,path = "/login")
    public String login(@RequestBody JSONObject jsonObject){
        String username = jsonObject.get("username").toString();
        String password = jsonObject.get("password").toString();
        ResponseMessage response;
        // 调用service
        User user = userService.findUserByNameAndPass(username, password);
        if (user != null) {
            JSONObject json = new JSONObject();
            json.put("userName",user.getUserName());
            response = ResultUtil.success(json);
        }else {
            response = ResultUtil.error(233,"用户名或者密码不对!");
        }
        return JSON.toJSONString(response);
    }
}
