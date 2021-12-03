package br.com.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.starwars.model.Recurso;

public interface RecursoRepository extends JpaRepository<Recurso, Integer>{

}
