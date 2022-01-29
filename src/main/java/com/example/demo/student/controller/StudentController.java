package com.example.demo.student.controller;

import com.example.demo.student.model.entity.StudentEntity;
import com.example.demo.student.service.IStudentService;
import com.example.demo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

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

        return iStudentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody StudentEntity student) {

        iStudentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {

        iStudentService.deleteStudent(studentId);
    }
    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        iStudentService.updateStudent(studentId,name,email);
    }



}
