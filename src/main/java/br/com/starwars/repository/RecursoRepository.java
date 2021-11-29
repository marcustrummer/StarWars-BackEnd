package br.com.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.starwars.model.Recurso;

@Repository
public interface RecursoRepository extends JpaRepository <Recurso, Long>{

}
