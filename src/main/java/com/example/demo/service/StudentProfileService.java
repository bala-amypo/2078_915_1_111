package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.exception.*;
import com.example.demo.dto.*;
import com.example.demo.service.*;

import org.springframework.stereotype.Service;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;
    private final UserAccountRepository userRepo;

    public StudentProfileServiceImpl(StudentProfileRepository repo, UserAccountRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public StudentProfile create(StudentProfileDto dto, Long userId) {
        if (dto.getAge() <= 0)
            throw new IllegalArgumentException("age must be > 0");

        UserAccount user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        StudentProfile s = new StudentProfile();
        s.setAge(dto.getAge());
        s.setUserAccount(user);

        return repo.save(s);
    }

    public StudentProfile get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }
}
