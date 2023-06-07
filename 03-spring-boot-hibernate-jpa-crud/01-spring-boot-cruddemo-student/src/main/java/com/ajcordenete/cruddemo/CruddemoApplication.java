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
						"Jordan",
						"Poole",
						"party@yahoo.com"
				);

		studentDAO.save(student);

		System.out.println("Saved student. Generated id: " + student.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		int idToFind = 2;

		System.out.println("Getting student. with id: " + idToFind + " result:"+ studentDAO.findById(idToFind));
	}

	private void readAllStudents(StudentDAO studentDAO) {
		System.out.println("All students:"+ studentDAO.getAllStudents());
	}

	private void getStudentByName(StudentDAO studentDAO, String name) {
		System.out.println("All students:"+ studentDAO.getStudentsByName(name));
	}

	private void getStudentAndUpdate(StudentDAO studentDAO, Integer id, String email) {
		Student studentToUpdate = studentDAO.findById(id);
		studentToUpdate.setEmail(email);

		studentDAO.update(studentToUpdate);
	}

	private void updateStudentsByLastName(StudentDAO studentDAO, String lastName, String newLastName) {
		studentDAO.updateStudentsByLastName(lastName, newLastName);
	}

	private void deleteStudent(StudentDAO studentDAO, Integer id) {
		studentDAO.delete(id);
	}

	private void deleteAlLStudents(StudentDAO studentDAO) {
		int rowsAffected = studentDAO.deleteAllStudents();

		System.out.println("Deleted " + rowsAffected + " rows.");
	}
}
