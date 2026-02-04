package com.example.student_crud.controller;

import com.example.student_crud.repository.SubjectRepository;
import com.example.student_crud.service.EnrollmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    private final SubjectRepository subjectRepo;

    public EnrollmentController(EnrollmentService enrollmentService,
                                SubjectRepository subjectRepo) {
        this.enrollmentService = enrollmentService;
        this.subjectRepo = subjectRepo;
    }

    // FORM ĐĂNG KÝ
    @GetMapping("/student/{id}")
    public String form(@PathVariable Long id, Model model) {
        model.addAttribute("studentId", id);
        model.addAttribute("subject", subjectRepo.findAll());
        return "enroll-form";
    }

    // SUBMIT
    @PostMapping("/save")
    public String save(@RequestParam Long studentId,
                       @RequestParam Long subjectId) {
        enrollmentService.enroll(studentId, subjectId);
        return "redirect:/students/" + studentId + "/subjects";
    }
}

