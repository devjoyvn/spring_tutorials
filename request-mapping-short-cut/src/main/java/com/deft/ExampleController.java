package com.deft;

import org.springframework.web.bind.annotation.*;

@RestController
public class ExampleController {

    @GetMapping("/get")
    public String get() {
        return "Hello world";
    }

    @GetMapping("/get/{id}")
    public String getId(@PathVariable String id) {
        return "ID " + id;
    }

    @PostMapping("/post")
    public String post() {
        return "Post";
    }


    @PutMapping("/put/{id}")
    public String update() {
        return "Update";
    }

    @DeleteMapping("delete")
    public String delete() {
        return "Delete";
    }

    @PatchMapping("patch")
    public String patch() {
        return "Patch";
    }
}
