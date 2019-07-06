package br.biblioteca.livros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.entidades.Autor;
import br.biblioteca.livros.entidades.Livro;
import br.biblioteca.livros.services.LivroService;
import br.biblioteca.livros.services.AutorService;

@Controller
@RequestMapping("/livros")
public class LivroController {

	private static final String TEMPLATE = "/livros";

	@Autowired
	private LivroService service;
	@Autowired
	private AutorService autorService;
	

	@GetMapping("/list")
	public ModelAndView index() {
		List<Livro> livros = this.service.listaLivros();
		return new ModelAndView(TEMPLATE + "/index", "listaLivros", livros);
	}

	@GetMapping("/novo")
	public ModelAndView newBook(@ModelAttribute Livro livro) {
		ModelAndView modelAndView = new ModelAndView("livros/create");
		Iterable<Autor> autores = autorService.listaAutores();
		modelAndView.addObject("todosOsAutores",autores);
		return modelAndView;
	}
	
	@PostMapping("/gravar")
	public ModelAndView storage(Livro livro) {
		this.service.salvaLivro(livro);
		return new ModelAndView("redirect:" + TEMPLATE + "/list");
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView destroy(@PathVariable("id") Long id) {
		this.service.apagarLivro(id);
		return new ModelAndView("redirect:" + TEMPLATE + "/list");
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Livro livro = this.service.buscarLivro(id);
		List<Autor> autores = this.autorService.listaAutores();
		
		ModelAndView modelAndView = new ModelAndView("livros/form");
		
		modelAndView.addObject("autores",autores);
		modelAndView.addObject("livro",livro);
		return modelAndView;
	}
	
	
}
