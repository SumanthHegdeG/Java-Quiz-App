package com.sumanth.ExamPortal.Artifactname.dto.attempts;

import lombok.Data;
import java.util.List;

@Data
public class SubmitAttemptDTO {
    private Long examId;
    private List<StudentAnswerDTO> answers;
}