package br.com.starwars.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemRecursoPK implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="recurso_id")
	private Recurso recurso;
	
	@ManyToOne
	@JoinColumn(name="inventario_id")
	private Inventario inventario;
	
	
	
	//Getters and Setters
	
	
	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	
	// DESCOBRIR PARA QUE SERVE..
	
	@Override
	public int hashCode() {
		return Objects.hash(inventario, recurso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemRecursoPK other = (ItemRecursoPK) obj;
		return Objects.equals(inventario, other.inventario) && Objects.equals(recurso, other.recurso);
	}


	
	
	
	
	
	
}
