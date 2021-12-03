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
	
	public List<Rebelde> findAll(){
		return rebeldeRepository.findAll();
	}
	
	
	public Optional<Rebelde> cadastrarRebelde(Rebelde rebelde) {

		if (rebeldeRepository.findByNome(rebelde.getNome()).isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse nome já exite!,null");

		return Optional.of(rebeldeRepository.save(rebelde));
	}
	
}
