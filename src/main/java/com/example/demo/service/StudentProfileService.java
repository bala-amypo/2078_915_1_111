package com.example.demo.service;

import com.example.demo.dto.StudentProfileDto;
import com.example.demo.model.StudentProfile;

import java.util.List;

public interface StudentProfileService {

    StudentProfile create(StudentProfileDto dto, Long userId);

    StudentProfile update(Long id, StudentProfileDto dto);

    StudentProfile get(Long id);

    List<StudentProfile> getAll();
}
