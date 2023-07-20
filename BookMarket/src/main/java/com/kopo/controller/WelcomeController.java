package com.kopo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	@RequestMapping(value = "/home", method=RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("hello", "Welcome to BookPage" );
		model.addAttribute("strapline", "Welcome to Book Market" );
		return "welcome";
	}
}
