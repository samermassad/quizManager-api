package fr.epita.quiz.api;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.epita.quiz.api.request.ExamRequest;
import fr.epita.quiz.api.response.ListResponse;
import fr.epita.quiz.api.response.SuccessResponse;
import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.services.ExamDAO;

@RestController
@RequestMapping
public class ExamController {

	@Inject
	ExamDAO examDao;

	@RequestMapping(value = "exam", method = RequestMethod.GET)
	public ListResponse<Exam> listExams(
			@RequestParam("name") String name) {

		ListResponse<Exam> response = new ListResponse<>();

		Exam exam = new Exam();
		exam.setName(name);

		List<Exam> results = examDao.search(exam);

		response.setSuccess(true);
		response.setResponse(results);

		return response;
	}
	
	@RequestMapping(value = "exam", method = RequestMethod.PUT)
	public SuccessResponse createExams(@RequestBody ExamRequest request) {

		SuccessResponse response = new SuccessResponse();

		Exam exam = new Exam();
		exam.setName(request.getName());

		try {
			examDao.create(exam);
			response.setSuccess(true);
		} catch(Exception e) {
			response.setSuccess(false);
		}
		
		return response;
	}

	@RequestMapping(value = "exam", method = RequestMethod.DELETE)
	public SuccessResponse deleteExams(@RequestBody ExamRequest request) {

		SuccessResponse response = new SuccessResponse();

		Exam exam = new Exam();
		exam.setId(request.getId());
		exam.setName(request.getName());

		try {
			examDao.delete(exam);
			response.setSuccess(true);
		} catch(Exception e) {
			response.setSuccess(false);
		}
		
		return response;
	}

	@RequestMapping(value = "exam", method = RequestMethod.POST)
	public SuccessResponse updateExams(@RequestBody ExamRequest request) {

		SuccessResponse response = new SuccessResponse();

		Exam exam = new Exam();
		exam.setId(request.getId());
		exam.setName(request.getName());

		try {
			examDao.update(exam);
			response.setSuccess(true);
		} catch(Exception e) {
			response.setSuccess(false);
		}
		
		return response;
	}

}