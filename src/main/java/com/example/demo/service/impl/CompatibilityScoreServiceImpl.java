package com.example.demo.service.impl;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {
    private final CompatibilityScoreRecordRepository repository;
    private final HabitProfileRepository habitRepository;

    public CompatibilityScoreServiceImpl(CompatibilityScoreRecordRepository repository, 
                                       HabitProfileRepository habitRepository) {
        this.repository = repository;
        this.habitRepository = habitRepository;
    }

    @Override
    public CompatibilityScoreRecord computeScore(Long studentAId, Long studentBId) {
        if (studentAId.equals(studentBId)) {
            throw new IllegalArgumentException("Cannot compute score for same student");
        }

        HabitProfile habitA = habitRepository.findByStudentId(studentAId)
            .orElseThrow(() -> new RuntimeException("Habit profile not found"));
        HabitProfile habitB = habitRepository.findByStudentId(studentBId)
            .orElseThrow(() -> new RuntimeException("Habit profile not found"));

        double score = calculateCompatibilityScore(habitA, habitB);
        
        Optional<CompatibilityScoreRecord> existing = repository.findByStudentAIdAndStudentBId(studentAId, studentBId);
        CompatibilityScoreRecord record;
        
        if (existing.isPresent()) {
            record = existing.get();
            record.setScore(score);
            record.setComputedAt(LocalDateTime.now());
        } else {
            record = new CompatibilityScoreRecord();
            record.setStudentAId(studentAId);
            record.setStudentBId(studentBId);
            record.setScore(score);
        }
        
        return repository.save(record);
    }

    private double calculateCompatibilityScore(HabitProfile a, HabitProfile b) {
        double score = 0;
        int factors = 0;

        if (a.getSleepSchedule() != null && b.getSleepSchedule() != null) {
            score += a.getSleepSchedule() == b.getSleepSchedule() ? 25 : 0;
            factors++;
        }
        if (a.getCleanlinessLevel() != null && b.getCleanlinessLevel() != null) {
            score += a.getCleanlinessLevel() == b.getCleanlinessLevel() ? 25 : 0;
            factors++;
        }
        if (a.getNoiseTolerance() != null && b.getNoiseTolerance() != null) {
            score += a.getNoiseTolerance() == b.getNoiseTolerance() ? 25 : 0;
            factors++;
        }
        if (a.getSocialPreference() != null && b.getSocialPreference() != null) {
            score += a.getSocialPreference() == b.getSocialPreference() ? 25 : 0;
            factors++;
        }

        return factors > 0 ? score : 50.0;
    }

    @Override
    public CompatibilityScoreRecord getScoreById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Score not found"));
    }

    @Override
    public List<CompatibilityScoreRecord> getScoresForStudent(Long studentId) {
        return repository.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores() {
        return repository.findAll();
    }
}