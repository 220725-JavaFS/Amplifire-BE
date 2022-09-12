package com.revature.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Services.LibraryService;
import com.revature.models.LibraryUser;

@RestController
@RequestMapping(value = "register")
@CrossOrigin
public class RegisterController {

	private LibraryService libraryService;

	@Autowired
	public RegisterController(LibraryService libraryService) {
		super();
		this.libraryService = libraryService;
	}

	@PostMapping
	public ResponseEntity<String> newUser(@RequestBody LibraryUser newUser) {
		libraryService.registerUser(newUser);
		System.out.println(newUser.toString());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("New User Created");
	}

}
