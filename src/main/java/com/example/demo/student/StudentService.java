package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service // Same as @Component but @Service is more for readability
public class StudentService {
    // implement the StudentRepository interface:
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() { // This method returns a JSON list of student object properties
        return studentRepository.findAll(); // returns a list to us
    }
}
