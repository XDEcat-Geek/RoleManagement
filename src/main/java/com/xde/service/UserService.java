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
    // 查找用户
    User findUser(String name);
    // 根据用户名和密码查找用户
    User findUserByNameAndPass(String name,String pass);
}
