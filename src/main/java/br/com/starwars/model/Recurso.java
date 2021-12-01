package br.com.starwars.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Embeddable
public class Recurso {   // Recurso sao os itens que podem ser alocados no inventario ex : armas, alimentos, etc

	
	@NotNull(message = "O atributo nomeProduto do produto eh obrigatorio")
	@Size(min = 3, max = 15, message = "O atributo nome do produto deve min=3 max=15 caracteres")
	private String nomeProduto;

	@NotNull(message = "O atributo tipo do produto eh obrigatorio")
	@Size(min = 3, max = 15, message = "O atributo nome do produto deve min=3 max=15 caracteres")
	private String tipoProduto;

	
	
	public Recurso() {
	}

	public Recurso(Integer id, String nomeProduto, String tipoProduto) {
		super();
		//this.id = id;
		this.nomeProduto = nomeProduto;
		this.tipoProduto = tipoProduto;
	}

	
	
	
	
	/*
	// RELACIONAMENTOS---------------------------------------------------------------------------------

	@OneToMany(mappedBy = "recurso", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("recurso")
	private List<Inventario> inventario;

	// FIM DOS  RELACIONAMENTOS--------------------------------------------------------------------------

	*/
	
	
	
	
	
	// GETTERS AND SETTERS--------------------------------------
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	/*
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public List<Inventario> getInventario() {
		return inventario;
	}

	public void setInventario(List<Inventario> inventario) {
		this.inventario = inventario;
	}*/
	
	
	
	

}
