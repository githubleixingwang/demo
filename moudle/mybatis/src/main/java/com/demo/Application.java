package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@MapperScan({"com.demo.mybatis.dao","com.demo.base.dao"})  //项目启动时会扫描mapper包及子包的接口，否则会报错找不到mapper文件
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
