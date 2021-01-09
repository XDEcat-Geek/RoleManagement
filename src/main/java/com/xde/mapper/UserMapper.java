package com.xde.mapper;

import com.xde.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * date: 2021/1/5 16:09
 * 说明: 定义了一个dao层接口，对User表进行增删查改等操作
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
@Repository
public interface UserMapper {
    // 根据账号查找一个用户信息
    User findUserByAccount(String account);
    // 注册信息查重
    User checkRepeatInfo(String param);
    // 检验用户账号和密码正确
    String findUserByAccountAndPass(@Param("account") String account, @Param("pass") String pass);

    // 添加用户
    int addUser(User user);
}
