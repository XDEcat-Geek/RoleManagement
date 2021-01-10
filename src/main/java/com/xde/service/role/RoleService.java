package com.xde.service.role;

import com.xde.entity.Role;

import java.util.List;

/**
 * date: 2021/1/8 18:29
 * 说明:
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
public interface RoleService {
    // 按名字模糊查询式神信息
    List<Role> getRoleInfoByName(String name);
    // 对式神名字进行查重
    Boolean isExistByRoleName(String name);
    // 按式神id查询单个信息
    Role getRoleInfoById(int id);
    // 按式神的type进行查询
    List<Role> getRolesInfoByType(String type);
    // 查询所有的式神信息
    List<Role> getAllRoleInfo();

    // 增加一个式神信息
    Boolean addRoleInfo(Role role);

    // 删除式神
    Boolean deleteRoleInfo(String name);

    //修改式神
    Boolean changeRoleInfo(Role role);
}
