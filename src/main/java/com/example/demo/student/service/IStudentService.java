package com.example.demo.student.service;

import com.example.demo.student.model.entity.StudentEntity;

import java.util.List;


public interface IStudentService {


    List<StudentEntity> getStudents();

    void addNewStudent(StudentEntity student);

    void deleteStudent(Long studentId);

    void updateStudent(Long studentId, String name, String email);
}
