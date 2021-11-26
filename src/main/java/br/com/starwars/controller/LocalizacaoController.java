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

import br.com.starwars.model.Localizacao;
import br.com.starwars.repository.LocalizacaoRepository;

@RestController
@RequestMapping("/localizacoes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocalizacaoController {
	
	@Autowired
	private LocalizacaoRepository localizacaoRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Localizacao>> getAll() {
		return ResponseEntity.ok(localizacaoRepository.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Localizacao> getById(@PathVariable long id) {
		return localizacaoRepository.findById(id).map(Resp -> ResponseEntity.ok(Resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Localizacao> postLocalizacao(@RequestBody Localizacao localizacao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(localizacaoRepository.save(localizacao));

	}

	@PutMapping
	public ResponseEntity<Localizacao> putLocalizacao(@RequestBody Localizacao localizacao) {
		return ResponseEntity.status(HttpStatus.OK).body(localizacaoRepository.save(localizacao));

	}

	@DeleteMapping("/{id}")
	public void deleteLocalizacao(@PathVariable long id) {
		localizacaoRepository.deleteById(id);
	}

}
