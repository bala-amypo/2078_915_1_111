package com.example.demo.controller;

import com.example.demo.dto.StudentProfileDto;
import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    private final StudentProfileService studentService;

    public StudentProfileController(StudentProfileService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/{userId}")
    public StudentProfile create(@RequestBody StudentProfileDto dto,
                                 @PathVariable Long userId) {
        return studentService.create(dto, userId);
    }

    @GetMapping
    public List<StudentProfile> getAll() {
        return studentService.getAll();
    }
}
