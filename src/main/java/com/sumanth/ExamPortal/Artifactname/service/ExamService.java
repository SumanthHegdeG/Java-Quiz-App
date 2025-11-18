package com.sumanth.ExamPortal.Artifactname.service;


import com.sumanth.ExamPortal.Artifactname.dto.exam.CreateExamRequest;
import com.sumanth.ExamPortal.Artifactname.dto.exam.ExamDto;
import com.sumanth.ExamPortal.Artifactname.model.Exam;
import com.sumanth.ExamPortal.Artifactname.model.User;
import com.sumanth.ExamPortal.Artifactname.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;


    public ExamDto createExam(CreateExamRequest req, User creator) {

        Exam exam = Exam.builder()
                .title(req.getTitle())
                .startTime(Instant.parse(req.getStartTime()))
                .endTime(Instant.parse(req.getEndTime()))
                .durationMinutes(req.getDurationMinutes())
                .createdBy(creator)
                .build();

        exam = examRepository.save(exam);

        ExamDto dto = new ExamDto();
        dto.setId(exam.getId());
        dto.setTitle(exam.getTitle());
        dto.setStartTime(exam.getStartTime().toString());
        dto.setEndTime(exam.getEndTime().toString());
        dto.setDurationMinutes(exam.getDurationMinutes());
        dto.setCreatedBy(creator.getId());

        return dto;
    }
}


