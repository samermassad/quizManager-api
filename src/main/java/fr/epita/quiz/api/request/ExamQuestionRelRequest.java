package fr.epita.quiz.api.request;

import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.Question;

public class ExamQuestionRelRequest {

	private int id;
	private Exam exam;
	private Question question;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
	
}