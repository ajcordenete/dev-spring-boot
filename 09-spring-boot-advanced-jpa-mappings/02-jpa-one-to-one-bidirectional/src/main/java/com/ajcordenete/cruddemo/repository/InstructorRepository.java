package com.ajcordenete.cruddemo.repository;

import com.ajcordenete.cruddemo.entity.Instructor;
import com.ajcordenete.cruddemo.entity.InstructorDetail;

public interface InstructorRepository {

    void save(Instructor instructor);

    Instructor findById(int id);

    void delete(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetail(int id);
}
