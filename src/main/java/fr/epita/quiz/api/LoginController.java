package fr.epita.quiz.api;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.epita.quiz.api.request.LoginRequest;
import fr.epita.quiz.api.response.LoginResponse;
import fr.epita.quiz.datamodel.UserLogin;
import fr.epita.quiz.services.AuthenticationService;

@RestController
@RequestMapping
public class LoginController {

	@Inject
	AuthenticationService authService;
	
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

}