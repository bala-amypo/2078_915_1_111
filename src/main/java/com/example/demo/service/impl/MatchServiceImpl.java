package com.example.demo.service.impl;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {
    private final MatchAttemptRecordRepository repository;
    private final CompatibilityScoreRecordRepository scoreRepository;

    public MatchAttemptServiceImpl(MatchAttemptRecordRepository repository,
                                 CompatibilityScoreRecordRepository scoreRepository) {
        this.repository = repository;
        this.scoreRepository = scoreRepository;
    }

    @Override
    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord attempt) {
        if (attempt.getResultScoreId() != null && scoreRepository.findById(attempt.getResultScoreId()).isPresent()) {
            attempt.setStatus(MatchAttemptRecord.Status.MATCHED);
        } else {
            attempt.setStatus(MatchAttemptRecord.Status.PENDING_REVIEW);
        }
        return repository.save(attempt);
    }

    @Override
    public MatchAttemptRecord updateAttemptStatus(Long id, String status) {
        MatchAttemptRecord attempt = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Match attempt not found"));
        attempt.setStatus(MatchAttemptRecord.Status.valueOf(status));
        return repository.save(attempt);
    }

    @Override
    public List<MatchAttemptRecord> getAttemptsByStudent(Long studentId) {
        return repository.findByInitiatorStudentIdOrCandidateStudentId(studentId, studentId);
    }

    @Override
    public List<MatchAttemptRecord> getAllMatchAttempts() {
        return repository.findAll();
    }
}