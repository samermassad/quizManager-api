package fr.epita.quiz.api.question.list;

import fr.epita.quiz.datamodel.QuestionType;

public class QuestionListRequest {

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
	
}