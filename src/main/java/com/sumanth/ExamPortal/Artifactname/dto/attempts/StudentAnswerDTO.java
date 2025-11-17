package com.sumanth.ExamPortal.Artifactname.dto.attempts;

import lombok.Data;

@Data
public class StudentAnswerDTO {
    private Long questionId;
    private String answer;
}