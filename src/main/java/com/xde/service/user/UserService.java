package com.xde.service.user;

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
    Boolean findUser(String account);
    // 获得用户信息
    User getUserInfo(String account);
    // 注册信息查重
    Boolean checkRepeatInfo(String param);
    // 根据账号和密码查找用户
    Boolean findUserByAccountAndPass(String account,String pass);

    // 添加一个用户
    Boolean addUser(User user);
}
