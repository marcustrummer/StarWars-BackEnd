package br.com.starwars.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recurso {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome_produto;
	
	private String tipo_produto;
	
	private Integer pontos;
	
	public Recurso() {
		
	}
	
	public Recurso(Integer id, String nome_produto, String tipo_produto, Integer pontos) {
		this.id = id;
		this.nome_produto = nome_produto;
		this.tipo_produto = tipo_produto;
		this.pontos = pontos;
	}
}
