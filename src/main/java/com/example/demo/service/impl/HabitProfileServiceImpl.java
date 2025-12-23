package com.example.demo.service.impl;

import com.example.demo.dto.HabitProfileDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository habitRepo;
    private final StudentProfileRepository studentRepo;

    public HabitProfileServiceImpl(HabitProfileRepository habitRepo,
                                   StudentProfileRepository studentRepo) {
        this.habitRepo = habitRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public HabitProfile create(Long studentId, HabitProfileDto dto) {

        if (dto.getCleanlinessLevel() < 1 || dto.getCleanlinessLevel() > 5) {
            throw new IllegalArgumentException("range 1-5");
        }

        StudentProfile student = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        HabitProfile habit = habitRepo.findByStudentId(studentId).orElse(new HabitProfile());
        habit.setStudent(student);
        habit.setCleanlinessLevel(dto.getCleanlinessLevel());

        return habitRepo.save(habit);
    }

    @Override
    public HabitProfile getForStudent(Long studentId) {
        return habitRepo.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
    }
}
