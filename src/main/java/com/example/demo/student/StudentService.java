package com.example.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service // Same as @Component but @Service is more for readability
public class StudentService {
    public List<Student> getStudents() { // This method returns a JSON list of student object properties
        return List.of(new Student(1L, "Mariam", "mariam.jamal@gmail.com", LocalDate.of(2000, Month.JANUARY, 5), 2)
        );
    }
}
