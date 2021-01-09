package com.xde.mapper;

import com.xde.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * date: 2021/1/8 17:01
 * 说明: 对角色表的dao层增删查改操作的抽象接口
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
@Repository
public interface RoleMapper {
    // 查询所有的角色信息
    List<Role> getAllRoleInfo();
    // 按式神id查询单个信息
    Role getRoleInfoById(int id);
    // 按式神的名字模糊查询
    List<Role> getRoleInfoByName(String name);
    // 按式神的名字查询
    Role getRoleInfoByName2(String name);
    // 增加一个式神信息
    int addRoleInfo(Role role);

    // 删除一个式神信息
    int deleteRoleInfo(String name);

    // 修改一个式神信息
    int changeRoleInfo(Role role);
}
