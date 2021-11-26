package br.com.starwars.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_inventario")
public class Inventario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "O atributo quantidade eh obrigatorio")
	@Size(min = 1, max = 8, message = "Voce so pode conter no maximo 8 itens ")
	private int qtd;
	
	
	/*         RELACIONAMENTO COM RECURSO
	@NotNull(message = "O atributo nome do produto eh obrigatorio")
	@Size(min = 3, max = 15, message = "O atributo nome do produto deve min=3 max=15 caracteres")
	private String nomeProduto;
	
	@NotNull(message = "O atributo tipo do produto eh obrigatorio")
	@Size(min = 3, max = 15, message = "O atributo tipo do produto deve min=3 max=15 caracteres")
	private String tipoProduto;
	
	@NotNull(message = "O atributo pontuacao eh obrigatorio")
	private double pontuacao;*/
	


	
	
	//RELACIONAMENTOS---------------------------------------------------------------------------------
	
	@ManyToOne
	@JsonIgnoreProperties("inventario")
	private Recurso recurso;
	
	@OneToOne
	@JsonIgnoreProperties("inventario")
	private Rebelde rebelde;
	
	//FIM DOS RELACIONAMENTOS--------------------------------------------------------------------------

	
	
	
	
	
	//Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public Rebelde getRebelde() {
		return rebelde;
	}

	public void setRebelde(Rebelde rebelde) {
		this.rebelde = rebelde;
	}
	
	

	
	
	
	/*
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
	
	public double getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(double pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	*/

}
