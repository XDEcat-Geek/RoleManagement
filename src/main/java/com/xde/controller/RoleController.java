package com.xde.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xde.entity.ResponseMessage;
import com.xde.entity.Role;
import com.xde.service.role.RoleService;
import com.xde.utils.FileUtil;
import com.xde.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * date: 2021/1/8 18:36
 * 说明:
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {
    // 注入RoleService
    RoleService roleService;
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    // 获得所有的式神信息
    @RequestMapping("/allInfo")
    public String getAllRoleInfo(){
        List<Role> roles = roleService.getAllRoleInfo();
        ResponseMessage message;
        JSONObject data;
        if (roles.size() != 0){
            data = new JSONObject();
            data.put("roles",roles);
            message = ResultUtil.success(data);
            return JSONObject.toJSONString(message);
        }else {
            message = ResultUtil.error(233,"数据库中没有记录哦~");
            return JSONObject.toJSONString(message);
        }
    }
    // 按式神名字模糊查询
    @RequestMapping("/getInfoByName/{name}")
    public String getRoleInfoByName(@PathVariable("name") String name){
        List<Role> roles = roleService.getRoleInfoByName(name);
        return JSON.toJSONString(roles);
    }
    // 按id查询
    @RequestMapping("/getInfoById/{id}")
    public String getRoleInfoById(@PathVariable("id") Integer id){
        Role info = roleService.getRoleInfoById(id);
        return JSON.toJSONString(info);
    }
    // 按类型进行查询
    @RequestMapping("/getInfoByType/{type}")
    public String getRolesInfoByType(@PathVariable("type") String type){
        List<Role> roles = roleService.getRolesInfoByType(type);
        ResponseMessage message;
        JSONObject data = new JSONObject();
        if (roles.size() != 0){
            // 查询成功
            data.put("roles",roles);
            message = ResultUtil.success(data);
            return JSON.toJSONString(message);
        }else {
            //查询失败
            message = ResultUtil.error(233,"没有查询到数据~");
            return JSON.toJSONString(message);
        }
    }
    // 添加式神信息
    @RequestMapping(method = RequestMethod.POST,path = "/addRole")
    public String insertRoleInfo(@RequestBody JSONObject jsonObject){
        Role role = jsonObject.toJavaObject(Role.class);
        JSONObject data = new JSONObject();
        ResponseMessage message; // 返回数据
        // 先进行名字查重判断
        Boolean isExist = roleService.isExistByRoleName(jsonObject.get("name").toString());
        if (isExist){
            message =  ResultUtil.error(233,"已有该式神的记录，请重新填写信息");
            return JSON.toJSONString(message);
        }else {
            Boolean flag = roleService.addRoleInfo(role);
            if (flag){
                data.put("isInsert",true);
                message =  ResultUtil.success(data);
                return JSON.toJSONString(message);
            }else {
                message =  ResultUtil.error(233,"插入失败，请检查参数哦~");
                return JSON.toJSONString(message);
            }
        }
    }
    //修改式神信息
    @RequestMapping("/changeRole")
    public String changeRoleInfo(@RequestBody JSONObject jsonObject){
        Role role = jsonObject.toJavaObject(Role.class);
        Boolean flag = roleService.changeRoleInfo(role);
        ResponseMessage message;
        JSONObject data = new JSONObject();
        if (flag){
            data.put("isChange",true);
            message = ResultUtil.success(data);
            return JSONObject.toJSONString(message);
        }else {
            message = ResultUtil.error(233,"更新失败，检查参数列表");
            return JSONObject.toJSONString(message);
        }
    }

    //删除一个式神的信息
    @RequestMapping("/deleteRole/{name}")
    public String deleteRoleInfoByName(@PathVariable String name){
        Boolean isDelete = roleService.deleteRoleInfo(name);
        ResponseMessage message;
        JSONObject data = new JSONObject();
        if (isDelete){
            // 删除成功
            data.put("isDelete",true);
            message = ResultUtil.success(data);
            return JSON.toJSONString(message);
        }else {
            data.put("isDelete",false);
            message = ResultUtil.error(233,"删除失败,可能没有找到该式神",data);
            return JSON.toJSONString(message);
        }
    }
    // 设置式神头像
    @RequestMapping(method = RequestMethod.POST,path = "/setRolePortrait")
    public String addImg(@RequestParam("file")MultipartFile file,@RequestParam("roleID") Integer id){
        byte[] data;
        JSONObject json = new JSONObject();
        ResponseMessage message;
        if (file != null){
            try {
                // 得到二进制数据
                data = file.getBytes();
                System.out.println(data.length);
                System.out.println("式神id"+id);
                // 保存到数据库中
                Boolean success = roleService.setRolePortrait(id, data);
                if (success){
                    json.put("isUpload",true);
                    message = ResultUtil.success(json);
                    return JSON.toJSONString(message);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            message = ResultUtil.error(233,"上传失败！");
            return JSON.toJSONString(message);
        }
        return "";
    }
    // 设置式神图片
    @RequestMapping(method = RequestMethod.POST,path = "/setRolePicture")
    public String setRolePicture(@RequestParam("file")MultipartFile file,@RequestParam("roleID")Integer id){
        JSONObject data = new JSONObject();
        ResponseMessage message;
        // 1.获取上传图片的文件名以及后缀名
        String fileName = id+"_"+file.getOriginalFilename();
        // 2.获取jar包所在的目录
        ApplicationHome h = new ApplicationHome(getClass());
        File jarF = h.getSource();
        // 3.在jar包所在的目录下生成一个upload文件夹用来存储上传的图片
        String dirPath = jarF.getParentFile().toString()+"/upload/";
        System.out.println("上传图片的所在目录"+dirPath);
        // 4.创建文件夹
        File filePath = new File(dirPath);
        if (!filePath.exists()){
            filePath.mkdirs();
        }
        try {
            // 5.将图片写入该文件
            String path = dirPath+fileName;
            // 6.写入图片之前，清除相关的图片
            FileUtil.deleteFiles(dirPath,id.toString());
            // 7.重新写入文件
            file.transferTo(new File(path));
            Boolean success = roleService.setRolePicture(id, path);
            if (success){
                // 6.上传成功返回状态信息
                data.put("isUpload",true);
                message = ResultUtil.success(data);
                return JSON.toJSONString(message);
            }else {
                message = ResultUtil.error(233,"上传失败~");
                return JSON.toJSONString(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
            message = ResultUtil.error(233,"上传失败~");
            return JSON.toJSONString(message);
        }
    }
    // 获得式神头像
    @RequestMapping(method = RequestMethod.GET,path = "/getRolePortrait/{id}")
    public void getRolePortrait(@PathVariable Integer id, HttpServletResponse response){
        byte[] bytes = roleService.getRolePortrait(id);
        if (bytes.length != 0){
            // 设置返回类型
            response.setContentType("image/jpeg");
            response.setCharacterEncoding("UTF-8");
            try {
                // 返回数据
                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // 获得式神图片
    @RequestMapping(method = RequestMethod.GET,path = "/getRolePicture/{id}")
    public void getRolePicture(@PathVariable("id")Integer id,HttpServletResponse response) throws IOException {
        String url = roleService.getRolePicture(id);
        if (url!=null){
            byte[] bytes = FileUtil.getFileBytes(url);
            // 设置返回类型
            response.setContentType("image/jpeg");
            response.setCharacterEncoding("UTF-8");
            ServletOutputStream stream = response.getOutputStream();
            stream.write(bytes);
        }else {
            response.getWriter().write("没有图片信息~");
        }
    }
}
