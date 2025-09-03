package main;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private QuestionService questionService = new QuestionService();
    private Mentor mentor = new Mentor(questionService);

    public void start() {
        while (true) {
            System.out.println("\n====== MAIN MENU ======");
            System.out.println("1. Mentor");
            System.out.println("2. Student");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    mentorMenu();
                    break;
                case "2":
                    studentMenu();
                    break;
                case "3":
                    System.out.println("✅ Exiting... Goodbye!");
                    return; // exit program
                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }

    // ✅ Mentor features
    private void mentorMenu() {
        while (true) {
            System.out.println("\n====== MENTOR MENU ======");
            System.out.println("1. Add Questions");
            System.out.println("2. Display Total Questions");
            System.out.println("3. Display All Questions with Answers");
            System.out.println("4. Display All Student Results");
            System.out.println("5. Load Preloaded 10 Questions ✅, for lazy Mentor");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    mentor.addQuestions();
                    break;
                case "2":
                    mentor.displayTotalQuestions();
                    break;
                case "3":
                    mentor.displayAllQuestionsWithAnswers();
                    break;
                case "4":
                    mentor.displayAllStudentResults();
                    break;
                case "5":
                    questionService.preloadQuestions(); // 🔥 load preloaded questions
                    System.out.println("✅ 10 Preloaded Questions Added!");
                    break;
                case "6":
                    return; // go back to main menu
                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }

    // ✅ Student features
    private void studentMenu() {
        while (true) {
            System.out.println("\n====== STUDENT MENU ======");
            System.out.println("1. Display Questions (without answers)");
            System.out.println("2. Start Quiz");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    createStudent().displayQuestions();
                    break;
                case "2":
                    Student student = createStudent();
                    StudentResult result = student.startQuiz();
                    mentor.recordStudentResult(result);
                    break;
                case "3":
                    return; // back to main menu
                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }

    // ✅ Helper method to create a new student
    private Student createStudent() {
        System.out.print("\nEnter Student ID: ");
        String sid = sc.nextLine();
        System.out.print("Enter Student Name: ");
        String sname = sc.nextLine();
        return new Student(sid, sname, questionService);
    }
}
