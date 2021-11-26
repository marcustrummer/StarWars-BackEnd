package br.com.starwars.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.starwars.model.Rebelde;
import br.com.starwars.repository.RebeldeRepository;

@Service
public class RebeldeService {
	
	@Autowired
	private RebeldeRepository rebeldeRepository;
	
	public List<Rebelde> listarRebeldes() {

		return rebeldeRepository.findAll();
	}
	
	
	public Optional<Rebelde> buscarRebeldeId(long id) {

		return rebeldeRepository.findById(id);
	}
	
	
	public Optional<Rebelde> cadastrarRebelde(Rebelde rebelde) {

		if (rebeldeRepository.findByNome(rebelde.getNome()).isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse nome já exite!,null");


		return Optional.of(rebeldeRepository.save(rebelde));
	}
	
	
	
	public Optional<Rebelde> atualizarRebelde(Rebelde rebelde) {

		for (Rebelde rebel : this.listarRebeldes()) {
			if (rebel.getNome().equals(rebel.getNome())) {
				throw new ResponseStatusException(HttpStatus.CONFLICT, "Ja existe um rebelde com esse nome", null);
			}
		}

		if (rebeldeRepository.findByNome(rebelde.getNome()).isPresent()) {

			return Optional.of(rebeldeRepository.save(rebelde));
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rebelde não encontrado!", null);
		}
	}
	
	
/*VERIFICAR COMO DELETAR REBELDE
	
	public Optional<Rebelde> deleteRebelde(Rebelde rebelde) {

			return Optional.of(rebeldeRepository.delete(rebelde));
		}
		*/

	
}
