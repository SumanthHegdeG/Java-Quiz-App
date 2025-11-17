package com.sumanth.ExamPortal.Artifactname.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "question_paper_items")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class QuestionPaperItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paper_id")
    private QuestionPaper paper;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    private Integer ordering;
}
