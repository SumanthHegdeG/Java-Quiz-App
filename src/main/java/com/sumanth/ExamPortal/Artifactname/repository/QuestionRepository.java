package com.sumanth.ExamPortal.Artifactname.repository;

import com.sumanth.ExamPortal.Artifactname.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
