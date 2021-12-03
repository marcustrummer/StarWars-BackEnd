package br.com.starwars.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.starwars.model.Rebelde;
import br.com.starwars.service.RebeldeService;

@CrossOrigin
@RestController
@RequestMapping(value="/rebeldes")
public class RebeldeController {
	
	@Autowired
	RebeldeService rebeldeService;
	
	@GetMapping("/all")
	public List<Rebelde> listaRebeldes(){        // caso seja um traidor, não listar
		return rebeldeService.findAll();
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Rebelde> postRebelde(@RequestBody Rebelde rebelde) {

		return rebeldeService.cadastrarRebelde(rebelde)
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
}
