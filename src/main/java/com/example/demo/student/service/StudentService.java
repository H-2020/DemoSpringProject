package com.example.demo.student.service;

import com.example.demo.student.repository.IStudentRepository;
import com.example.demo.student.model.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final IStudentRepository studentRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentEntity> getStudents() {
        return studentRepository.findAll();
//        return List.of(new Student(1l, "Mariam", "mariam@gmail.com",
//                LocalDate.of(2000, Month.JANUARY, 5), 21));
    }

    public void addNewStudent(StudentEntity student) {
        Optional<StudentEntity> studentOptional=studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }
    public void deleteStudent(Long studentId){
        boolean exists=studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException("student id" + studentId + "does not exists");
        }
        studentRepository.deleteById(studentId);
    }
}
