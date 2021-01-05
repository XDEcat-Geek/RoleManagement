package com.xde.entity;

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

    public User() {
    }

    public User(Integer id, String userName, String passWord, String email, String sex, Integer age) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.sex = sex;
        this.age = age;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
