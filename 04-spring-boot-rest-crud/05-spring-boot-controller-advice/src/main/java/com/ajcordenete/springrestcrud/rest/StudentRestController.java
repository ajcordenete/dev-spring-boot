package com.ajcordenete.springrestcrud.rest;

import com.ajcordenete.springrestcrud.StudentNotFoundException;
import com.ajcordenete.springrestcrud.model.Student;
import com.ajcordenete.springrestcrud.model.StudentErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students = new ArrayList<>();

    @PostConstruct
    private void initStudents() {
        students.add(new Student("Steph", "Curry"));
        students.add(new Student("DayDay", "Green"));
        students.add(new Student("Klay", "Thompson"));
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if(studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found " + studentId);
        }

        return students.get(studentId);
    }
}
