package com.studentservice.demo.service;

import com.studentservice.demo.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}
