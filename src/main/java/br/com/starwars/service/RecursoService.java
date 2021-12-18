package br.com.starwars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.starwars.model.Inventario;
import br.com.starwars.model.Recurso;
import br.com.starwars.repository.InventarioRepository;
import br.com.starwars.repository.RecursoRepository;

@Service
public class RecursoService {
	
	@Autowired
	private RecursoRepository recursoRepository;
	
	public void saveRecurso(List<Recurso> list) {
		recursoRepository.saveAll(list);
	}

}
