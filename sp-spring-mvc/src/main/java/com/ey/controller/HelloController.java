package com.ey.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String sayHello(Map model) {
		model.put("message", "Welcome to Spring MVC");
		return "hello.jsp"; //view
	}

	@RequestMapping("/hello2")
	public String sayHello2(Model model) {
		model.addAttribute("message", "Welcome to Spring MVC v2");
		return "hello.jsp"; //view
	}

	@RequestMapping("/hello3")
	public String sayHello3(ModelMap model) {
		model.addAttribute("message", "Welcome to Spring MVC v3");
		return "hello.jsp"; //view
	}
	
	@RequestMapping("/hello4")
	public ModelAndView sayHello4() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Welcome to Spring MVC v4");
		mav.setViewName("hello.jsp");
		return mav;
	}

}
