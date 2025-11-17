package com.sumanth.ExamPortal.Artifactname.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "attempts")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User student;

    @ManyToOne
    private Exam exam;

    private Instant startedAt;
    private Instant submittedAt;
}