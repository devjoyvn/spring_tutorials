package com.deft.resttemplate.controller;

import com.deft.resttemplate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class ControllerExample {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get-for-object")
    public Employee getForObject() {
        int id = 1;
        return restTemplate.getForObject("/" + id, Employee.class);
    }

    @GetMapping("/get-for-entity")
    public Employee getForEntity() {
        int id = 2;
        ResponseEntity<Employee> entity = restTemplate.getForEntity("/" + id, Employee.class);
        return entity.getBody();
    }

    @PostMapping("/post-for-object")
    public Employee postForObject() {
        Employee employee = new Employee();
        employee.setFirstName("Deft");
        employee.setLastName("blog");
        employee.setYearlyIncome(2020);
        return restTemplate.postForObject("/", employee, Employee.class);
    }

    @PostMapping("/post-for-location")
    public URI postForLocation() {
        Employee employee = new Employee();
        employee.setFirstName("Deft");
        employee.setLastName("blog");
        employee.setYearlyIncome(2020);
        return restTemplate.postForLocation("/", employee);
    }

    @PostMapping("/post-for-entity")
    public Employee postForEntity() {
        Employee employee = new Employee();
        employee.setFirstName("Deft");
        employee.setLastName("blog");
        employee.setYearlyIncome(2020);
        HttpEntity<Employee> entity = restTemplate.postForEntity("/", employee, Employee.class);
        return entity.getBody();
    }

    @PutMapping("/put/{id}")
    public void put(@PathVariable Long id) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstName("Deft");
        employee.setLastName("blog");
        employee.setYearlyIncome(2021);
        restTemplate.put("/" + id, employee);
    }

    @PutMapping("/put-ex/{id}")
    public Employee putExchange(@PathVariable Long id) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstName("Deft");
        employee.setLastName("blog");
        employee.setYearlyIncome(2021);
        return restTemplate.exchange("/" + id,
                HttpMethod.PUT,
                new HttpEntity<>(employee),
                Employee.class,
                Long.toString(id)).getBody();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        restTemplate.delete("/" + id);
    }

    @DeleteMapping("/delete-ex/{id}")
    public ResponseEntity<Void> deleteEx(@PathVariable Long id) {
        return restTemplate.exchange("/" + id,
                HttpMethod.DELETE,
                null,
                Void.class,
                id);
    }

}
