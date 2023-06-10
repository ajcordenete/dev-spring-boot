package com.ajcordenete.restcruddemo.service;

import com.ajcordenete.restcruddemo.entity.Employee;
import com.ajcordenete.restcruddemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.getAllEmployees();
    }

    @Override
    public Employee getById(int id) {
        return repository.getById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
