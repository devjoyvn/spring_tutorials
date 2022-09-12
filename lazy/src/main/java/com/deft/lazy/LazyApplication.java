package com.deft.lazy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LazyApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(LazyApplication.class, args);
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println(dataSource.getUsername() + " - " + dataSource.getPassword());

    }
}
