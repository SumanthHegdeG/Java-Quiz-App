package com.sumanth.ExamPortal.Artifactname.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "questions")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    private String type;  // MCQ or SHORT

    @Column(columnDefinition = "jsonb")
    private String choices;  // JSON array for MCQ

    private String correctAnswer;

    private Integer marks = 1;
}