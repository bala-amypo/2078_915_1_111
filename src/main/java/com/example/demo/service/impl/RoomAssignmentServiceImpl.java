package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RoomAssignment;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.RoomAssignmentRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.stereotype.Service;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRepository roomRepo;
    private final StudentProfileRepository studentRepo;

    public RoomAssignmentServiceImpl(RoomAssignmentRepository roomRepo,
                                     StudentProfileRepository studentRepo) {
        this.roomRepo = roomRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public RoomAssignment assignRoom(Long studentAId, Long studentBId) {

        StudentProfile studentA = studentRepo.findById(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("Student A not found"));

        StudentProfile studentB = studentRepo.findById(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("Student B not found"));

        // ensure only active students can be assigned
        if (!studentA.getActive() || !studentB.getActive()) {
            throw new IllegalStateException("Both students must be active to assign room");
        }

        RoomAssignment assignment = new RoomAssignment();

        // IMPORTANT FIX – convert Long → String
        assignment.setStudentAId(String.valueOf(studentA.getId()));
        assignment.setStudentBId(String.valueOf(studentB.getId()));

        assignment.setRoomNumber("R-" + studentA.getId() + "-" + studentB.getId());

        return roomRepo.save(assignment);
    }
}
