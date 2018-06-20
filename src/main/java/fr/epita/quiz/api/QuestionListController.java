package fr.epita.quiz.api;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.epita.quiz.api.question.list.QuestionListRequest;
import fr.epita.quiz.api.question.list.QuestionListResponse;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.QuestionDAO;

@RestController
@RequestMapping
public class QuestionListController {

	@Inject
	QuestionDAO questionDao;
	
	@RequestMapping(value = "/questionList", method = RequestMethod.POST)
	public QuestionListResponse login(@RequestBody QuestionListRequest request) {
		QuestionListResponse response = new QuestionListResponse();
		
		Question question = new Question();
		question.setQuestion(request.getQuestion());
		question.setType(request.getType());
		
		List<Question> results = questionDao.search(question);
		
		Question question2 = new Question();
		question2.setQuestion(request.getQuestion());
		question2.setType(request.getType());
		Question question3 = new Question();
		question3.setQuestion(request.getQuestion());
		question3.setType(request.getType());
		
		results.add(question2);
		results.add(question3);
		
		response.setResponse(results);
		
		return response;
	}

}