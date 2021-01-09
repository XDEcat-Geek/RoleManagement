package com.xde.service.user;

import com.xde.entity.User;
import com.xde.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * date: 2021/1/5 16:16
 * 说明: User的业务层
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
@Service
public class UserServiceImpl implements UserService{
    // 自动装配mapper
    UserMapper userMapper;
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 获得用户信息
    @Override
    public User getUserInfo(String account) {
        User user = userMapper.findUserByAccount(account);
        return user;
    }

    // 检查用户账号和密码
    @Override
    public Boolean findUserByAccountAndPass(String account, String pass) {
        String user = userMapper.findUserByAccountAndPass(account, pass);
        if (user != null){
            return true;
        }else {
            return false;
        }
    }

    // 注册信息查重
    @Override
    public Boolean checkRepeatInfo(String param) {
        User user = userMapper.checkRepeatInfo(param);
        if (user != null){
            return true;
        }else {
            return false;
        }
        // 判断用户昵称是否重复
        // 判断用户邮箱是否重复
        // 判断用户手机号是否重复
    }

    // 查找用户是否存在
    @Override
    public Boolean findUser(String account) {
        // 调用mapper方法
        User user = userMapper.findUserByAccount(account);
        System.out.println("user="+user);
        if (user != null){
            return true;
        }
        return false;
    }

    // 添加一个用户
    @Override
    public Boolean addUser(User user) {
        int result = userMapper.addUser(user);
        if (result != 0){
            return true;
        }
        return false;
    }
}
