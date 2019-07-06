package br.biblioteca.livros.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Index {

	@RequestMapping("/homer")
	public String homer() {
		return "Olá Spring Boot";
	}
	
	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}


}
