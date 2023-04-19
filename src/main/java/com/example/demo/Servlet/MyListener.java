package com.example.demo.Servlet;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Component
public class MyListener implements ServletContextListener {
//    启动的时候出现监听器
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听器：contextnitialized...");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听器：contextDestroyed...");
    }
}