package com.example.demo.controller;

import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    // Create a new student profile
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentProfile createStudentProfile(@RequestBody StudentProfile profile) {
        return studentProfileService.create(profile);
    }

    // Get student profile by ID
    @GetMapping("/{id}")
    public StudentProfile getStudentProfile(@PathVariable Long id) {
        return studentProfileService.getProfile(id);
    }

    // Get all student profiles
    @GetMapping
    public List<StudentProfile> getAllStudentProfiles() {
        return studentProfileService.getAllProfiles();
    }

    // Update student profile
    @PutMapping("/{id}")
    public StudentProfile updateStudentProfile(
            @PathVariable Long id,
            @RequestBody StudentProfile profile) {
        return studentProfileService.updateProfile(id, profile);
    }
}
