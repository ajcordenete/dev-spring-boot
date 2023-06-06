package com.ajcordenete.cruddemo;

import com.ajcordenete.cruddemo.dao.StudentDAO;
import com.ajcordenete.cruddemo.entity.Student;
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
	public CommandLineRunner cmdRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {

		Student student = new Student(
						"LeBron",
						"James",
						"lbj@yahoo.com"
				);

		studentDAO.save(student);

		System.out.println("Saved student. Generated id: " + student.getId());
	}
}
