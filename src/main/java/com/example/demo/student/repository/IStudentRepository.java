package com.example.demo.student.repository;

import com.example.demo.student.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<StudentEntity,Long > {

    @Query("SELECT s FROM StudentEntity s WHERE s.email=?1")
    Optional<StudentEntity> findStudentByEmail(String email);
}
