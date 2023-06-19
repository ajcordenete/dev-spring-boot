package com.ajcordenete.cruddemo;

import com.ajcordenete.cruddemo.entity.Course;
import com.ajcordenete.cruddemo.entity.Instructor;
import com.ajcordenete.cruddemo.entity.InstructorDetail;
import com.ajcordenete.cruddemo.entity.Review;
import com.ajcordenete.cruddemo.repository.InstructorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner cmdRunner(InstructorRepository repository) {
		return runner -> {
			deleteCourse(repository);
		};
	}

	private void createInstructor(InstructorRepository repository) {
		Instructor newInstructor = new Instructor(
				"Klay",
				"Thompson",
				"klay@yahoo.com"
		);

		InstructorDetail newInstructorDetail = new InstructorDetail(
				"https://www.youtube.com/klay11",
				"Shooting"
		);

		newInstructor.setInstructorDetail(newInstructorDetail);

		repository.save(newInstructor);
	}

	private void findInstructor(InstructorRepository repository) {
		Instructor instructor = repository.findById(1);

		System.out.println("Instructor: " + instructor.getFirstName() + " " + instructor.getLastName());
		System.out.println("email: " + instructor.getEmail());
		System.out.println("details: " + instructor.getInstructorDetail());
	}

	private void deleteInstructor(InstructorRepository repository) {
		repository.delete(4);
	}

	private void deleteInstructorDetail(InstructorRepository repository) {
		repository.deleteInstructorDetail(4);
	}

	private void findInstructorDetail(InstructorRepository repository) {
		InstructorDetail instructorDetail = repository.findInstructorDetailById(3);
		Instructor instructor = instructorDetail.getInstructor();

		System.out.println("Instructor: " + instructor.getFirstName() + " " + instructor.getLastName());
		System.out.println("email: " + instructor.getEmail());
		System.out.println("details: " + instructor.getInstructorDetail());
	}

	private void createInstructorWithCourse(InstructorRepository repository) {
		Instructor newInstructor = new Instructor(
				"Klay",
				"Thompson",
				"klay@yahoo.com"
		);

		InstructorDetail newInstructorDetail = new InstructorDetail(
				"https://www.youtube.com/capt",
				"Shooting"
		);

		newInstructor.setInstructorDetail(newInstructorDetail);

		Course course = new Course("Shooting Masterclass");

		newInstructor.addCourse(course);
		repository.save(newInstructor);

		System.out.println("Instructor: " + newInstructor.getFirstName() + " " + newInstructor.getLastName());
		System.out.println("email: " + newInstructor.getEmail());
		System.out.println("details: " + newInstructor.getInstructorDetail());
	}

	private void addCoursesToInstructor(InstructorRepository repository) {
		Instructor newInstructor = repository.findInstructorByJoinFetch(1);

		System.out.println("Instructor: " + newInstructor.getFirstName() + " " + newInstructor.getLastName());
		System.out.println("email: " + newInstructor.getEmail());
		System.out.println("details: " + newInstructor.getInstructorDetail());

		Course course1 = new Course("Shooting Masterclass");
		Course course2 = new Course("Midrange Masterclass");

		newInstructor.addCourse(course1);
		newInstructor.addCourse(course2);

		repository.update(newInstructor);
	}

	private void findInstructorWithCourses(InstructorRepository repository) {
		Instructor newInstructor = repository.findById(2);

		List<Course> courses = repository.findCourseByInstructorId(newInstructor.getId());
		newInstructor.setCourses(courses);

		System.out.println("Instructor: " + newInstructor.getFirstName() + " " + newInstructor.getLastName());
		System.out.println("email: " + newInstructor.getEmail());
		System.out.println("details: " + newInstructor.getInstructorDetail());
		System.out.println("courses: " + newInstructor.getCourses());
	}

	private void findInstructorUsingJoinFetch(InstructorRepository repository) {
		Instructor newInstructor = repository.findInstructorByJoinFetch(1);

		System.out.println("Instructor: " + newInstructor.getFirstName() + " " + newInstructor.getLastName());
		System.out.println("email: " + newInstructor.getEmail());
		System.out.println("details: " + newInstructor.getInstructorDetail());
		System.out.println("courses: " + newInstructor.getCourses());
	}

	private void updateCourse(InstructorRepository repository) {
		Instructor instructor = repository.findById(2);

		Course course = repository.findCourseById(12);
		course.setInstructor(instructor);

		repository.updateCourse(course);
	}

	private void deleteCourse(InstructorRepository repository) {

		repository.deleteCourse(12);
	}

	private void createCourseAndReviews(InstructorRepository repository) {
		Course course = new Course("Defense Masterclass");

		Review review1 = new Review("Amazing!");
		Review review2 = new Review("Great course!");

		course.addReview(review1);
		course.addReview(review2);

		repository.save(course);
	}

	private void getCourseAndReviews(InstructorRepository repository) {
		Course course = repository.findCourseByJoinFetch(12);

		System.out.println("Course: " + course.getTitle());
		System.out.println("Instructor: " + course.getInstructor());
		System.out.println("Reviews: " + course.getReviews());
	}
}
