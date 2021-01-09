package com.xde.entity;

import java.util.Arrays;

/**
 * date: 2021/1/8 16:49
 * 说明: 式神信息的实体类
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
public class Role {
    private Integer id;
    private String name; // 名字
    private String position; // 定位
    private String brief; //简介
    private byte[] portrait; // 头像
    private String picture; // 图片地址
    private String peculiarity; // 特性
    private String survival; //生存能力
    private String output; // 伤害输出
    private String agility; // 敏捷能力
    private String gain; // 增益效果
    private Integer difficulty; //难度

    public Role(Integer id, String name, String position, String brief, byte[] portrait, String picture, String peculiarity, String survival, String output, String agility, String gain, Integer difficulty) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.brief = brief;
        this.portrait = portrait;
        this.picture = picture;
        this.peculiarity = peculiarity;
        this.survival = survival;
        this.output = output;
        this.agility = agility;
        this.gain = gain;
        this.difficulty = difficulty;
    }

    public Role() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public byte[] getPortrait() {
        return portrait;
    }

    public void setPortrait(byte[] portrait) {
        this.portrait = portrait;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPeculiarity() {
        return peculiarity;
    }

    public void setPeculiarity(String peculiarity) {
        this.peculiarity = peculiarity;
    }

    public String getSurvival() {
        return survival;
    }

    public void setSurvival(String survival) {
        this.survival = survival;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getAgility() {
        return agility;
    }

    public void setAgility(String agility) {
        this.agility = agility;
    }

    public String getGain() {
        return gain;
    }

    public void setGain(String gain) {
        this.gain = gain;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", brief='" + brief + '\'' +
                ", portrait=" + Arrays.toString(portrait) +
                ", picture='" + picture + '\'' +
                ", peculiarity='" + peculiarity + '\'' +
                ", survival='" + survival + '\'' +
                ", output='" + output + '\'' +
                ", agility='" + agility + '\'' +
                ", gain='" + gain + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
