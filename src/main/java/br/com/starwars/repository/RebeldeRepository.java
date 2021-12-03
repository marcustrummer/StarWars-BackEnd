package br.com.starwars.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.starwars.model.Rebelde;

@Repository
public interface RebeldeRepository extends JpaRepository<Rebelde, Integer> {

	Optional<Rebelde> findByNome(String nome);

	
}
