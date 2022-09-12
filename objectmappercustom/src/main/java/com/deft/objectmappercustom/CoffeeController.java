package com.deft.objectmappercustom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/")
public class CoffeeController {

    @GetMapping("/coffee")
    public Coffee getCoffee(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String name) {

        return Coffee.builder()
                .brand(brand)
                .name(name)
                .date(LocalDateTime.now())
                .build();
    }
}
