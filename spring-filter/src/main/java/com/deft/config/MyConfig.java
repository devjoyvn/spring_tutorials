package com.deft.config;

import com.deft.filter.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public FilterRegistrationBean<UserFilter> loggingFilter(){
        FilterRegistrationBean<UserFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new UserFilter());
        registrationBean.addUrlPatterns("/users/*");

        return registrationBean;
    }
}
