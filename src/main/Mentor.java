package main;

import java.util.ArrayList;
import java.util.List;

public class Mentor {
    private QuestionService questionService;
    private List<StudentResult> studentResults = new ArrayList<>();

    public Mentor(QuestionService questionService) {
        this.questionService = questionService;
    }

    public void displayTotalQuestions() {
        System.out.println("📘 Total Questions Added: " + questionService.getQuestions().size());
    }

    public void addQuestions() {
        questionService.addQuestionsFromUser();
    }

    public void recordStudentResult(StudentResult result) {
        studentResults.add(result);
    }

    public void displayAllStudentResults() {
        System.out.println("\n📊 Student Results:");
        for (StudentResult result : studentResults) {
            System.out.println(result);
        }
    }

    public void displayAllQuestionsWithAnswers() {
        System.out.println("\n📖 All Questions with Correct Answers:");
        for (Question q : questionService.getQuestions()) {
            System.out.println(q.getQid() + ". " + q.getQname());
            System.out.println("A. " + q.getOption1());
            System.out.println("B. " + q.getOption2());
            System.out.println("C. " + q.getOption3());
            System.out.println("D. " + q.getOption4());
            System.out.println("✅ Correct Answer: " + q.getCorrectOption());
            System.out.println("----------------------------------");
        }
    }
}
