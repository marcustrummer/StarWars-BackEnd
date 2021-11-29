package br.com.starwars.model;

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
@Table(name = "tb_localizacao")
public class Localizacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "O atributo latitude eh obrigatorio")
	@Size(min = 3, max = 15, message = "O atributo latitude deve ser no formato de latitude eg: 278.09° min=3 max=15")
	private String latitude;
	
	@NotNull(message = "O atributo longitude eh obrigatorio")
	@Size(min = 3, max = 15, message = "O atributo longitude deve ser no formato de latitude eg: 278.09° min=3 max=15")
	private String longitude;
	
	@NotNull(message = "O atributo nome eh obrigatorio")
	@Size(min = 3, max = 30, message = "O atributo nome deve conter no min=3 e no  max=15 caracteres")
	private String nomeGalaxia;

	//RELACIONAMENTOS---------------------------------------------------------------------------------
	
	
	@OneToOne
	@JsonIgnoreProperties("localizacao")
	private Rebelde rebelde;
	
	
	//FIM DOS RELACIONAMENTOS--------------------------------------------------------------------------

	
	//GETTERS AND SETTERS
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getNomeGalaxia() {
		return nomeGalaxia;
	}

	public void setNomeGalaxia(String nomeGalaxia) {
		this.nomeGalaxia = nomeGalaxia;
	}

	public Rebelde getRebelde() {
		return rebelde;
	}

	public void setRebelde(Rebelde rebelde) {
		this.rebelde = rebelde;
	}
	
	
	

}
