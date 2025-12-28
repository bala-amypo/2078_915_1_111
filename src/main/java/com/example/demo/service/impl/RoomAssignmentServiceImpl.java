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
    private final StudentProfileRepository studentRepo;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repository,
                                     StudentProfileRepository studentRepo) {
        this.repository = repository;
        this.studentRepo = studentRepo;
    }

    @Override
    public RoomAssignmentRecord assignRoom(RoomAssignmentRecord record) {

        StudentProfile studentA = studentRepo.findById(record.getStudentAId())
                .orElseThrow(() -> new RuntimeException("Student A not found"));

        StudentProfile studentB = studentRepo.findById(record.getStudentBId())
                .orElseThrow(() -> new RuntimeException("Student B not found"));

        if (!studentA.isActive() || !studentB.isActive()) {
            throw new RuntimeException("Both students must be active");
        }

        return repository.save(record);
    }

    @Override
    public List<RoomAssignmentRecord> getAssignments() {
        return repository.findAll();
    }

    @Override
    public List<RoomAssignmentRecord> getAssignmentsByStudent(Long studentId) {
        return repository.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public RoomAssignmentRecord getAssignmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
    }

    @Override
    public void deleteAssignment(Long id) {
        repository.deleteById(id);
    }
}
