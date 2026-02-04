package com.example.StudentManagement.service;

import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    // Constructor Injection (DI)
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Student> findByNameContainingIgnoreCase(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return repository.findAll();
        }
        return repository.findByNameContainingIgnoreCase(keyword);
    }

}
