package main;

public class StudentResult {
    private String studentId;
    private String studentName;
    private int score;
    private double percentage;
    private String grade;

    public StudentResult(String studentId, String studentName, int score, double percentage, String grade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.score = score;
        this.percentage = percentage;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return studentName + " (" + studentId + ") -> Score: " + score +
               ", Percentage: " + percentage + "%, Grade: " + grade;
    }
}
