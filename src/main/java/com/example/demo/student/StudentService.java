package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent())
            throw new IllegalStateException("email taken");

        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if(exists){
            studentRepository.deleteById(id);
        } else {
            throw new IllegalStateException("student with id " + id + " does not exists!");
        }
    }

    @Transactional
    public void updateStudent(Student student) {
        Optional<Student> studentBeforeUpdate = studentRepository.findStudentByName(student.getName());
        if (studentBeforeUpdate.isPresent()) {
            studentBeforeUpdate.get().setName(student.getName());
            studentBeforeUpdate.get().setEmail(student.getEmail());
        } else {
            throw new IllegalStateException("student with given credentials are not found");
        }
    }
}
