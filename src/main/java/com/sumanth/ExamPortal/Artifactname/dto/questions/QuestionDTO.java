package com.sumanth.ExamPortal.Artifactname.dto.questions;

import lombok.Data;

@Data
public class QuestionDTO {
    private Long id;
    private String text;
    private String type;
    private String choices;  // JSON
    private String correctAnswer;
    private Integer marks;
}
