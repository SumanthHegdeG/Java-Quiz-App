package com.sumanth.ExamPortal.Artifactname.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "studentanswers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StudentAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="attempt_id")
    private Attempt attempt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    private Question question;

    @Column(columnDefinition = "TEXT")
    private String answer;

    @Column(name="is_attempted")
    private Boolean isAttempted=false;

    @Column(name="marks_awarded",precision = 10,scale = 2)
    private BigDecimal marksAwarded;
}
