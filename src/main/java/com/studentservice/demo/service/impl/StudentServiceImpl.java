package com.studentservice.demo.service.impl;

import com.studentservice.demo.model.Student;
import com.studentservice.demo.repository.StudentRepository;
import com.studentservice.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Optional<Student> existing = studentRepository.findById(id);
        if (existing.isPresent()) {
            Student s = existing.get();
            s.setFirstName(student.getFirstName());
            s.setLastName(student.getLastName());
            s.setEmail(student.getEmail());
            s.setAge(student.getAge());
            return studentRepository.save(s);
        }
        // if not found, treat as create with provided id (or throw). We'll throw an exception to signal not found.
        throw new IllegalArgumentException("Student not found with id: " + id);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
