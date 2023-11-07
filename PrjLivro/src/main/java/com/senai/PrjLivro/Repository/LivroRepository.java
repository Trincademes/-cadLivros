package com.senai.PrjLivro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.PrjLivro.Entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
}
