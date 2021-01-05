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
    // 查询一个用户
    User findUserByName(String name);

    // 根据用户名和密码查找用户
    User findUserByNameAndPass(@Param("name") String name, @Param("pass") String pass);
}