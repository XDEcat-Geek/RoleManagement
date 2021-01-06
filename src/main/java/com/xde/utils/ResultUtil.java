package com.xde.utils;

import com.xde.entity.ResponseMessage;

/**
 * date: 2021/1/5 19:24
 * 说明:
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
public class ResultUtil {
    /**
     * 请求成功
     * @param object
     * @return
     */
    public static ResponseMessage success(Object object){
        ResponseMessage message = new ResponseMessage();
        message.setCode(200);
        message.setMsg("请求成功~");
        message.setContent(object);
        return message;
    }

    /**
     * 请求失败
     * @param code
     * @param msg
     */
    public static ResponseMessage error(Integer code,String msg){
        ResponseMessage message = new ResponseMessage();
        message.setCode(code);
        message.setMsg(msg);
        message.setContent("没有数据哦~");
        return message;
    }
    public static ResponseMessage error(Integer code,String msg,Object object){
        ResponseMessage message = new ResponseMessage();
        message.setCode(code);
        message.setMsg(msg);
        message.setContent(object);
        return message;
    }
}
