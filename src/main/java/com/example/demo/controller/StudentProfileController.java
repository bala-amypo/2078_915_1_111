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
    public StudentProfile createProfile(
            @RequestBody StudentProfileDto dto,
            @PathVariable Long userId) {
        return studentService.create(dto, userId);
    }

    @PutMapping("/{id}")
    public StudentProfile updateProfile(
            @PathVariable Long id,
            @RequestBody StudentProfileDto dto) {
        return studentService.update(id, dto);
    }

    @GetMapping("/{id}")
    public StudentProfile getProfile(@PathVariable Long id) {
        return studentService.get(id);
    }

    @GetMapping
    public List<StudentProfile> getAllProfiles() {
        return studentService.getAll();
    }
}
