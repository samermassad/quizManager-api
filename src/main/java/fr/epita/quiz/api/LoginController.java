package fr.epita.quiz.api;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.epita.quiz.api.request.LoginRequest;
import fr.epita.quiz.api.response.LoginResponse;
import fr.epita.quiz.api.response.SuccessResponse;
import fr.epita.quiz.datamodel.UserLogin;
import fr.epita.quiz.services.AuthenticationService;
import fr.epita.quiz.services.UserDAO;

@RestController
@RequestMapping
public class LoginController {

	@Inject
	AuthenticationService authService;
	
	@Inject
	UserDAO userDao;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginResponse login(@RequestBody LoginRequest request) {
		LoginResponse response = new LoginResponse();
		String username = request.getUsername();
		String password = request.getPassword();
		
		UserLogin user = new UserLogin();
		user.setUserName(username);
		user.setPassword(password);
		
		response.setResponse(authService.authenticate(user));
		return response;
	}
	
	
	@RequestMapping(value = "/createLogin", method = RequestMethod.GET)
	public SuccessResponse login(@RequestParam String username, @RequestParam String password) {
		SuccessResponse response = new SuccessResponse();
		System.out.println(username+password);
		UserLogin user = new UserLogin();
		user.setUserName(username);
		user.setPassword(password);
		
		try {
			userDao.create(user);
			response.setSuccess(true);
		} catch(Exception e) {
			response.setSuccess(false);
		}
		
		return response;
	}

}