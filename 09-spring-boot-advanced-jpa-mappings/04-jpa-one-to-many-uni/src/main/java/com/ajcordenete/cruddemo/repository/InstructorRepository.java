package com.ajcordenete.cruddemo.repository;

import com.ajcordenete.cruddemo.entity.Course;
import com.ajcordenete.cruddemo.entity.Instructor;
import com.ajcordenete.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface InstructorRepository {

    void save(Instructor instructor);

    void update(Instructor instructor);

    Instructor findById(int id);

    void delete(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetail(int id);

    List<Course> findCourseByInstructorId(int id);

    Instructor findInstructorByJoinFetch(int id);

    Course findCourseById(int id);

    void updateCourse(Course course);

    void deleteCourse(int id);

    void save(Course course);

    Course findCourseByJoinFetch(int id);
}
