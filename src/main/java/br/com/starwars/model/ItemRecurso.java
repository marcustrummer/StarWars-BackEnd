package br.com.starwars.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_itemRecurso")
public class ItemRecurso implements Serializable {
	private static final long serialVersionUID = 1L;

		
		@JsonIgnore
		@EmbeddedId
		private ItemRecursoPK id = new ItemRecursoPK();
		
		@NotNull(message = "O atributo pontuacao é obrigatório")
		private long pontos;
		
		@NotNull(message = "O atributo pontuacao é obrigatório")
		private long quantidade;
		
		
		
		
		public ItemRecurso() {
		}

		
		public ItemRecurso(Recurso recurso, Inventario inventario, long pontos, long quantidade) {
			super();
			id.setRecurso(recurso);
			id.setInventario(inventario);
			this.pontos = pontos;
			this.quantidade = quantidade;
		}
		
		
		
		
		//Getters and Setters

		public ItemRecursoPK getId() {
			return id;
		}

		public void setId(ItemRecursoPK id) {
			this.id = id;
		}

		public long getPontos() {
			return pontos;
		}

		public void setPontos(long pontos) {
			this.pontos = pontos;
		}

		public long getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(long quantidade) {
			this.quantidade = quantidade;
		}
		
		
		
		
		// DESCOBRIR PARA QUE SERVE..

		@Override
		public int hashCode() {
			return Objects.hash(id, pontos, quantidade);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ItemRecurso other = (ItemRecurso) obj;
			return Objects.equals(id, other.id) && pontos == other.pontos && quantidade == other.quantidade;
		}
		
		
		//
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(getId());
			builder.append(", Quantidade ");
			builder.append(getQuantidade());
			builder.append(", Pontuação: ");
			builder.append(getPontos());
			builder.append("/n");
			
			
			return builder.toString();
		}
		
		
		

}
