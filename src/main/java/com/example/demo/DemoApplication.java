package com.example.demo;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.ls.LSOutput;
//spring主程序
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("Spring boot启动成功");
    }
}
