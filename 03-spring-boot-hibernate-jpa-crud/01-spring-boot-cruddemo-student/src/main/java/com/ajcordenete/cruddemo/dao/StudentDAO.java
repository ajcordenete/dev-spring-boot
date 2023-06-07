package com.ajcordenete.cruddemo.dao;

import com.ajcordenete.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> getAllStudents();

    List<Student> getStudentsByName(String name);

    void update(Student student);

    void updateStudentsByLastName(String lastName, String newLastName);

    void delete(Integer id);

    int deleteAllStudents();
}
