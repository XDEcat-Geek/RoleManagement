package com.xde.service;

import com.xde.entity.User;

/**
 * date: 2021/1/5 16:14
 * 说明:
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
public interface UserService {
    // 查找用户是否存在
    Boolean findUser(String name);
    // 获得用户信息
    User getUserInfo(String name);
    // 根据用户名和密码查找用户
    Boolean findUserByNameAndPass(String name,String pass);

    // 添加一个用户
    Boolean addUser(User user);
}
