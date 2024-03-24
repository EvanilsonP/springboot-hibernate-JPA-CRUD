package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
			createStudents(studentDAO);
		};
	}

	private void createStudents(StudentDAO studentDAO) {
		// create the students object
		System.out.println("Creating students...");
		Student tempStudent2 = new Student("Mario", "Gomez", "lapea@gmail.com");
		Student tempStudent3 = new Student("Maria", "Ace", "lapasda@gmail.com");
		Student tempStudent4 = new Student("Aruajo", "Lambida", "cbkca@gmail.com");

		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Joe", "Doe", "aaa@gmail.com");

		// save the student object
		System.out.println("Saving student...");
		studentDAO.save(tempStudent);

		// display the id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
