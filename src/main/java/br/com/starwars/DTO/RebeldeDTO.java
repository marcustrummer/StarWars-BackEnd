package br.com.starwars.DTO;

import javax.validation.constraints.Size;

import br.com.starwars.model.Inventario;
import br.com.starwars.model.Rebelde;

public class RebeldeDTO {
	
	
	@Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres")
	private String nome;
	

	private Integer  idade;
	

	private String genero;

	

	private Inventario inventario;
	
	public RebeldeDTO() {
	}

	public RebeldeDTO(String nome, Integer idade, String genero, Inventario inventario) {
		this.nome = nome;
		this.idade = idade;
		this.genero = genero;
	
		this.inventario = inventario;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Rebelde tranformaParaRebelde() {
		return new Rebelde(nome, idade, genero, inventario);
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}
	
}
