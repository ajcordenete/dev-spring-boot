package com.ajcordenete.restcruddemo.service;

import com.ajcordenete.restcruddemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
