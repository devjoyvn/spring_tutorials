package com.deft.requestbodyresponsebody;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestBodyExampleController {

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody LoginForm form) {

        System.out.println("User name: " + form.getUsername());
        System.out.println("Password: " + form.getPassword());
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
