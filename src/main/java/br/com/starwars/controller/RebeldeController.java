package br.com.starwars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.starwars.model.Rebelde;
import br.com.starwars.service.RebeldeService;

@RestController
@RequestMapping("/rebeldes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RebeldeController {

	@Autowired
	private RebeldeService rebeldeService;
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Rebelde>> getAll() {
		return ResponseEntity.ok(rebeldeService.listarRebeldes());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Rebelde> getById(@PathVariable long id) {
		return rebeldeService.buscarRebeldeId(id)
				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	
	@PostMapping("/cadastrar")
	public ResponseEntity<Rebelde> postRebelde(@RequestBody Rebelde rebelde) {

		return rebeldeService.cadastrarRebelde(rebelde)
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	
	@PutMapping("/atualizar")
	public ResponseEntity<Rebelde> putRebelde(@RequestBody Rebelde rebelde) {

		return rebeldeService.atualizarRebelde(rebelde)
				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	
	
	
	//Report rebelde
	@PutMapping("/report/{id}")
	public ResponseEntity<Rebelde> putStrikeRebeldeId (@PathVariable Long id){
		
		return ResponseEntity.status(HttpStatus.OK).body(rebeldeService.reportarRebelde(id));
	
	}
	

	
	
	
	/* LEMBRAR DE CRIAR REGRA DE NEGÓCIO - BLOQUEAR INVENTÁRIO DE TRAIDORES; - REBELDE PARA TRAIDOR; - 3 STRIKES


	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> loginUsuario(@RequestBody Optional<UsuarioLogin> usuarioLogin) {

		return usuarioService.loginUsuario(usuarioLogin)
				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	*/
	
	
	/*VERIFICAR COMO DELETAR REBELDE
	@DeleteMapping("/{id}")
	public void deleteRebelde(@PathVariable long id) {
		rebeldeService.deleteRebelde(id);
	}
	*/

}
