package com.kibe.UdemyCrud.rest;

import com.kibe.UdemyCrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    // list of students to mimic a database
    private List<Student> theStudents;
    // @PostConstruct to load data upon construct
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Paulina", "Patel", "paulina@gmail.com"));
        theStudents.add(new Student("Alexa", "Amazon", "alexa@gmail.com"));
        theStudents.add(new Student("Charu", "Patel", "charu@gmail.com"));
    }
    // define endpoint for /students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // check the student against the list size
        if ((studentId >= theStudents.size()) || studentId < 0){
            throw new StudentNotFoundException("Student ID Not Found: " + studentId);
        }

        return theStudents.get(studentId);
    }

}
