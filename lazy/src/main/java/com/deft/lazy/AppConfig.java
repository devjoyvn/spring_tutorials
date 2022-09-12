package com.deft.lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DataSource datasource = new DataSource();
        datasource.setUsername("username");
        datasource.setPassword("password");
        datasource.setUrl("jdbc:mysql://202.20.84.206:3306/mydb");
        return datasource;
    }
}
