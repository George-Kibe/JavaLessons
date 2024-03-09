package com.kibe.udemyAdvanced.dao;

import com.kibe.udemyAdvanced.entity.Course;
import com.kibe.udemyAdvanced.entity.Instructor;
import com.kibe.udemyAdvanced.entity.InstructorDetail;
import com.kibe.udemyAdvanced.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    Instructor findInstructorByIdJoinFetch(int theId);
    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorById(int theId);
    void deleteInstructorDetailById(int theId);
    List<Course> findCoursesByInstructorId(int theId);
    void updateInstructor(Instructor tempInstructor);
    void updateCourse(Course tempCourse);
    Course findCourseById(int theId);
    void deleteCourseById(int theId);
    void saveCourse(Course theCourse);
    Course findCourseAndReviewsByCourseId(int theId);
    Course findCourseAndStudentsByCourseId(int theId);
    Student findStudentAndCoursesByStudentId(int theId);
    void updateStudent(Student tempStudent);
    void deleteStudentById(int theId);
}
