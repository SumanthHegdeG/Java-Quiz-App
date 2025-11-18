package com.sumanth.ExamPortal.Artifactname.service;


import com.sumanth.ExamPortal.Artifactname.dto.attempts.StudentAnswerDTO;
import com.sumanth.ExamPortal.Artifactname.dto.attempts.SubmitAttemptDTO;
import com.sumanth.ExamPortal.Artifactname.model.*;
import com.sumanth.ExamPortal.Artifactname.repository.AttemptRepository;
import com.sumanth.ExamPortal.Artifactname.repository.ExamRepository;
import com.sumanth.ExamPortal.Artifactname.repository.QuestionRepository;
import com.sumanth.ExamPortal.Artifactname.repository.StudentAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AttemptService {


    private final AttemptRepository attemptRepository;
    private final StudentAnswerRepository studentAnswerRepository;
    private final QuestionRepository questionRepository;
    private final ExamRepository examRepository;

    public Attempt startAttempt(User student, Long examId) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new RuntimeException("Exam not found"));


        Attempt attempt = Attempt.builder()
                .exam(exam)
                .student(student)
                .startedAt(Instant.now())
                .build();

        return attemptRepository.save(attempt);
    }


    public Attempt submitAttempt(User student, SubmitAttemptDTO dto) {
        Attempt attempt = attemptRepository.findByStudentId(student.getId())
                .stream()
                .filter(a -> a.getExam().getId().equals(dto.getExamId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Attempt not found"));

        for (StudentAnswerDTO ansDto : dto.getAnswers()) {

            Question q = questionRepository.findById(ansDto.getQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));

            boolean attempted = ansDto.getAnswer() != null && !ansDto.getAnswer().isEmpty();

            double marks = 0;
            if (attempted && q.getCorrectAnswer() != null) {
                if (q.getCorrectAnswer().equals(ansDto.getAnswer())) {
                    marks = q.getMarks();
                }
            }

            StudentAnswer answer = StudentAnswer.builder()
                    .attempt(attempt)
                    .question(q)
                    .answer(ansDto.getAnswer())
                    .isAttempted(attempted)
                    .marksAwarded(marks)
                    .build();

            studentAnswerRepository.save(answer);
        }

        attempt.setSubmittedAt(Instant.now());
        return attemptRepository.save(attempt);
    }
}



