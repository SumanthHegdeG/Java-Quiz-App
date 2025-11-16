package com.sumanth.ExamPortal.Artifactname.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "question_paper_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class QuestionPaperItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paper_id")
    private QuestionPaper paper;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "`ordering`")
    private Integer ordering;

}
