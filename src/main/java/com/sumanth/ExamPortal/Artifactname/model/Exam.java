package com.sumanth.ExamPortal.Artifactname.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exams")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Instant startTime;
    private Instant endTime;

    private Integer durationMinutes;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;  // Invigilator or Teacher
}
