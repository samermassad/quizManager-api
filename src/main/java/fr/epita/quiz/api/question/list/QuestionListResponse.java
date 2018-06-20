package fr.epita.quiz.api.question.list;

import java.util.List;

import fr.epita.quiz.datamodel.Question;

public class QuestionListResponse {
	
	private List<Question> response;

	public List<Question> getResponse() {
		return response;
	}

	public void setResponse(List<Question> response) {
		this.response = response;
	}

}