package com.senai.PrjLivro.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.PrjLivro.Entities.Livro;
import com.senai.PrjLivro.Repository.LivroRepository;

@Service
public class LivroService {
	private final LivroRepository livroRepository;

	@Autowired
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
	}

	public List<Livro> getAllLivro() {
		return livroRepository.findAll();
	}

	public Livro getLivroById(Long id) {
		return livroRepository.findById(id).orElse(null);

	}

	public void deleteLivro(long id) {
		livroRepository.deleteById(id);

	}

	public Livro updateLivro(Long id, Livro novoLivro) {
		Optional<Livro> livroOptional = livroRepository.findById(id);
		if (livroOptional.isPresent()) {
			Livro livroExistente = livroOptional.get();
			livroExistente.setDescricao(novoLivro.getDescricao());
			livroExistente.setIsbn(novoLivro.getIsbn());
			return livroRepository.save(livroExistente);
		} else {
			return null;
		}
	}

}
