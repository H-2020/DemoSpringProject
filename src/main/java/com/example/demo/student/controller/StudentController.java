package com.example.demo.student.controller;

import com.example.demo.student.model.entity.StudentEntity;
import com.example.demo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

//    @Autowired
//    public StudentController(StudentService studentService) {
//
//        this.studentService = studentService;
//    }

    @GetMapping
//    public String hello() {
//        return "Hello World";
//    }
    public List<StudentEntity> getStudents() {

        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody StudentEntity student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

}
