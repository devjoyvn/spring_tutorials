package com.deft.animal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatConfig {

    @Bean
    public Cat cat() {
        return new Cat();
    }
}
