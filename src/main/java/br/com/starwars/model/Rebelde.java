package br.com.starwars.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_rebelde")
public class Rebelde {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "O atributo nome deve conter pelo menos 5 caracteres")
	@Size(min = 3, max = 30, message = "O atributo nome deve conter entre 5 e 15 caracteres")
	private String nome;

	@NotNull(message = "O atributo idade eh obrigatorio")
	private int idade;
	
	
	@NotNull(message = "O atributo genero deve ser M F ou O (Masculino/Feminino/Outro)")
	@Size(min = 1, max = 1, message = "O atributo genero deve conter apenas 1 caracter")
	private String genero;

	@Column(columnDefinition = "integer default 0")
	private int strikes;

	
	
	
	
	
	// RELACIONAMENTOS----------------------------------------------------
	
	@OneToOne
	@JsonIgnoreProperties("rebelde")
	private Inventario inventario;

	
	@OneToOne
	@JsonIgnoreProperties("rebelde")
	private Localizacao localizacao;

	// FIM DOS RELACIONAMENTOS--------------------------------------------

	
	
	
	
	
	
	
	// GETTERS AND SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getStrikes() {
		return strikes;
	}

	public void setStrikes(int strikes) {
		this.strikes = strikes;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}
	
	
	

}
