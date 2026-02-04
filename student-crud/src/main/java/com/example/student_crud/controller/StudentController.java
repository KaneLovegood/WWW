package com.example.student_crud.controller;

import com.example.student_crud.model.Student;
import com.example.student_crud.service.StudentService;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // LIST + SEARCH
    @GetMapping
    public String list(@RequestParam(required = false) String keyword,
                       Model model) {
        model.addAttribute("students", service.search(keyword));
        model.addAttribute("keyword", keyword);
        return "students";
    }

    // ADD
    @GetMapping("/new")
    public String addForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    // EDIT
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.getById(id.intValue()));
        return "student-form";
    }

    // SAVE
    @PostMapping("/save")
    public String save(@ModelAttribute Student student) {
        service.save(student);
        return "redirect:/students";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id.intValue());
        return "redirect:/students";
    }

    // VIEW SUBJECTS
    @GetMapping("/{id}/subjects")
    public String subjects(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.getById(id.intValue()));
        model.addAttribute("enrollments",
                service.getEnrollmentsByStudentId(id));
        return "student-subjects";
    }
}




