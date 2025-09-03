package main;

import java.util.Scanner;

public class Student {
    private String studentId;
    private String studentName;

    private QuestionService questionService;

    public Student(String studentId, String studentName, QuestionService questionService) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.questionService = questionService;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    // ✅ Display all questions without showing correct answers
    public void displayQuestions() {
        System.out.println("\n📘 Questions for " + studentName + " (" + studentId + "):");
        for (Question q : questionService.getQuestions()) {
            System.out.println(q.getQid() + ". " + q.getQname());
            System.out.println("A. " + q.getOption1());
            System.out.println("B. " + q.getOption2());
            System.out.println("C. " + q.getOption3());
            System.out.println("D. " + q.getOption4());
            System.out.println("----------------------------------");
        }
    }

    // ✅ Start quiz and return result object
    public StudentResult startQuiz() {
        System.out.println("\n🎯 " + studentName + " (" + studentId + ") starting quiz...");
        int score = 0;

        for (Question q : questionService.getQuestions()) {
            q.Questiondisplay(); // student attempts question
            if (q.answerValidator()) {
                score++;
            }
        }

        double percentage = (score * 100.0) / questionService.getQuestions().size();
        String grade;
        if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 60) {
            grade = "B";
        } else if (percentage >= 40) {
            grade = "C";
        } else {
            grade = "Fail";
        }

        System.out.println("\n✅ Quiz Completed for " + studentName);
        System.out.println("Score: " + score + "/" + questionService.getQuestions().size());
        System.out.println("Grade: " + grade);

        // return result so Mentor can store it
        return new StudentResult(studentId, studentName, score, percentage, grade);
    }
}
