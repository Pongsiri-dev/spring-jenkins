package com.ex.spring_boot_rest_api.controller;

import com.ex.spring_boot_rest_api.bean.Student;
import com.ex.spring_boot_rest_api.handle.ErrorDetails;
import com.ex.spring_boot_rest_api.handle.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // HTTP GET Request
    // localhost:8080/student
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(
                1L,
                "Software",
                "Developer"
        );
        return student;
    }

    // HTTP GET Request
    // localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> student = new ArrayList<>();
        student.add(new Student(1L, "Alexander","Abraham"));
        student.add(new Student(2L, "Alexander","Abraham"));
        student.add(new Student(3L, "Alexander","Abraham"));
        student.add(new Student(4L, "Alexander","Abraham"));
        student.add(new Student(5L, "Alexander","Abraham"));

        return student;
    }

    @GetMapping("/student/{id}")
    public Student studentPathVariable(@PathVariable("id") Long studentId){
        if(studentId == 5){
            throw new ResourceNotFoundException("User","ID",studentId);
        }else {
            return new Student(studentId, "Mr.Stock", "Exchange");
        }
    }

    // HTTP Get Request
    // localhost:8080/student/{id}/{first-name}/{last-name}
    // Dynamic @PathVariable
    @GetMapping("/student/{id}/{first-name}/{last-name}")
    public Student studentDynamic(@PathVariable("id") Long id, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName){
        return new Student(id,firstName,lastName);
    }

    // HTTP GET REQUEST
    // localhost:8080/student/query?id=199&firstName=Spring&lastName=Boot
    // Dynamic @RequestParam
    @GetMapping("student/query")
    public Student studentParamDynamic(@RequestParam Long id, @RequestParam String firstName, @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }



    // Handle Exception
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
//        ErrorDetails errDetail = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "User_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errDetail, HttpStatus.NOT_FOUND);
//    }
}
