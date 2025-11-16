package com.sumanth.ExamPortal.Artifactname.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="question_paper")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class QuestionPaper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Exam_id")
    private Exam exam;

    @OneToMany(mappedBy = "paper",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<QuestionPaperItem> items = new ArrayList<>();
}
