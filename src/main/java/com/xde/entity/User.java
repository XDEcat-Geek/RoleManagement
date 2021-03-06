package com.xde.entity;

import java.util.Arrays;

/**
 * date: 2021/1/5 15:54
 * 说明: 用户的实体类
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */

public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String email;
    private String sex;
    private Integer age;
    private String tel;
    private byte[] head; // 头像
    public User() {
    }

    public User(Integer id, String userName, String passWord, String email, String sex, Integer age, String tel, byte[] head) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.head = head;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public byte[] getHead() {
        return head;
    }

    public void setHead(byte[] head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", head=" + Arrays.toString(head) +
                '}';
    }
}
