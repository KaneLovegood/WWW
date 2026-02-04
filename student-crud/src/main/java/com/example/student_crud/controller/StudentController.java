package com.example.student_crud.controller;

import com.example.student_crud.model.Student;
import com.example.student_crud.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", service.getAll());
        return "students";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }
    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model) {
        int idInt = id.intValue();
        Student student = service.getById(idInt);
        if (student == null) {
            return "redirect:/students";
        }
        model.addAttribute("student", student);
        return "student-form";
    }



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        int idInt = id.intValue();
        service.delete(idInt);
        return "redirect:/students";
    }

    @PostMapping("/save")
    public String save(
            @Valid @ModelAttribute("student") Student student,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "student-form";
        }
        service.save(student);
        return "redirect:/students";
    }
}



