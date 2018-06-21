package fr.epita.quiz.api;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.epita.quiz.api.request.QuestionRequest;
import fr.epita.quiz.api.response.ListResponse;
import fr.epita.quiz.api.response.SuccessResponse;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.QuestionType;
import fr.epita.quiz.services.QuestionDAO;

@RestController
@RequestMapping
public class QuestionController {

	@Inject
	QuestionDAO questionDao;

	@RequestMapping(value = "question", method = RequestMethod.GET)
	public ListResponse<Question> listQuestions(
			@RequestParam("question") String name,
			@RequestParam("type") QuestionType questionType) {

		ListResponse<Question> response = new ListResponse<>();

		Question question = new Question();
		question.setQuestion(name);
		question.setType(questionType);

		List<Question> results = questionDao.search(question);

		response.setSuccess(true);
		response.setResponse(results);

		return response;
	}
	
	@RequestMapping(value = "question", method = RequestMethod.PUT)
	public SuccessResponse createQuestions(@RequestBody QuestionRequest request) {

		SuccessResponse response = new SuccessResponse();

		Question question = new Question();
		question.setQuestion(request.getQuestion());
		question.setType(request.getType());

		try {
			questionDao.create(question);
			response.setSuccess(true);
		} catch(Exception e) {
			response.setSuccess(false);
		}
		
		return response;
	}

	@RequestMapping(value = "question", method = RequestMethod.DELETE)
	public SuccessResponse deleteQuestions(@RequestBody QuestionRequest request) {

		SuccessResponse response = new SuccessResponse();

		Question question = new Question();
		question.setId(request.getId());
		question.setQuestion(request.getQuestion());
		question.setType(request.getType());

		try {
			questionDao.delete(question);
			response.setSuccess(true);
		} catch(Exception e) {
			response.setSuccess(false);
		}
		
		return response;
	}

	@RequestMapping(value = "question", method = RequestMethod.POST)
	public SuccessResponse updateQuestions(@RequestBody QuestionRequest request) {

		SuccessResponse response = new SuccessResponse();

		Question question = new Question();
		question.setId(request.getId());
		question.setQuestion(request.getQuestion());
		question.setType(request.getType());

		try {
			questionDao.update(question);
			response.setSuccess(true);
		} catch(Exception e) {
			response.setSuccess(false);
		}
		
		return response;
	}

}