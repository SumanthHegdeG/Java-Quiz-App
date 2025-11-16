package com.sumanth.ExamPortal.Artifactname.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "attempts")
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_Id")
    private User student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="exam_id")
    private Exam exam;

    @Column(name="started_at")
    private LocalDateTime startedAt;

    @Column(name="submitted_Time")
    private LocalDateTime submittedAt;

    @OneToMany(mappedBy = "attempt",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<StudentAnswer> answers;

}
