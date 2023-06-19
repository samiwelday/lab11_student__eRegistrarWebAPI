package edu.miu.cs.cs425.studenteregistrarapi.service.impl;

import edu.miu.cs.cs425.studenteregistrarapi.model.Student;
import edu.miu.cs.cs425.studenteregistrarapi.repository.StudentRepository;
import edu.miu.cs.cs425.studenteregistrarapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student newstudent) {
        return studentRepository.save(newstudent);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student updateStudentById(Long studentId, Student student) {
        Student existingStudent = studentRepository.findById(studentId).orElse(null);
        if(existingStudent == null) throw new IllegalArgumentException("Student with ID" + studentId + "does not exist");
            existingStudent.setStudentNumber(student.getStudentNumber());
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setMiddleName(student.getMiddleName());
            existingStudent.setCgpa(student.getCgpa());
            existingStudent.setDateOfEnrollment(student.getDateOfEnrollment());
            existingStudent.setInternational(student.isInternational());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
