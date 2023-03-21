package com.example.demo.student;

import jakarta.persistence.*; // use persistence because if we changed from using hibernate to something else, this will still work

import java.time.LocalDate;
import java.time.Period;

@Entity // This one is for Hibernate
@Table // This one is for the Table in our Database
public class Student {
    // Map the Student table into our Database:
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1) // allocationSize = 1 -> Hibernate: create sequence student_sequence start with 1 increment by 1
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient // no need for this field to be a column in our database. Will be calculated first.
    private Integer age;

    public Student() { // Generate empty constructor (with alt + *)

    }
    // This is the model:
    public Student(Long id, String name, String email, LocalDate dob) { // Generate constructor with all properties
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, String email, LocalDate dob) { // Generate constructor without id because database provides it
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears(); // gets age of student from dob
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
