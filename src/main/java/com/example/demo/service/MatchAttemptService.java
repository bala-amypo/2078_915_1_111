package com.example.demo.service;

import com.example.demo.model.MatchResult;
import java.util.List;

public interface MatchService {
    MatchResult computeMatch(Long studentAId, Long studentBId);
    List<MatchResult> getMatchesForStudent(Long studentId);
}
