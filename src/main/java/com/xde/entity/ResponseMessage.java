package com.xde.entity;

/**
 * date: 2021/1/5 19:20
 * 说明: 接口返回信息的实体类
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
public class ResponseMessage {
    // 错误码
    private Integer code;
    // 提示信息
    private String msg;
    // 返回数据
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
