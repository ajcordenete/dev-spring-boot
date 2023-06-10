package com.ajcordenete.restcruddemo.rest;

import com.ajcordenete.restcruddemo.entity.Employee;
import com.ajcordenete.restcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService service;

    @Autowired
    public EmployeeRestController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {

        Employee employee = service.getById(id);

        if(employee == null) {
            throw new RuntimeException("Employee not found with id " + id);
        }

        return service.getById(id);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employee.setId(0);

        return service.save(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee saveEmployee(
            @PathVariable int id,
            @RequestBody Employee body
    ) {
        Employee employee = service.getById(id);

        employee.setFirstName(body.getFirstName());
        employee.setLastName(body.getLastName());
        employee.setEmail(body.getEmail());

        return service.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable int id) {

        Employee employee = service.getById(id);

        if(employee == null) {
            throw new RuntimeException("Employee id not found "+ id);
        }

        service.deleteById(id);
    }
}
