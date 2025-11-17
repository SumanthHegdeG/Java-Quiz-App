package com.sumanth.ExamPortal.Artifactname.dto.questions;


import lombok.Data;

@Data
public class CreateQuestionRequest {
    private String text;
    private String type;
    private String choices;
    private String correctAnswer;
    private Integer marks;
}