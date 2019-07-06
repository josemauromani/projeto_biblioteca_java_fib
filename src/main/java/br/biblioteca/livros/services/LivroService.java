package br.biblioteca.livros.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.entidades.Livro;
import br.biblioteca.livros.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository repository;
	
	public List<Livro> listaLivros(){
		return repository.findAll();
	}
	
	public void salvaLivro(Livro livro) {
		repository.save(livro);
	}
	
	public void apagarLivro(Long id) {
		Optional<Livro> livro = repository.findById(id);
		if (livro.isPresent()) {
			repository.delete(livro.get());
		}
	}
	
	public Livro buscarLivro(Long id) {
		Optional<Livro> livro = repository.findById(id);
		return livro.get();
	}
	
	
}
