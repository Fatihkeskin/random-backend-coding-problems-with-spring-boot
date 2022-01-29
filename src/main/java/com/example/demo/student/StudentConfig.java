package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "asdfsa@gmail.com",
                    LocalDate.of(1996, 4, 5),
                    24);

            Student alex = new Student(
                    "alex",
                    "alex@gmail.com",
                    LocalDate.of(2006, Month.JANUARY, 5),
                    27);

            repository.saveAll(List.of(mariam, alex));
        };
    }
}
