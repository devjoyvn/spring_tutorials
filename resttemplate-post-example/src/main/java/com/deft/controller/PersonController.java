package com.deft.controller;

import com.deft.model.Person;
import com.deft.service.PersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    private PersionService persionService;

@PostMapping
public Person create(@RequestBody Person person, HttpServletResponse response) {
    response.setHeader("Location", "/person");
    return persionService.save(person);
}
}
