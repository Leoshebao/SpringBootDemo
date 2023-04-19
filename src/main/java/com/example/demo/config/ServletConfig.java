package com.example.demo.config;

import com.example.demo.Servlet.MyFilter;
import com.example.demo.Servlet.MyListener;
import com.example.demo.Servlet.MyServlet;
import org.springframework.boot.autoconfigure.mustache.MustacheProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ServletConfig {
    @Bean
    public ServletRegistrationBean getServlet(MyServlet myServlet){
            ServletRegistrationBean registrationBean =
                    new ServletRegistrationBean(myServlet,"/myServlet");
        return registrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean getServletListener(MyListener myListener){
        ServletListenerRegistrationBean servletListenerRegistrationBean =
                new ServletListenerRegistrationBean(myListener);
        return servletListenerRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean getFilter(MyFilter myFilter){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/toLogin","/myFilter"));
        return filterRegistrationBean;
    }
}
