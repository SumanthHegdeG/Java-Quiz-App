package com.sumanth.ExamPortal.Artifactname.dto.results;

import lombok.Data;

@Data
public class StudentAttemptSummaryDTO {
    private Long questionId;
    private String questionText;
    private String givenAnswer;
    private Boolean isAttempted;
    private Double marksAwarded;
}