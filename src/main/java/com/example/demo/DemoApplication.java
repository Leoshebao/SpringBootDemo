package com.example.demo;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.w3c.dom.ls.LSOutput;
//@SpringBootApplication 注册spring主程序
//@ServletComponentScan开启基于注解方式的Serlet组件扫描支持1
//两个注解都是注册了Spring,所以出现两次监听器的启动
@SpringBootApplication
@ServletComponentScan
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("========================================================Spring boot启动成功========================================================");
    }
}
