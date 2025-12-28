package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    @PostMapping
    public void createStudent() {
        // method definition only
    }

    @GetMapping("/{id}")
    public void getStudentById(@PathVariable Long id) {
        // method definition only
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id) {
        // method definition only
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        // method definition only
    }
}
