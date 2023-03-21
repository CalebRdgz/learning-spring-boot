package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // because this StudentRepository interface is responsible for data access vvv
public interface StudentRepository extends JpaRepository<Student, Long> { // This uses some generics, we have to specify T (type of object we want to work with) and ID (for the type that we want)
}
