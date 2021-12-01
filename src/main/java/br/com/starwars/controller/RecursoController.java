package br.com.starwars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.starwars.model.Recurso;
import br.com.starwars.repository.RecursoRepository;


@RestController
@RequestMapping("/recursos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RecursoController {

	@Autowired
	private RecursoRepository recursoRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Recurso>> getAll() {
		return ResponseEntity.ok(recursoRepository.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Recurso> getById(@PathVariable long id) {
		return recursoRepository.findById(id).map(Resp -> ResponseEntity.ok(Resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Recurso> postRecurso(@RequestBody Recurso recurso) {
		return ResponseEntity.status(HttpStatus.CREATED).body(recursoRepository.save(recurso));

	}

	@PutMapping
	public ResponseEntity<Recurso> putRecurso(@RequestBody Recurso recurso) {
		return ResponseEntity.status(HttpStatus.OK).body(recursoRepository.save(recurso));

	}

	@DeleteMapping("/{id}")
	public void deleteRecurso(@PathVariable long id) {
		recursoRepository.deleteById(id);
	}
}
