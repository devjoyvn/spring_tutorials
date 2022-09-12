package com.deft.webclient.controller;

import com.deft.webclient.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/")
public class ControllerExample {

    @Autowired
    private WebClient webClient;

    @GetMapping("/{id}")
    public Mono<Employee> findById(@PathVariable String id) {
        return webClient.get()
                .uri("/" + id)
                .retrieve()
                .bodyToMono(Employee.class);
    }

    @GetMapping()
    public Flux<Employee> findAll() {
        return webClient.get()
                .uri("/")
                .retrieve()
                .bodyToFlux(Employee.class);
    }

    @PostMapping
    public Mono<Employee> create() {
        Employee employee = new Employee();
        employee.setFirstName("deft");
        employee.setLastName("blog");
        employee.setYearlyIncome(2021);
        return webClient.post()
                .uri("/")
                .body(Mono.just(employee), Employee.class)
                .retrieve()
                .bodyToMono(Employee.class);
    }

    @PutMapping("/{id}")
    public Mono<Employee> update(@PathVariable String id) {
        Employee employee = new Employee();
        employee.setFirstName("deft");
        employee.setLastName("blog");
        employee.setYearlyIncome(2021);
        return webClient.put()
                .uri("/" + id)
                .body(Mono.just(employee), Employee.class)
                .retrieve()
                .bodyToMono(Employee.class);
    }

    @DeleteMapping
    public Mono<Void> delete(@PathVariable String id) {
        return webClient.delete()
                .uri("/" + id)
                .retrieve()
                .bodyToMono(Void.class);
    }

}

