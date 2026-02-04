package com.example.student_crud.service;

import com.example.student_crud.model.Enrollment;
import com.example.student_crud.model.Student;
import com.example.student_crud.repository.EnrollmentRepository;
import com.example.student_crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;
    private final EnrollmentRepository enrollmentRepo;

    public StudentService(StudentRepository repo,
                          EnrollmentRepository enrollmentRepo) {
        this.repo = repo;
        this.enrollmentRepo = enrollmentRepo;
    }

    public List<Student> search(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return repo.findAll();
        }
        return repo.findByNameContainingIgnoreCase(keyword);
    }

    public Student getById(Integer id) {
        return repo.getById(id);
    }

    public void save(Student student) {
        repo.save(student);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public List<Enrollment> getEnrollmentsByStudentId(Long id) {
        return enrollmentRepo.findByStudentId(id);
    }
}


