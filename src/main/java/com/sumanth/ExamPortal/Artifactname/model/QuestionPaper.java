package com.sumanth.ExamPortal.Artifactname.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "question_papers")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class QuestionPaper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;
}