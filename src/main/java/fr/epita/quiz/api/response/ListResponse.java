package fr.epita.quiz.api.response;

import java.util.List;

import fr.epita.quiz.datamodel.Question;

public class ListResponse<T> {
	
	private boolean success;
	private List<T> response;

	public List<T> getResponse() {
		return response;
	}

	public void setResponse(List<T> response) {
		this.response = response;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean status) {
		this.success = status;
	}

}