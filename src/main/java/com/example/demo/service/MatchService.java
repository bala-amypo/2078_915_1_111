package com.example.demo.service;

import com.example.demo.model.MatchResult;

import java.util.List;

public interface MatchService {

    MatchResult compute(Long studentAId, Long studentBId);

    List<MatchResult> getForStudent(Long studentId);

    MatchResult getById(Long id);
}
