package br.com.starwars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.starwars.model.Recurso;
import br.com.starwars.repository.InventarioRepository;
import br.com.starwars.repository.RecursoRepository;

@SpringBootApplication
public class StarsWarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarsWarsApplication.class, args);
	}
	
	@Autowired
	private InventarioRepository inventarioRepository;
	
	@Autowired
	private RecursoRepository recursoRepository;
	
	
	//METODO CRIADO PARA PREENCHIEMNTO DO BANCO COM RECURSOS PADROES
	public void run(String... args) throws Exception {
		
		Recurso re1 = new Recurso(1, "Sabre de luz", "Arma");
		Recurso re2 = new Recurso(2, "Granada propulsora", "Arma");
		Recurso re3 = new Recurso(3, "Blaster", "Arma");
		//SALVANDO RECURSOS DE GUERRA
		recursoRepository.save(re1);recursoRepository.save(re2);recursoRepository.save(re3);
		
		Recurso re4 = new Recurso(4, "Wrap de peru", "Mantimentos");
		Recurso re5 = new Recurso(5, "Wookie cookies", "Mantimentos");
		Recurso re6 = new Recurso(6, "Yoda Soda", "Mantimentos");
		//SALVANDO RECURSOS DE MANTIMENTO
		recursoRepository.save(re4);recursoRepository.save(re5);recursoRepository.save(re6);
		
		
		
		
		
		
		
		
	}

}
