package com.ajcordenete.restcruddemo.repository;

import com.ajcordenete.restcruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private EntityManager entityManager;

    @Autowired
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        Employee employeeDB = entityManager.merge(employee);
        return employeeDB;
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("DELETE FROM Employee WHERE id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
