package com.deft.pathvariable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class ExampleController {

    @GetMapping("/api/employee/{id}")
    public String getEmployeeById(@PathVariable String id) {
        return "ID " + id;
    }

    @GetMapping("/api/employeeswithvariable/{id}")
    public String getEmployeesByIdWithVariableName(@PathVariable("id") String employeeId) {
        return "ID: " + employeeId;
    }

    @GetMapping("/api/employeeswithrequired/{id}")
    public String getEmployeesByIdWithRequired(@PathVariable String id) {
        return "ID: " + id;
    }

    @GetMapping(value = {"/api/employeeswithrequiredfalse", "/api/employeeswithrequiredfalse/{id}"})
    public String getEmployeesByIdWithRequiredFalse(@PathVariable(required = false) String id) {
        if (id != null) {
            return "ID: " + id;
        } else {
            return "ID missing";
        }
    }

    @GetMapping(value = {"/api/employeeswithoptional", "/api/employeeswithoptional/{id}"})
    public String getEmployeesByIdWithOptional(@PathVariable Optional<String> id) {
        if (id.isPresent()) {
            return "ID: " + id;
        } else {
            return "ID missing";
        }
    }

    @GetMapping(value = {"/api/employeeswithmap/{id}", "/api/employeeswithmap"})
    public String getEmployeesByIdWithMap(@PathVariable Map<String, String> pathVarsMap) {
        String id = pathVarsMap.get("id");
        if (id != null) {
            return "ID: " + id;
        } else {
            return "ID missing";
        }
    }

    @GetMapping(value = {"/api/defaultemployeeswithoptional", "/api/defaultemployeeswithoptional/{id}"})
    public String getDefaultEmployeesByIdWithOptional(@PathVariable Optional<String> id) {
        if (id.isPresent()) {
            return "ID: " + id.get();
        } else {
            return "ID: Default Employee";
        }
    }

    @GetMapping("/api/employees/{id}/{name}")
    public String getEmployeesByIdAndName(@PathVariable String id, @PathVariable String name) {
        return "ID: " + id + ", name: " + name;
    }
}
