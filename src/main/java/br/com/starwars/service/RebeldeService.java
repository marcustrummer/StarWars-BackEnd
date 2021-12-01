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
	//METODO UTLIZADO NA CONTROLLER
	public Optional<Rebelde> buscarRebeldeId(long id) {

		return rebeldeRepository.findById(id);
	}
	
	

	//METODO UTILIZADO PARA ENCONTRAR REBELDE REPORTADO
	public Rebelde buscarRebeldepeloId(Long id) {

		Rebelde rebeldeSalvo = rebeldeRepository.findById(id).orElse(null);

		if (rebeldeSalvo == null) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Postagem não encontrada!", null);
		}

		return rebeldeSalvo;
	}
	
	
	public Rebelde reportarRebelde(Long id) {

		Rebelde rebelde = buscarRebeldepeloId(id);

		rebelde.setStrikes(rebelde.getStrikes() + 1);

		return rebeldeRepository.save(rebelde);

	}
	
	

	public Optional<Rebelde> cadastrarRebelde(Rebelde rebelde) {

		if (rebeldeRepository.findByNome(rebelde.getNome()).isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse nome já exite!,null");

		return Optional.of(rebeldeRepository.save(rebelde));
	}

	
	public Optional<Rebelde> atualizarRebelde(Rebelde rebelde) {
		if (rebeldeRepository.findById(rebelde.getId()).isPresent()) {

			Optional<Rebelde> buscaUsuario = rebeldeRepository.findByNome(rebelde.getNome());

			if (buscaUsuario.isPresent()) {

				if (buscaUsuario.get().getId() != rebelde.getId())
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
			}
			return Optional.of(rebeldeRepository.save(rebelde));
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);
		}
	}

	/*
	 * VERIFICAR COMO DELETAR REBELDE
	 * 
	 * public Optional<Rebelde> deleteRebelde(Rebelde rebelde) {
	 * 
	 * return Optional.of(rebeldeRepository.delete(rebelde)); }
	 */

}
