package com.ajcordenete.restcruddemo.repository;

import com.ajcordenete.restcruddemo.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeRepository {

    List<Employee> getAllEmployees();

    Employee getById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
