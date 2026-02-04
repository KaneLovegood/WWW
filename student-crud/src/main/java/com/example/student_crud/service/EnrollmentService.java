package com.example.student_crud.service;

import com.example.student_crud.model.Enrollment;
import com.example.student_crud.repository.EnrollmentRepository;
import com.example.student_crud.repository.StudentRepository;
import com.example.student_crud.repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepo;
    private final StudentRepository studentRepo;
    private final SubjectRepository subjectRepo;

    public EnrollmentService(
            EnrollmentRepository enrollmentRepo,
            StudentRepository studentRepo,
            SubjectRepository subjectRepo) {
        this.enrollmentRepo = enrollmentRepo;
        this.studentRepo = studentRepo;
        this.subjectRepo = subjectRepo;
    }

    public void enroll(Long studentId, Long subjectId) {
        Enrollment e = new Enrollment();
        e.setStudent(studentRepo.findById(studentId.intValue()).orElseThrow());
        e.setSubject(subjectRepo.findById(subjectId).orElseThrow());
        e.setSemester("2026-1");
        enrollmentRepo.save(e);
    }
}

