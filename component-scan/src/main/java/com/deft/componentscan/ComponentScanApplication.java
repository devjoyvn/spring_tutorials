package com.deft.componentscan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(excludeFilters =
@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {MyService.class}))
public class ComponentScanApplication {

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(ComponentScanApplication.class, args);

        System.out.println("Contains My Bean: " + applicationContext.containsBean("myBean"));
        System.out.println("Contains My Service Bean: " + applicationContext.containsBean("myService"));
        System.out.println("Contains My Config Bean: " + applicationContext.containsBean("myConfig"));
        System.out.println("Contains AnotherService Bean: " + applicationContext.containsBean("anotherService"));
    }

}
