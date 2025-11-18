package com.sumanth.ExamPortal.Artifactname.service;

import com.sumanth.ExamPortal.Artifactname.dto.results.ResultsDTO;
import com.sumanth.ExamPortal.Artifactname.dto.results.StudentAttemptSummaryDTO;
import com.sumanth.ExamPortal.Artifactname.model.Attempt;
import com.sumanth.ExamPortal.Artifactname.model.StudentAnswer;
import com.sumanth.ExamPortal.Artifactname.repository.AttemptRepository;
import com.sumanth.ExamPortal.Artifactname.repository.StudentAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final AttemptRepository attemptRepository;
    private final StudentAnswerRepository studentAnswerRepository;

    public ResultsDTO getExamResult(Long attemptId) {

        Attempt attempt = attemptRepository.findById(attemptId)
                .orElseThrow(() -> new RuntimeException("Attempt not found"));

        List<StudentAnswer> answers =
                studentAnswerRepository.findByAttemptId(attemptId);

        int totalQuestions = answers.size();
        int attempted = (int) answers.stream().filter(StudentAnswer::getIsAttempted).count();
        double obtainedMarks = answers.stream().mapToDouble(StudentAnswer::getMarksAwarded).sum();
        double totalMarks = answers.stream().mapToDouble(a -> a.getQuestion().getMarks()).sum();

        ResultsDTO dto = new ResultsDTO();
        dto.setAttemptId(attemptId);
        dto.setStudentId(attempt.getStudent().getId());
        dto.setTotalQuestions(totalQuestions);
        dto.setAttempted(attempted);
        dto.setTotalMarks(totalMarks);
        dto.setObtainedMarks(obtainedMarks);

        return dto;
    }

    public List<StudentAttemptSummaryDTO> getAttemptDetails(Long attemptId) {
        return studentAnswerRepository.findByAttemptId(attemptId)
                .stream()
                .map(a -> {
                    StudentAttemptSummaryDTO dto = new StudentAttemptSummaryDTO();
                    dto.setQuestionId(a.getQuestion().getId());
                    dto.setQuestionText(a.getQuestion().getText());
                    dto.setGivenAnswer(a.getAnswer());
                    dto.setIsAttempted(a.getIsAttempted());
                    dto.setMarksAwarded(a.getMarksAwarded());
                    return dto;
                })
                .toList();
    }
}