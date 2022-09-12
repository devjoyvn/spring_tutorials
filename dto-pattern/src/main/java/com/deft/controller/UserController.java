package com.deft.controller;

import com.deft.dto.UserCreationDTO;
import com.deft.dto.UserDTO;
import com.deft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDTO create(@RequestBody UserCreationDTO dto) {
        return userService.create(dto);
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }
}
