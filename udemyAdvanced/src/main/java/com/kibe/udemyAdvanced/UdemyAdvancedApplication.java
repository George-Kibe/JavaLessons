package com.kibe.udemyAdvanced;

import com.kibe.udemyAdvanced.dao.AppDAO;
import com.kibe.udemyAdvanced.entity.Course;
import com.kibe.udemyAdvanced.entity.Instructor;
import com.kibe.udemyAdvanced.entity.InstructorDetail;
import com.kibe.udemyAdvanced.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UdemyAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemyAdvancedApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			System.out.println("Hello world from Command Line Runner");
			// createInstructor(appDAO);
			// createInstructorWithCourses(appDAO);
			// findInstructorWithCourses(appDAO);
			// findInstructor(appDAO);
			// deleteInstructor(appDAO);
			// findInstructorDetail(appDAO);
			// deleteInstructorDetail(appDAO);
			// updateInstructor(appDAO);
			// updateCourse(appDAO);
			// deleteCourse(appDAO);
			// createCourseAndReviews(appDAO);
			// retrieveCourseAndReviews(appDAO);
			deleteCourseAndReviews(appDAO);

			// System.out.println("Hello world from Command Line Runner");
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 13;
		System.out.println("Deleting course and reviews of course id: " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Course and its reviews deleted");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		// get course and reviews
		int theId = 13;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
		// print course
		System.out.println("TempCourse: " + tempCourse);
		// print reviews
		System.out.println("Course Reviews: " + tempCourse.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// create a course
		Course tempCourse = new Course("Spring Boot by Chad");
		// add reviews
		tempCourse.addReview(new Review("Job well done"));
		tempCourse.addReview(new Review("Excellent performance"));
		tempCourse.addReview(new Review("What a damn course"));
		// save the course
		appDAO.saveCourse(tempCourse);
		System.out.println("Course and Reviews saved successfully!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course of id: "+ theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 11;
		// find the course
		System.out.println("Finding course of id: "+ theId);
		Course tempCourse = appDAO.findCourseById(theId);
		tempCourse.setTitle("Django for Dummies 2024 Edition");
		appDAO.updateCourse(tempCourse);
		System.out.println("Course updated successfully!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 2;
		// find the instructor
		System.out.println("Finding instructor of id: "+ theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		// update the instructor
		System.out.println("Updating instructor of id: "+ theId);
		tempInstructor.setLastName("Kiffee Updated");
		tempInstructor.setEmail("georgekiffee@gmail.com");
		appDAO.updateInstructor(tempInstructor);
		System.out.println("Instructor updated successfully!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 5;
		System.out.println("Finding instructor of id: "+ theId);
		// Instructor tempInstructor = appDAO.findInstructorById(theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("TempInstructor: "+ tempInstructor);
		// find courses since we have lazy loading, for eager loading it works automatically
		System.out.println("Finding courses for instructor of id: "+ theId);
		// List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		// tempInstructor.setCourses(courses);
		System.out.println("Associated courses: "+ tempInstructor.getCourses());
		System.out.println("Done");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor = new Instructor("George", "Kiffee", "georgekifee@gmail.com");
		// create instructor detail
		InstructorDetail tempInstructordetail = new InstructorDetail("https://www.youtube.com/GeorgeKibe","Travelling");
		// associate instructor to instructor detail
		tempInstructor.setInstructorDetail(tempInstructordetail);
		// create some courses
		Course tempCourse = new Course("Mastering Spring Boot");
		Course tempCourse1 = new Course("Django for Dummies");
		Course tempCourse2 = new Course("Data Engineering with Python");
		// Add courses to instructor
		tempInstructor.addCourse(tempCourse);
		tempInstructor.addCourse(tempCourse1);
		tempInstructor.addCourse(tempCourse2);
		// save the instructor
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Courses: " + tempInstructor.getCourses());
		System.out.println("Instructor and Instructor detail Saved!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting instructor detail of id: "+ theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done and Deleted instructor detail of id: "+ theId);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		// get instructor detail object
		int theId = 3;
		System.out.println("Finding Instructor detail of id: "+ theId);
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		// print the instructor detail
		System.out.println("tempInstructorDetail: "+ tempInstructorDetail);
		// print the associated instructor
		System.out.println("Associated Instructor: "+ tempInstructorDetail.getInstructor());
		System.out.println("Done");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 5;
		System.out.println("Deleting user of id: "+ theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done and Deleted user of id: "+ theId);
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding user of id: "+ theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Temp Instructor: "+ tempInstructor);
	}

	private void createInstructor(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor = new Instructor("George", "Kibe", "georgekibew@gmail.com");
		// create instructor detail
		InstructorDetail tempInstructordetail = new InstructorDetail("https://www.youtube.com/GeorgeKibe","Coding and Chess");
		// associate instructor to instructor detail
		tempInstructor.setInstructorDetail(tempInstructordetail);
		// save the instructor
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Instructor and Instructor detail Saved!");
	}
}
