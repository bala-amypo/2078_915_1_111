package com.example.demo.service.impl;

import com.example.demo.model.MatchResult;
import com.example.demo.repository.MatchResultRepository;
import com.example.demo.service.MatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchResultRepository repo;

    public MatchServiceImpl(MatchResultRepository repo) {
        this.repo = repo;
    }

    @Override
    public MatchResult computeMatch(Long a, Long b) {
        MatchResult result = new MatchResult();
        result.setStudentAId(a);
        result.setStudentBId(b);
        result.setScore(75.0);
        return repo.save(result);
    }

    @Override
    public List<MatchResult> getMatchesForStudent(Long studentId) {
        return repo.findByStudentAIdOrStudentBId(studentId, studentId);
    }
}
