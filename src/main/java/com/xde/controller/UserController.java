package com.xde.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xde.entity.ResponseMessage;
import com.xde.entity.User;
import com.xde.service.UserService;
import com.xde.service.UserServiceImpl;
import com.xde.utils.JwtUtil;
import com.xde.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    // 查找用户
    @RequestMapping("/findUser/{name}")
    public String getUser(@PathVariable String name, HttpServletRequest request){
        String token = request.getHeader("token");
        System.out.println("token:"+token);
        Boolean verity = JwtUtil.verity(token);
        ResponseMessage response;
        // 验证token
        if (verity){
            // 如果查找用户成功
            Boolean exist = userService.findUser(name);
            if (exist){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("isRe",true);
                response = ResultUtil.success(jsonObject);
            }else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("isRe",false);
                response = ResultUtil.success(jsonObject);
            }
        }else {
            response = ResultUtil.error(233,"身份验证失败~请携带token!");
        }
        return JSON.toJSONString(response);
    }

    // 用户登录判断,账号和密码~
    @RequestMapping(method = RequestMethod.POST,path = "/login")
    public String login(@RequestBody JSONObject jsonObject){
        String account = jsonObject.get("account").toString();
        String password = jsonObject.get("password").toString();
        ResponseMessage response;
        JSONObject data = new JSONObject();
        // 调用service
        Boolean check = userService.findUserByAccountAndPass(account, password);
        if (check) {
            // 如果校验成功,则拿到用户信息和生成token
            String token = JwtUtil.sign(account, password);
            User userInfo = userService.getUserInfo(account);
            data.put("token",token);
            data.put("userInfo",userInfo);
            response = ResultUtil.success(data);
        }else {
            response = ResultUtil.error(233,"用户名或者密码不对~");
        }
        return JSON.toJSONString(response);
    }

    // 注册查重
    @RequestMapping("/checkRepeat")
    public String checkRepeatByRegister(@RequestBody JSONObject jsonObject){
        String param = jsonObject.get("param").toString();
        Boolean isRepeat = userService.checkRepeatInfo(param);
        JSONObject json;
        ResponseMessage message;
        if(isRepeat){
            json = new JSONObject();
            json.put("isRepeat",true);
            message = ResultUtil.success(json);
            return JSON.toJSONString(message);
        }else {
            json = new JSONObject();
            json.put("isRepeat",false);
            message = ResultUtil.success(json);
            return JSON.toJSONString(message);
        }
    }
    //添加一个用户
    @RequestMapping("/register")
    public String addUser(@RequestBody JSONObject jsonObject){
        // 将json转换为java对象
        User user = jsonObject.toJavaObject(User.class);
        Boolean success = userService.addUser(user);
        System.out.println(success);
        ResponseMessage response;
        if (!success){
            JSONObject data = new JSONObject();
            data.put("success",false);
            response = ResultUtil.error(233,"插入数据失败~检查一下参数格式是否正确~",data);
        }else {
            JSONObject data = new JSONObject();
            data.put("success",true);
            response = ResultUtil.success(data);
        }
        return JSON.toJSONString(response);
    }
}
