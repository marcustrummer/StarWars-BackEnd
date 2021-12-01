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

import br.com.starwars.model.Inventario;
import br.com.starwars.repository.InventarioRepository;

@RestController
@RequestMapping("/inventarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InventarioController {

	@Autowired
	private InventarioRepository inventarioRepository;

	
//---------CONFERIR NECESSIDADE DE TER /ALL E /ID
	
	@GetMapping("/all")
	public ResponseEntity<List<Inventario>> getAll() {
		return ResponseEntity.ok(inventarioRepository.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Inventario> getById(@PathVariable long id) {
		return inventarioRepository.findById(id).map(Resp -> ResponseEntity.ok(Resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Inventario> postInventario(@RequestBody Inventario inventario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(inventarioRepository.save(inventario));

	}

	@PutMapping
	public ResponseEntity<Inventario> putInventario(@RequestBody Inventario inventario) {
		return ResponseEntity.status(HttpStatus.OK).body(inventarioRepository.save(inventario));

	}

	@DeleteMapping("/{id}")
	public void deleteInventario(@PathVariable long id) {
		inventarioRepository.deleteById(id);
	}
}
