package com.sumanth.ExamPortal.Artifactname.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "student_answers")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class StudentAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Attempt attempt;

    @ManyToOne
    private Question question;

    private String answer;

    private Boolean isAttempted;

    private Double marksAwarded;
}