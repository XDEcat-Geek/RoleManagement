package com.xde.test;

import com.xde.utils.FileUtil;

/**
 * date: 2021/1/11 22:00
 * 说明:
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
public class Test {
    @org.junit.jupiter.api.Test
    public void test1(){
        FileUtil.deleteFiles("F:\\IDEA项目库\\RoleManagement\\target/upload/","im");
    }
}
