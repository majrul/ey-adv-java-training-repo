package com.ey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	//@RequestMapping(path = "/api/hello", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	@GetMapping("/api/hello")
	public String sayHello() {
		return "Welcome to RESTful Spring MVC";
	}
}
