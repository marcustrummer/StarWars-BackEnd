package br.com.starwars.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Inventario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_Recurso")
	private List<Recurso> recursos = new ArrayList<Recurso>();
	
	public Inventario() {
	}
	
	public Inventario(List<Recurso> recursos) {
		this.recursos = recursos;
	}
	
	public Inventario(Integer id, List<Recurso> recursos) {
		this.id = id;
		this.recursos = recursos;
	}

	public Inventario(Integer id, String nome) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}
	
	public void adiciona(Recurso recursos) {
		this.recursos.add(recursos);
	}


	
	
}
