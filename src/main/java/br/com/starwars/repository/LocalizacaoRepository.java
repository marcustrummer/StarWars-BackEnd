package br.com.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.starwars.model.Localizacao;

@Repository
public interface LocalizacaoRepository extends JpaRepository <Localizacao, Long> {

}
