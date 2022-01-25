package com.example.demo.student;

import com.example.demo.student.model.entity.StudentEntity;
import com.example.demo.student.repository.IStudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(IStudentRepository repository) {

        return (args) -> {
            StudentEntity mariam=new StudentEntity(
                    "Mariam",
                    "mariam@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );
            StudentEntity alex=new StudentEntity(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 5)
            );
            repository.saveAll(
                    List.of(mariam,alex)
            );
        };
    }
}
