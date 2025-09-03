package main;

import java.util.Scanner;

public class Question {
private String Qid;
private String Qname;
private String Option1;
private String Option2;
private String Option3;
private String Option4;
private String CorrectOption;
private String Answer;




public Question(String qid, String qname, String option1, String option2, String option3, String option4,
		String correctOption) {
	super();
	Qid = qid;
	Qname = qname;
	Option1 = option1;
	Option2 = option2;
	Option3 = option3;
	Option4 = option4;
	CorrectOption = correctOption.toUpperCase();
}





public String getQid() {
	return Qid;
}





public void setQid(String qid) {
	Qid = qid;
}





public String getQname() {
	return Qname;
}





public void setQname(String qname) {
	Qname = qname;
}





public String getOption1() {
	return Option1;
}





public void setOption1(String option1) {
	Option1 = option1;
}





public String getOption2() {
	return Option2;
}





public void setOption2(String option2) {
	Option2 = option2;
}





public String getOption3() {
	return Option3;
}





public void setOption3(String option3) {
	Option3 = option3;
}





public String getOption4() {
	return Option4;
}





public void setOption4(String option4) {
	Option4 = option4;
}





public String getCorrectOption() {
	return CorrectOption;
}





public void setCorrectOption(String correctOption) {
	CorrectOption = correctOption;
}





@Override
public String toString() {
	return "Question [Qid=" + Qid + ", Qname=" + Qname + ", Option1=" + Option1 + ", Option2=" + Option2 + ", Option3="
			+ Option3 + ", Option4=" + Option4 + ", CorrectOption=" + CorrectOption + "]";
}

public void Questiondisplay() {
    System.out.println(Qid + "." + " " + Qname);
    System.out.println();

    // ✅ Add labels before each option
    System.out.println("A. " + Option1);
    System.out.println("B. " + Option2);
    System.out.println("C. " + Option3);
    System.out.println("D. " + Option4);

    Scanner sc = new Scanner(System.in);
    String input;

    // ✅ Keep asking until a valid input is given
    while (true) {
        System.out.println("\nPlease select the Option (A/B/C/D): ");
        input = sc.nextLine().toUpperCase();

        if (input.equals("A") || input.equals("B") || input.equals("C") || input.equals("D")) {
            Answer = input; // store valid answer
            System.out.println("Your Option " + Answer + " is recorded!!");
            break;
        } else {
            System.out.println("❌ Invalid choice! Please enter only A, B, C, or D.");
        }
    }
}


public boolean answerValidator() {
	if(Answer.equalsIgnoreCase(CorrectOption)) {
		return true;
	}
	return false;
}
}
