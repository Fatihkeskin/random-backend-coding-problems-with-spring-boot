package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
// responsible for data access
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("Select s from Student s where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    @Query("Select s from Student s where s.name = ?1")
    Optional<Student> findStudentByName(String name);
}
