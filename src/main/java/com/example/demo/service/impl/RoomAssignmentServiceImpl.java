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
        return repository.save(record);
    }

    @Override
    public RoomAssignmentRecord getAssignmentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<RoomAssignmentRecord> getAllAssignments() {
        return repository.findAll();
    }

    @Override
    public List<RoomAssignmentRecord> getAssignmentsByStudent(Long studentId) {
        return repository.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public void deleteAssignment(Long id) {
        repository.deleteById(id);
    }

    @Override
    public RoomAssignmentRecord createPair(Long studentAId, Long studentBId, String roomNumber) {

        StudentProfile studentA = studentRepo.findById(studentAId).orElseThrow();
        StudentProfile studentB = studentRepo.findById(studentBId).orElseThrow();

        RoomAssignmentRecord record = new RoomAssignmentRecord();
        record.setStudentAId(studentAId);
        record.setStudentBId(studentBId);
        record.setRoomNumber(roomNumber);

        return repository.save(record);
    }
}
