package com.example.demo.student.service;

import com.example.demo.student.repository.IStudentRepository;
import com.example.demo.student.model.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

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
            throw new IllegalStateException("student id" + studentId + "does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId,String name,String email){
        StudentEntity studentEntity=studentRepository.findById(studentId)
                .orElseThrow(()->new IllegalStateException(
                        "student with id "+studentId+" does not exists"));
                if(name!=null&&name.length()>0 &&
                !Objects.equals(studentEntity.getName(),name)){
                    studentEntity.setName(name);
                }
        if(email!=null&& email.length()>0 &&
                !Objects.equals(studentEntity.getEmail(),email)){
            Optional<StudentEntity> studentEntityOptional=studentRepository.findStudentByEmail(email);
            if(studentEntityOptional.isPresent()){
                throw new IllegalStateException("email taken");

            }
            studentEntity.setEmail(email);
        }
    }
}
