package br.com.starwars.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.starwars.model.Rebelde;

@Repository
public interface RebeldeRepository extends JpaRepository<Rebelde, Long> {

	public Optional<Rebelde> findByNome(String nome);

	public List<Rebelde> findAllByNomeContainingIgnoreCase(String nome);

	//public Optional<Rebelde> deleteRebelde(long id);

}
