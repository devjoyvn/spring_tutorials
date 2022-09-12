package com.deft.requestparam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class HelloController {

    @GetMapping
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }


    @GetMapping("/custom")
    public String helloCustomer(@RequestParam(name = "name") String customName) {
        return "Hello " + customName;
    }

    @GetMapping("/optional")
    public String helloOptional(@RequestParam(name = "name", required = false) String optionalName) {
        if (optionalName == null) {
            return "Hello NULL";
        }
        return "Hello " + optionalName;
    }

    @GetMapping("/optional8")
    public String helloOptional(@RequestParam(name = "name") Optional<String> optionalName) {
        if (!optionalName.isPresent()) {
            return "Hello NULL";
        }
        return "Hello " + optionalName;
    }

    @GetMapping("default-value")
    public String helloDefaultValue(@RequestParam(defaultValue = "DEFT") String name) {
        return "Hello " + name;
    }

    @PostMapping("/map-all")
    public void mapAll(@RequestParam Map<String, Object> params) {
        String name = (String) params.get("name");
        Integer id = Integer.valueOf((String) params.get("id"));

        System.out.println(name);
        System.out.println(id);
    }

    @GetMapping("/ids")
    public void ids(@RequestParam List<String> ids) {
        System.out.println(ids);
        ;
    }


}
