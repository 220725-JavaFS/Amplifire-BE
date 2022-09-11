package com.revature.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hello")
@CrossOrigin
public class HelloController {

	@GetMapping("/")
	public String home() {
		return "Hello Docker World!!";
	}

}
