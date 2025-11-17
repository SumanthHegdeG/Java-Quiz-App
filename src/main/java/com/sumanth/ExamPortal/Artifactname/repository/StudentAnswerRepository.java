package com.sumanth.ExamPortal.Artifactname.repository;

import com.sumanth.ExamPortal.Artifactname.model.StudentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentAnswerRepository extends JpaRepository<StudentAnswer,Long> {

    List<StudentAnswer> findByAttemptId(Long attemptId);
}
