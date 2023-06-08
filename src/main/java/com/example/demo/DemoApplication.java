package com.example.demo;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.w3c.dom.ls.LSOutput;
//@SpringBootApplication 注册spring主程序
//@ServletComponentScan开启基于注解方式的Serlet组件扫描支持1
//两个注解都是注册了Spring,所以出现两次监听器的启动
@SpringBootApplication
@ServletComponentScan
public class DemoApplication extends SpringBootServletInitializer {
//    添加提供Spring Boot启动的Servlet初始化器，为打war包做准备。
//    将打包好的War包拷贝到Tomcat安装目录下的webapps目录中，执行Tomcat安装目录下bin目录中的startup.bat命令启动War包项目
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(DemoApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("========================================================Spring boot启动成功========================================================");
    }
}
