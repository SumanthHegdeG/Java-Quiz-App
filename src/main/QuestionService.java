package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionService {
    private List<Question> questions = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private int questionCounter = 1; // ✅ counter for auto-generated IDs

    // ✅ Method to let user add questions
    public void addQuestionsFromUser() {
        System.out.print("How many questions do you want to add? ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Enter details for Question " + i + " ---");

            // Auto-generate ID like Q1, Q2, Q3...
            String qid = "Q" + questionCounter++;

            System.out.print("Enter Question: ");
            String qname = sc.nextLine();

            System.out.print("Enter Option A: ");
            String option1 = sc.nextLine();

            System.out.print("Enter Option B: ");
            String option2 = sc.nextLine();

            System.out.print("Enter Option C: ");
            String option3 = sc.nextLine();

            System.out.print("Enter Option D: ");
            String option4 = sc.nextLine();

            String correctOption;
            while (true) {
                System.out.print("Enter Correct Option (A/B/C/D): ");
                correctOption = sc.nextLine().trim().toUpperCase();
                if (correctOption.matches("[ABCD]")) break;
                System.out.println("❌ Invalid input. Please enter only A, B, C, or D.");
            }

            // ✅ Create question object and add it
            Question q = new Question(qid, qname, option1, option2, option3, option4, correctOption);
            questions.add(q);
        }
    }

    // ✅ Start Quiz
    public void startQuiz() {
        if (questions.isEmpty()) {
            System.out.println("❌ No questions available. Please add questions first.");
            return;
        }

        int score = 0;

        for (Question q : questions) {
            q.Questiondisplay(); // handles input with validation

            if (q.answerValidator()) {
                score++;
                System.out.println("✅ Correct!");
            } else {
                System.out.println("❌ Wrong! Correct answer was: " + q.getCorrectOption());
            }
        }

        // ✅ Final Score
        System.out.println("\n✅ Quiz Completed!");
        System.out.println("You scored: " + score + " out of " + questions.size());
        double percentage = (score * 100.0) / questions.size();
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 80) {
            System.out.println("Grade: A");
        } else if (percentage >= 60) {
            System.out.println("Grade: B");
        } else if (percentage >= 40) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: Fail");
        }
    }

	public List<Question> getQuestions() {
		// TODO Auto-generated method stub
		return questions;
	}
	public void preloadQuestions() {
	    questions.add(new Question("Q" + questionCounter++, "What is the capital of India?",
	            "Delhi", "Mumbai", "Chennai", "Kolkata", "A"));

	    questions.add(new Question("Q" + questionCounter++, "Which company developed Java?",
	            "Microsoft", "Oracle", "Sun Microsystems", "IBM", "C"));

	    questions.add(new Question("Q" + questionCounter++, "Which data type is used to store decimal numbers in Java?",
	            "int", "double", "char", "boolean", "B"));

	    questions.add(new Question("Q" + questionCounter++, "Which of these is not an OOP principle?",
	            "Encapsulation", "Polymorphism", "Abstraction", "Compilation", "D"));

	    questions.add(new Question("Q" + questionCounter++, "Who is known as the father of computers?",
	            "Alan Turing", "Charles Babbage", "Dennis Ritchie", "James Gosling", "B"));

	    questions.add(new Question("Q" + questionCounter++, "Which symbol is used for single-line comments in Java?",
	            "//", "/* */", "#", "<!-- -->", "A"));

	    questions.add(new Question("Q" + questionCounter++, "Which of these is not a Java keyword?",
	            "class", "static", "main", "return", "C"));

	    questions.add(new Question("Q" + questionCounter++, "Which collection class allows key-value pairs in Java?",
	            "List", "Set", "Map", "Queue", "C"));

	    questions.add(new Question("Q" + questionCounter++, "What is 2 + 2 * 2 in Java?",
	            "6", "8", "4", "10", "A"));

	    questions.add(new Question("Q" + questionCounter++, "Which layer of OSI model deals with IP addressing?",
	            "Transport", "Application", "Network", "Session", "C"));
	}

}
