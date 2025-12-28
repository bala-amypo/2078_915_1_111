package com.example.demo.service;

public interface MatchService {

    void createMatch(Long studentAId, Long studentBId);

    void getMatchById(Long matchId);

    void getAllMatchesForStudent(Long studentId);
}
