package fr.epita.quiz.api.request;

import fr.epita.quiz.datamodel.QuestionType;

public class QuestionRequest {

	private int id;
	private String question;
	private QuestionType type;
	
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public QuestionType getType() {
		return type;
	}
	public void setType(QuestionType type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}