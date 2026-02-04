package com.example.StudentManagement.controller;

import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    public Student addStudent(@RequestBody Student student) {
        return service.save(student);
    }

    @GetMapping
    public String list(@RequestParam(required = false) String keyword,
                       Model model) {
        model.addAttribute("students", service.findByNameContainingIgnoreCase(keyword));
        model.addAttribute("keyword", keyword);
        return "students";
    }


    @GetMapping("/{id}")
    @ResponseBody
    public Student getById(@PathVariable Integer id) {
        return service.findById(id);
    }
    @GetMapping("/new")
    public String newStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }
    // EDIT
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.findById(id.intValue()));
        return "form";
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
}
