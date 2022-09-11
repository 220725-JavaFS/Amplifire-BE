package com.revature.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Services.LibraryService;
import com.revature.models.User;

@RestController
@RequestMapping(value = "login")
@CrossOrigin
public class LoginController {

	private LibraryService libraryService;

	@Autowired
	public LoginController(LibraryService libraryService) {
		super();
		this.libraryService = libraryService;
	}

	@PostMapping
	public ResponseEntity<String> loginUser(@RequestParam("userName") String userName,
			@RequestParam("password") String password, HttpSession session) {
		User user = libraryService.loginUser(userName, password);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Unsuccesful");
		}
		session.setAttribute("username", user.getUserName());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Login Succesful");
	}

}
