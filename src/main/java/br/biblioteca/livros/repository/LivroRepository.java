package br.biblioteca.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.biblioteca.livros.entidades.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
