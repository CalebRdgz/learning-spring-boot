package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService; // Reference to StudentService
    @Autowired // ^^This StudentService is Autowired (injected into this constructor vvv)
    public StudentController(StudentService studentService) { // Constructor
        this.studentService = studentService; // pass the reference to StudentService into StudentController
    }

    @GetMapping // annotate with @GetMapping to serve the method as a RESTful endpoint at "/". The route is in the parenthesis, also can pass parameters like method type and rout name itself
    public List<Student> getStudents() { // This method returns a JSON list
        return studentService.getStudents();
    }
}
