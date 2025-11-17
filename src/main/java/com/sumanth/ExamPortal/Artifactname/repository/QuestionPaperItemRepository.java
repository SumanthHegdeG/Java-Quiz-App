package com.sumanth.ExamPortal.Artifactname.repository;

import com.sumanth.ExamPortal.Artifactname.model.QuestionPaperItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionPaperItemRepository extends JpaRepository<QuestionPaperItem,Long> {

    List<QuestionPaperItem> findByPaperIdOrderByOrderingAsc(Long paperId);
}
