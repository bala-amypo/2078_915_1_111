package com.example.demo.service.impl;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {
    private final RoomAssignmentRecordRepository repository;
    private final StudentProfileRepository studentRepository;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repository,
                                   StudentProfileRepository studentRepository) {
        this.repository = repository;
        this.studentRepository = studentRepository;
    }

    @Override
    public RoomAssignmentRecord assignRoom(RoomAssignmentRecord assignment) {
        StudentProfile studentA = studentRepository.findById(assignment.getStudentAId())
            .orElseThrow(() -> new RuntimeException("Student A not found"));
        StudentProfile studentB = studentRepository.findById(assignment.getStudentBId())
            .orElseThrow(() -> new RuntimeException("Student B not found"));

        if (!studentA.getActive() || !studentB.getActive()) {
            throw new IllegalArgumentException("both students must be active");
        }

        assignment.setStatus(RoomAssignmentRecord.Status.ACTIVE);
        return repository.save(assignment);
    }

    @Override
    public RoomAssignmentRecord updateStatus(Long id, String status) {
        RoomAssignmentRecord assignment = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Assignment not found"));
        assignment.setStatus(RoomAssignmentRecord.Status.valueOf(status));
        return repository.save(assignment);
    }

    @Override
    public List<RoomAssignmentRecord> getAssignmentsByStudent(Long studentId) {
        return repository.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public List<RoomAssignmentRecord> getAllAssignments() {
        return repository.findAll();
    }

    @Override
    public RoomAssignmentRecord getAssignmentById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Assignment not found"));
    }
}