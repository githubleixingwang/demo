package com.demo.moudleOne.todo.java;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    public RequestFilter requestFilter(){
        return new RequestFilter();
    }
    @Bean
    public FilterRegistrationBean<RequestFilter> registrationBean() {
        FilterRegistrationBean<RequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(requestFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("RequestFilter");
        //过滤器的级别，值越小级别越高越先执行
        registrationBean.setOrder(1);
        return registrationBean;
    }
}


