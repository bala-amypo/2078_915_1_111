package com.example.demo.service;

import com.example.demo.dto.HabitProfileDto;

public interface HabitProfileService {

    void createHabitProfile(HabitProfileDto dto);

    void updateHabitProfile(Long id, HabitProfileDto dto);

    void deleteHabitProfile(Long id);

    void getHabitProfileByStudentId(Long studentId);
}
