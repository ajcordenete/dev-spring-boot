package com.ajcordenete.springrestcrud.rest;

import com.ajcordenete.springrestcrud.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return populateStudents();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        List<Student> students = populateStudents();

        return students.get(studentId);
    }

    private List<Student> populateStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Steph", "Curry"));
        students.add(new Student("DayDay", "Green"));
        students.add(new Student("Klay", "Thompson"));

        return students;
    }
}
