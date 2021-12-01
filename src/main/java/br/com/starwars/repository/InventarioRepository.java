package br.com.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.starwars.model.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository <Inventario, Long>{

}
