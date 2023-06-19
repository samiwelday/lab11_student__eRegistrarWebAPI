package edu.miu.cs.cs425.studenteregistrarapi.service;

import edu.miu.cs.cs425.studenteregistrarapi.model.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student newstudent);

    List<Student> getAllStudent();

    Student getStudentById(Long studentId);

    Student updateStudentById(Long studentId, Student student);

    void deleteStudentById(Long studentId);
}