package edu.miu.cs.cs425.studenteregistrarapi.controller;

import edu.miu.cs.cs425.studenteregistrarapi.model.Student;
import edu.miu.cs.cs425.studenteregistrarapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/eregistrar/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //http://localhost/eregistrar/api/student/register - Register a new Student into the system
    @PostMapping(value = "/register")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    //http://localhost/eregistrar/api/student/list - Displays JSON array of Students data.
    @GetMapping(value = "/list")
    public ResponseEntity<List<Student>> getAllStudent() {
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }

    //http://localhost/eregistrar/api/student/get/1 - Read/display a Student data for student with ID, 1.
    @GetMapping(value = "/get/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    //http://localhost/eregistrar/api/student/update/1 - Retrieves and Updates Student data for student with ID, 1.
    @PutMapping(value = "/update/{studentId}")
    public ResponseEntity<Student> updateStudentById(@PathVariable Long studentId, @RequestBody Student student) {
        return new ResponseEntity<>(studentService.updateStudentById(studentId, student), HttpStatus.OK);
    }

    //http://localhost/eregistrar/api/student/delete/3 - Delete the student data for student with ID, 3.
    @DeleteMapping(value = "/delete/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}