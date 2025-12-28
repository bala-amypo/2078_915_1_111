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

    private final RoomAssignmentRecordRepository assignmentRepository;
    private final StudentProfileRepository studentRepository;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository assignmentRepository,
                                     StudentProfileRepository studentRepository) {
        this.assignmentRepository = assignmentRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public RoomAssignmentRecord assignRoom(Long studentAId, Long studentBId) {

        StudentProfile studentA = studentRepository.findById(studentAId)
                .orElseThrow(() -> new RuntimeException("Student A not found"));

        StudentProfile studentB = studentRepository.findById(studentBId)
                .orElseThrow(() -> new RuntimeException("Student B not found"));

        RoomAssignmentRecord record =
                new RoomAssignmentRecord(studentA.getStudentId(), studentB.getStudentId());

        return assignmentRepository.save(record);
    }

    @Override
    public List<RoomAssignmentRecord> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    @Override
    public List<RoomAssignmentRecord> getAssignmentsByStudent(Long studentId) {
        return assignmentRepository.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public RoomAssignmentRecord getAssignmentById(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
    }

    @Override
    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }
}
