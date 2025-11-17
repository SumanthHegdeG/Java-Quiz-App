package com.sumanth.ExamPortal.Artifactname.dto.results;
import lombok.Data;

@Data
public class ResultsDTO{
    private Long attemptId;
    private Long studentId;
    private int totalQuestions;
    private int attempted;
    private double totalMarks;
    private double obtainedMarks;
}