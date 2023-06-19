package edu.miu.cs.cs425.studenteregistrarapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Student number is required and it shouldn't be Empty, Null or Blank")
    private String studentNumber;;
    @Column(nullable = false)
    @NotBlank(message = "First name is required and it shouldn't be Empty, Null or Blank")
    private String firstName;

    private String middleName;
    @Column(nullable = false)
    @NotBlank(message = "Last name is required")
    private String lastName;
    private double cgpa;
    @Column(nullable = false)
    private LocalDate dateOfEnrollment;
    @Column(nullable = false)
    private boolean isInternational;

    public Student(String studentNumber, String firstName, String middleName, String lastName, double cgpa, LocalDate dateOfEnrollment, boolean isInternational) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.isInternational = isInternational;
    }
}
