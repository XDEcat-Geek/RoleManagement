package com.xde;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.xde.mapper")
@SpringBootApplication
public class RoleManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoleManagementApplication.class, args);
    }

}
