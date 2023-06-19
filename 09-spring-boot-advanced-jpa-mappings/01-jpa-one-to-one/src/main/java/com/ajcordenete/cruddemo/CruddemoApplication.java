package com.ajcordenete.cruddemo;

import com.ajcordenete.cruddemo.entity.Instructor;
import com.ajcordenete.cruddemo.entity.InstructorDetail;
import com.ajcordenete.cruddemo.repository.InstructorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner cmdRunner(InstructorRepository repository) {
		return runner -> {
			deleteInstructor(repository);
		};
	}

	private void createInstructor(InstructorRepository repository) {
		Instructor newInstructor = new Instructor(
				"Steph",
				"Curry",
				"sc@yahoo.com"
		);

		InstructorDetail newInstructorDetail = new InstructorDetail(
				"https://www.youtube.com/aja",
				"Coding"
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
		repository.delete(1);
	}
}
