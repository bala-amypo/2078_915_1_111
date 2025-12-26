package com.example.demo.service.impl;

import com.example.demo.dto.StudentProfileDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.StudentProfile;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.StudentProfileService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository studentRepo;
    private final UserAccountRepository userRepo;

    public StudentProfileServiceImpl(StudentProfileRepository studentRepo,
                                     UserAccountRepository userRepo) {
        this.studentRepo = studentRepo;
        this.userRepo = userRepo;
    }

    @Override
    public StudentProfile create(StudentProfileDto dto, Long userId) {
        if (dto.getAge() <= 0) {
            throw new IllegalArgumentException("age must be > 0");
        }

        UserAccount user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        StudentProfile profile = new StudentProfile();
        profile.setAge(dto.getAge());
        profile.setUserAccount(user);

        return studentRepo.save(profile);
    }

    @Override
    public StudentProfile update(Long id, StudentProfileDto dto) {
        StudentProfile profile = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        profile.setAge(dto.getAge());
        return studentRepo.save(profile);
    }

    @Override
    public StudentProfile get(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    @Override
    public List<StudentProfile> getAll() {
        return studentRepo.findAll();
    }
}
