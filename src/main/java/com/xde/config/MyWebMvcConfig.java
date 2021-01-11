package com.xde.config;

import javafx.application.Application;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.io.File;

/**
 * date: 2021/1/11 20:45
 * 说明: 视图解析器
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
public class MyWebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 获取jar包所在的目录
        ApplicationHome home = new ApplicationHome(getClass());
        File jarF = home.getSource();
        // 在jar包所在目录下生成一个upload文件夹用来存储上传的图片
        String dirPath = jarF.getParentFile().toString()+"/upload/";
        registry.addResourceHandler("/upload/***").addResourceLocations("file:/"+dirPath);
    }
}
