package br.com.starwars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.starwars.model.Inventario;
import br.com.starwars.repository.InventarioRepository;

@Service
public class InventarioService {

	@Autowired
	private InventarioRepository inventRepo;
	
	@Autowired
	private RecursoService recursoService;
	
	public void saveInventario(Inventario inventario) {
		
		
		inventRepo.save(inventario);
		//recursoService.saveRecurso(inventario.getRecursos());
		
	}
	
}
