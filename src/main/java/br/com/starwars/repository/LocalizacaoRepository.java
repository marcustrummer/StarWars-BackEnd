package br.com.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.starwars.model.Localizacao;

public interface LocalizacaoRepository extends JpaRepository <Localizacao, Long> {

}
