package br.com.starwars.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.com.starwars.DTO.RebeldeDTO;
import br.com.starwars.DTO.RebeldeNewDTO;
import br.com.starwars.model.Inventario;
import br.com.starwars.model.Rebelde;
import br.com.starwars.model.Recurso;
import br.com.starwars.repository.InventarioRepository;
import br.com.starwars.repository.RebeldeRepository;
import br.com.starwars.repository.RecursoRepository;

@Service
public class RebeldeService {

	@Autowired
	private RebeldeRepository rebeldeRepository;
	
	@Autowired
	private RecursoRepository recursoRepository;
	
	@Autowired
	private InventarioRepository inventarioRepository;
	
	@Autowired
	private InventarioService salvarInventario;
	
	public List<Rebelde> findAll(){
		return rebeldeRepository.findAll();
	}
	
	@Transactional
	public Rebelde insert(Rebelde obj) {
		obj.setId(null);
		obj = rebeldeRepository.save(obj);
		recursoRepository.saveAll(obj.getInventario().getRecursos());
		salvarInventario.saveInventario(obj.getInventario());
		
		
		
		return obj;
		
	}
	
	
	
	
	public Optional<Rebelde> cadastrarRebelde(Rebelde rebelde) {

		if (rebeldeRepository.findByNome(rebelde.getNome()).isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse nome já exite!,null");

		return Optional.of(rebeldeRepository.save(rebelde));
	}
	
	/*
	public Rebelde fromDTO(RebeldeDTO objDTO) {
		return new Rebelde(objDTO.getId(), objDTO.getNome(), objDTO.getIdade(), objDTO.getGenero());
	} */
	
        public Rebelde fromDTO(RebeldeDTO objDTO) {
		Rebelde rebelde = new Rebelde(objDTO.getId(), objDTO.getNome(), objDTO.getIdade(), objDTO.getGenero());
		Recurso recurso = new Recurso(null,"Agua","Bebida",2);
		Inventario inventario = new Inventario(null, "ooo");
		
		inventario.getRecursos().add(recurso);
		rebelde.setInventario(inventario);
		
		return rebelde;
		
	} 
	
}
