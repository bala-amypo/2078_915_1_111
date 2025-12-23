package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.MatchResult;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.MatchResultRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.MatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchResultRepository matchRepo;
    private final StudentProfileRepository studentRepo;

    public MatchServiceImpl(MatchResultRepository matchRepo,
                            StudentProfileRepository studentRepo) {
        this.matchRepo = matchRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public MatchResult compute(Long studentAId, Long studentBId) {

        StudentProfile a = studentRepo.findById(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        StudentProfile b = studentRepo.findById(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        MatchResult result = new MatchResult();
        result.setStudentA(a);
        result.setStudentB(b);
        result.setScore(80.0);

        return matchRepo.save(result);
    }

    @Override
    public List<MatchResult> getForStudent(Long studentId) {
        return matchRepo.findByStudentAIdOrStudentBIdOrderByScoreDesc(studentId, studentId);
    }

    @Override
    public MatchResult getById(Long id) {
        return matchRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
    }
}
