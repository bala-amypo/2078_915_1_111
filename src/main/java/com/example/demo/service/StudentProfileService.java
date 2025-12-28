package com.example.demo.service;

import com.example.demo.dto.StudentProfileDto;

public interface StudentProfileService {

    void createStudentProfile(StudentProfileDto dto);

    void updateStudentProfile(Long id, StudentProfileDto dto);

    void deleteStudentProfile(Long id);

    void getStudentProfileById(Long id);
}
