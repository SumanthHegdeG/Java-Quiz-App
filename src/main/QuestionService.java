package main;

public class QuestionService {

	Question q1=new Question("1", "what is java", "Language", "Game", "Toy", "Building", "A");
	
	public void display(){
		System.out.println(q1.toString());
		q1.Questiondisplay();
	}
}