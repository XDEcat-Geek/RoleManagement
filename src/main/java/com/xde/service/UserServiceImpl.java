package com.xde.service;

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

    @Override
    public User getUserInfo(String name) {
        User user = userMapper.findUserByName(name);
        return user;
    }

    @Override
    public Boolean findUserByNameAndPass(String name, String pass) {
        String user = userMapper.findUserByNameAndPass(name, pass);
        if (user != null){
            return true;
        }
        return false;
    }

    @Override
    public Boolean findUser(String name) {
        // 调用mapper方法
        User user = userMapper.findUserByName(name);
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
