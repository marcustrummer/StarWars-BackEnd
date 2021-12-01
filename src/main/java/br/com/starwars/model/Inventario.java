package br.com.starwars.model;


import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Inventario {
	
	
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	*/
	
	
	@NotNull(message = "O atributo tipoInventario do produto é obrigatório")
	@Size(min = 3, message = "O atributo nome do produto deve min=3 caracteres")
	private String tipoInventario;
	
	@Embedded
	private Recurso recurso;
	
	
	

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public Inventario() {
	}

	public Inventario(Integer id, String tipoInventario, Rebelde rebelde, Recurso recurso) {
		super();
		//this.id = id;
		this.tipoInventario = tipoInventario;
	//  this.rebelde = rebelde;
	//	this.recurso = recurso;
	}
	
	
	
	
	/*         RELACIONAMENTO COM RECURSO
	@NotNull(message = "O atributo nome do produto eh obrigatorio")
	@Size(min = 3, max = 15, message = "O atributo nome do produto deve min=3 max=15 caracteres")
	private String nomeProduto;
	
	@NotNull(message = "O atributo tipo do produto eh obrigatorio")
	@Size(min = 3, max = 15, message = "O atributo tipo do produto deve min=3 max=15 caracteres")
	private String tipoProduto;
	
	@NotNull(message = "O atributo pontuacao eh obrigatorio")
	private double pontuacao;*/
	


	
	/*
	//RELACIONAMENTOS---------------------------------------------------------------------------------
	
	@ManyToOne
	@JsonIgnoreProperties("inventario")
	private Recurso recurso;
	
	@OneToOne
	@JsonIgnoreProperties("inventario")
	private Rebelde rebelde;
	
	//FIM DOS RELACIONAMENTOS--------------------------------------------------------------------------
*/
	
	
	
	
	
	//Getters and Setters
	
	public String getTipoInventario() {
		return tipoInventario;
	}

	public void setTipoInventario(String tipoInventario) {
		this.tipoInventario = tipoInventario;
	}
/*
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
	}*/


	
	
	

	
	
	
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
