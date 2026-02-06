package com.example.StudentManagement.service;

import com.example.StudentManagement.model.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);
    List<Student> findAll();
    Student findById(Integer id);
    boolean delete(Integer id);
    List<Student> findByNameContainingIgnoreCase(String keyword);
}
