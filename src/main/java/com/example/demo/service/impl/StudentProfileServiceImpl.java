package com.example.demo.service.impl;

import com.example.demo.dto.StudentProfileDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentProfile createStudent(StudentProfileDto dto) {

        StudentProfile profile = new StudentProfile();
        profile.setFullName(dto.getFullName());
        profile.setEmail(dto.getEmail());
        profile.setAge(dto.getAge());
        profile.setActive(true);

        return repo.save(profile);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id: " + id));
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public StudentProfile updateStudentStatus(Long id, Boolean active) {
        StudentProfile profile = getStudentById(id);
        profile.setActive(active);
        return repo.save(profile);
    }
}
