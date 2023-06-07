package com.ajcordenete.cruddemo.dao;

import com.ajcordenete.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY lastName ASC", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName =:name", Student.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void updateStudentsByLastName(String lastName, String newLastName) {
        Query query = entityManager.createQuery("UPDATE Student SET lastName =:newLastName WHERE lastName =:lastName");
        query.setParameter("lastName", lastName);
        query.setParameter("newLastName", newLastName);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student studentToDelete = entityManager.find(Student.class, id);
        entityManager.remove(studentToDelete);
    }

    @Override
    @Transactional
    public int deleteAllStudents() {
        return entityManager.createQuery("DELETE from Student")
                .executeUpdate();
    }
}
