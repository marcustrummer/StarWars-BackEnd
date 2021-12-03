package br.com.starwars.controller;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.starwars.DTO.RebeldeDTO;
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
	public ResponseEntity<Void> postRebelde(@Valid @RequestBody RebeldeDTO objDto) {
			Rebelde obj = rebeldeService.fromDTO(objDto);
			obj = rebeldeService.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
			
	}
}
