package br.com.starwars.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Inventario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Recurso> recursos;
	
	
	public Inventario() {
	}
	
	public Inventario(List<Recurso> recursos) {
		this.recursos = recursos;
	}
	
	public Inventario(Integer id, List<Recurso> recursos) {
		this.id = id;
		this.recursos = recursos;
	}

	public Inventario(Integer id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}


	
	
}
