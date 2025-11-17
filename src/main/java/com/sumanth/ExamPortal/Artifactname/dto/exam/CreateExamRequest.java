package com.sumanth.ExamPortal.Artifactname.dto.exam;

import lombok.Data;

@Data
public class CreateExamRequest {
    private String title;
    private String startTime;
    private String endTime;
    private Integer durationMinutes;
}