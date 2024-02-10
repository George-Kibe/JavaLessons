package com.kibe.UdemyCrud;

import com.kibe.UdemyCrud.dao.StudentDAO;
import com.kibe.UdemyCrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UdemyCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemyCrudApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			// System.out.println("Hello from runner");
			createStudent(studentDAO);
			// getStudent(studentDAO);
			// getAllStudents(studentDAO);
			// getStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students in database");
		int numberOfRowsDeleted = studentDAO.deleteAll();
		System.out.println("Number of Rows Deleted: " + numberOfRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 6003;
		System.out.println("Deleting student with ID: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on id
		int studentId = 600;
		System.out.println("Gettting student with ID " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		// change firstName to Alex or other
		System.out.println("Updating Student");
		myStudent.setFirstName("Robinson");
		myStudent.setLastName("LastNameUpdated");
		// update the student
		studentDAO.update(myStudent);
		// display the updated student
		System.out.println("Updated student "+ myStudent);
	}

	private void getStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Wambui");
		// display the list of students
		for (Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void getAllStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();
		// display the list of students
		for (Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void getStudent(StudentDAO studentDAO) {
		int theId = 1;
		System.out.println("Retrieving student with ID: " + theId);
		Student theStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the Student "+ theStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new Student object...");
		Student tempStudent = new Student("Kibe", "Wambui", "georgewambui@gmail.com");
		//save the student object
		System.out.println("Saving the student object...");
		studentDAO.save(tempStudent);
		// display id of the saved student
		System.out.println("Saved student. generated id: " + tempStudent.getId());
	}

}
