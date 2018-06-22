package fr.epita.quiz.api;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.epita.quiz.api.request.MCQChoiceRequest;
import fr.epita.quiz.api.response.ListResponse;
import fr.epita.quiz.api.response.SuccessResponse;
import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.MCQChoiceDAO;
import fr.epita.quiz.services.QuestionDAO;

@RestController
@RequestMapping
public class MCQController {

	@Inject
	MCQChoiceDAO mcqDao;
	
	@Inject
	QuestionDAO questionDao;

	@RequestMapping(value = "mcq", method = RequestMethod.GET)
	public ListResponse<MCQChoice> listMCQChoices(
			@RequestParam("question") int questionID) {

		ListResponse<MCQChoice> response = new ListResponse<>();

		MCQChoice mcq = new MCQChoice();
		Question question = new Question();
		question.setId(questionID);
		mcq.setQuestion(question);

		List<MCQChoice> results = mcqDao.search(mcq);

		response.setSuccess(true);
		response.setResponse(results);

		return response;
	}
	
	// create
	@RequestMapping(value = "mcq", method = RequestMethod.PUT)
	public SuccessResponse createMCQChoices(@RequestBody MCQChoiceRequest request) {

		SuccessResponse response = new SuccessResponse();

		MCQChoice mcq = new MCQChoice();
		mcq.setChoice(request.getChoice());
		mcq.setOrder(request.getOrder());
		mcq.setValid(request.isValid());
		mcq.setQuestion(request.getQuestion());
		
		try {
			mcqDao.create(mcq);
			response.setSuccess(true);
		} catch(Exception e) {
			response.setSuccess(false);
		}
		
		return response;
	}

	@RequestMapping(value = "mcq", method = RequestMethod.DELETE)
	public SuccessResponse deleteMCQChoices(@RequestBody MCQChoiceRequest request) {

		SuccessResponse response = new SuccessResponse();

		MCQChoice mcq = new MCQChoice();
		mcq.setChoice(request.getChoice());
		mcq.setOrder(request.getOrder());
		mcq.setValid(request.isValid());
		mcq.setQuestion(request.getQuestion());

		try {
			mcqDao.delete(mcq);
			response.setSuccess(true);
		} catch(Exception e) {
			response.setSuccess(false);
		}
		
		return response;
	}

	@RequestMapping(value = "mcq", method = RequestMethod.POST)
	public SuccessResponse updateMCQChoices(@RequestBody MCQChoiceRequest request) {

		SuccessResponse response = new SuccessResponse();

		MCQChoice mcq = new MCQChoice();
		mcq.setChoice(request.getChoice());
		mcq.setOrder(request.getOrder());
		mcq.setValid(request.isValid());
		mcq.setQuestion(request.getQuestion());

		try {
			mcqDao.update(mcq);
			response.setSuccess(true);
		} catch(Exception e) {
			response.setSuccess(false);
		}
		
		return response;
	}

}