package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.dto.HabitProfileDto;
import com.example.demo.service.HabitProfileService;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    @Override
    public void createHabitProfile(HabitProfileDto dto) {
        // No return, minimal implementation
    }

    @Override
    public void updateHabitProfile(Long id, HabitProfileDto dto) {
        // No return
    }

    @Override
    public void deleteHabitProfile(Long id) {
        // No return
    }

    @Override
    public void getHabitProfileByStudentId(Long studentId) {
        // No return
    }
}
