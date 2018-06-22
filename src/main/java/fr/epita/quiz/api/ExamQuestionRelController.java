package fr.epita.quiz.api;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.epita.quiz.api.request.ExamQuestionRelRequest;
import fr.epita.quiz.api.response.ListResponse;
import fr.epita.quiz.api.response.SuccessResponse;
import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.ExamQuestionRel;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.ExamQuestionRelDAO;

@RestController
@RequestMapping
public class ExamQuestionRelController {

	@Inject
	ExamQuestionRelDAO examQuestionRelDao;

	@RequestMapping(value = "examQuestionRel", method = RequestMethod.GET)
	public ListResponse<ExamQuestionRel> listExamQuestionRels(@RequestParam("question") Question question,
			@RequestParam("exam") Exam exam) {

		ListResponse<ExamQuestionRel> response = new ListResponse<>();

		ExamQuestionRel examQuestionRel = new ExamQuestionRel();
		examQuestionRel.setQuestion(question);
		examQuestionRel.setExam(exam);

		List<ExamQuestionRel> results = examQuestionRelDao.search(examQuestionRel);

		response.setSuccess(true);
		response.setResponse(results);

		return response;
	}

	@RequestMapping(value = "examQuestionRel", method = RequestMethod.PUT)
	public SuccessResponse createExamQuestionRels(@RequestBody ExamQuestionRelRequest request) {

		SuccessResponse response = new SuccessResponse();

		ExamQuestionRel examQuestionRel = new ExamQuestionRel();
		examQuestionRel.setQuestion(request.getQuestion());
		examQuestionRel.setExam(request.getExam());

		try {
			examQuestionRelDao.create(examQuestionRel);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
		}

		return response;
	}

	@RequestMapping(value = "examQuestionRel", method = RequestMethod.DELETE)
	public SuccessResponse deleteExamQuestionRels(@RequestBody ExamQuestionRelRequest request) {

		SuccessResponse response = new SuccessResponse();

		ExamQuestionRel examQuestionRel = new ExamQuestionRel();
		examQuestionRel.setId(request.getId());
		examQuestionRel.setQuestion(request.getQuestion());
		examQuestionRel.setExam(request.getExam());

		try {
			examQuestionRelDao.delete(examQuestionRel);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
		}

		return response;
	}

	@RequestMapping(value = "examQuestionRel", method = RequestMethod.POST)
	public SuccessResponse updateExamQuestionRels(@RequestBody ExamQuestionRelRequest request) {

		SuccessResponse response = new SuccessResponse();

		ExamQuestionRel examQuestionRel = new ExamQuestionRel();
		examQuestionRel.setId(request.getId());
		examQuestionRel.setQuestion(request.getQuestion());
		examQuestionRel.setExam(request.getExam());

		try {
			examQuestionRelDao.update(examQuestionRel);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
		}

		return response;
	}

}