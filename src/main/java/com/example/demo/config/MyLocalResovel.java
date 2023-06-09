package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
public class MyLocalResovel implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
//        获取页面手动切换的语言参数
        String l = httpServletRequest.getParameter("l");
//        请求头自动传递的语言参数Accept_Language
        String header = httpServletRequest.getHeader("Accept-Language");
//        如果手动切换参数不为空,就根据手动参数进行语言切换,否则默认请求头信息
        Locale locale=null;
        if(!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale=new Locale(split[0],split[1]);
        }else {
            String[] splits = header.split(",");String[] split = splits[0].split("-");
            locale=new Locale(split[0],split[1]);}
        return locale;}

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
//    将自定义的MylocalResover类重新注册为一个类型LocalResolver的bean组件
//    用于覆盖默认的LocaleResolver
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResovel();
    }


}
