package com.senai.PrjLivro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.PrjLivro.Entities.Livro;
import com.senai.PrjLivro.Service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {
	@Autowired
	private final LivroService livroService;

	public LivroController(LivroService livroService) {
		this.livroService = livroService;
	}
	@GetMapping("/home")
	public String paginainicial() {
		return "index";

	}


	@PostMapping
	public Livro createlivro(@RequestBody Livro livro) {
		return livroService.saveLivro(livro);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> getlivro(@PathVariable Long id) {
		Livro livro = livroService.getLivroById(id);
		if (livro != null) {
			return ResponseEntity.ok(livro);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	
	@DeleteMapping("/{id}")
	public void deletelivro(@PathVariable Long id) {
		livroService.deleteLivro(id);
	}

	@GetMapping
	public ResponseEntity<List<Livro>> getAllLivro(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Livro> livro = livroService.getAllLivro();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(livro);
	}

	@PutMapping("/{id}")
	public Livro updateLivro(@PathVariable Long id, @RequestBody Livro livro) {
		return livroService.updateLivro(id, livro);
	}
}
