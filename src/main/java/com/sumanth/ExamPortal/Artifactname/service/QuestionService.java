package com.sumanth.ExamPortal.Artifactname.service;

import com.sumanth.ExamPortal.Artifactname.dto.questions.CreateQuestionRequest;
import com.sumanth.ExamPortal.Artifactname.dto.questions.QuestionDTO;
import com.sumanth.ExamPortal.Artifactname.model.Question;
import com.sumanth.ExamPortal.Artifactname.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService  {

    private final QuestionRepository questionRepository;

    public QuestionDTO createQuestion(CreateQuestionRequest req) {
        Question q = Question.builder()
                .text(req.getText())
                .type(req.getType())
                .choices(req.getChoices())
                .correctAnswer(req.getCorrectAnswer())
                .marks(req.getMarks())
                .build();

        q = questionRepository.save(q);

        QuestionDTO dto = new QuestionDTO();
        dto.setId(q.getId());
        dto.setText(q.getText());
        dto.setType(q.getType());
        dto.setChoices(q.getChoices());
        dto.setCorrectAnswer(q.getCorrectAnswer());
        dto.setMarks(q.getMarks());

        return dto;
    }
}
