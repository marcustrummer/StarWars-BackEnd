package br.com.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.starwars.model.Inventario;

public interface InventarioRepository extends JpaRepository <Inventario, Long>{

}
