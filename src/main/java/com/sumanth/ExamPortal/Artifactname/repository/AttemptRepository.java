package com.sumanth.ExamPortal.Artifactname.repository;

import com.sumanth.ExamPortal.Artifactname.model.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttemptRepository extends JpaRepository<Attempt,Long> {

    List<Attempt> findByExamId(Long examId);
    List<Attempt> findByStudentId(Long studentId);
}
