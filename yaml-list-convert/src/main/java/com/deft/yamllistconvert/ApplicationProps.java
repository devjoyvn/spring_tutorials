package com.deft.yamllistconvert;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "application")
public class ApplicationProps {

    private List<String> profiles;

    private List<Map<String, Object>> props;
    private List<User> users;

    @Getter
    @Setter
    public static class User {

        private String username;
        private String password;
        private List<String> roles;


    }
}
