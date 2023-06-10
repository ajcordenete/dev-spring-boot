package com.ajcordenete.restcruddemo.repository;

import com.ajcordenete.restcruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeRepository extends JpaRepository<Employee, Integer> { }
