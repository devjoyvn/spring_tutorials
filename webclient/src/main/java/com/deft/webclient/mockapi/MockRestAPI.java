package com.deft.webclient.mockapi;

import com.deft.webclient.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/mock")
public class MockRestAPI {

    private static final Map<Long, Employee> employees;
    private static Long nextID = 1L;

    static {
        employees = new HashMap<>();
        employees.put(nextID, new Employee(nextID++, "John", "Doe", 80000));
        employees.put(nextID, new Employee(nextID++, "Mary", "Jackson", 75000));
        employees.put(nextID, new Employee(nextID++, "Peter", "Grey", 60000));
        employees.put(nextID, new Employee(nextID++, "Max", "Simpson", 67000));
        employees.put(nextID, new Employee(nextID++, "Lisa", "O'Melly", 45000));
        employees.put(nextID, new Employee(nextID++, "Josephine", "Rose", 52000));
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        Optional<Employee> employee = Optional.ofNullable(employees.get(id));
        return employee.orElse(null);
    }

    @GetMapping
    public List<Employee> getAllEmployee() {
        return new ArrayList<>(employees.values());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> create(@RequestBody Employee newEmployee) {
        newEmployee.setId(nextID++);
        employees.put(newEmployee.getId(), newEmployee);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", "/rest/employees/" + newEmployee.getId())
                .body(newEmployee);
    }

    @PutMapping(path = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> update(@PathVariable long id, @RequestBody Employee request) {
        if (!employees.containsKey(id)) {
            return ResponseEntity.notFound().build();
        } else {
            Employee employee = employees.get(id);
            employee.setFirstName(request.getFirstName());
            employee.setLastName(request.getLastName());
            employee.setYearlyIncome(request.getYearlyIncome());

            return ResponseEntity.ok(employee);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        Employee removedEmployee = employees.remove(id);

        return removedEmployee != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
