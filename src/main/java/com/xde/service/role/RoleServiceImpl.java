package com.xde.service.role;

import com.xde.entity.Role;
import com.xde.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * date: 2021/1/8 18:29
 * 说明: 关于式神信息操作的业务
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
@Service
public class RoleServiceImpl implements RoleService{
    // 注入RoleMapper
    RoleMapper roleMapper;
    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    // 按名字查询式神信息
    @Override
    public List<Role> getRoleInfoByName(String name) {
        List<Role> roles = roleMapper.getRoleInfoByName(name);
        return roles;
    }
    /*按式神的type进行查询*/

    @Override
    public List<Role> getRolesInfoByType(String type) {
        List<Role> roles = roleMapper.getRoleInfoByType(type);
        return roles;
    }

    // 按id查询式神
    @Override
    public Role getRoleInfoById(int id) {
        Role role = roleMapper.getRoleInfoById(id);
        return role;
    }
    // 查询所有的式神信息
    @Override
    public List<Role> getAllRoleInfo() {
        List<Role> roles = roleMapper.getAllRoleInfo();
        return roles;
    }

    // 对式神名字进行查重
    @Override
    public Boolean isExistByRoleName(String name) {
        Role role = roleMapper.getRoleInfoByName2(name);
        if (role != null){
            return true;
        }else {
            return false;
        }
    }

    // 添加一个式神信息
    @Override
    public Boolean addRoleInfo(Role role) {
        int i = roleMapper.addRoleInfo(role);
        if (i != 0){
            return true;
        }else {
            return false;
        }
    }

    // 删除一个式神信息
    @Override
    public Boolean deleteRoleInfo(String name) {
        int i = roleMapper.deleteRoleInfo(name);
        if (i != 0){
            return true;
        }else {
            return false;
        }
    }



    // 修改一个式神信息
    @Override
    public Boolean changeRoleInfo(Role role) {
        int i = roleMapper.changeRoleInfo(role);
        if (i != 0){
            return true;
        }else {
            return false;
        }
    }

    // 设置式神图片
    @Override
    public Boolean setRolePicture(Integer id, String url) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("url",url);
        int i = roleMapper.setRolePicture(map);
        if (i != 0){
            return true;
        }else {
            return false;
        }
    }

    // 设置式神头像
    @Override
    public Boolean setRolePortrait(Integer id, byte[] img) {
        HashMap map = new HashMap();
        map.put("id",id);
        map.put("portrait",img);
        int code = roleMapper.setRolePortrait(map);
        if (code != 0){
            return true;
        }else {
            return false;
        }
    }

    // 获得式神头像
    @Override
    public byte[] getRolePortrait(Integer id) {
        Role role = roleMapper.getRolePortrait(id);
        if (role.getPortrait().length != 0){
            return role.getPortrait();
        }else {
            return null;
        }
    }

    // 获得式神图片
    @Override
    public String getRolePicture(Integer id) {
        String url = roleMapper.getRolePicture(id);
        if (url != null){
            return url;
        }else {
            return null;
        }
    }
}
