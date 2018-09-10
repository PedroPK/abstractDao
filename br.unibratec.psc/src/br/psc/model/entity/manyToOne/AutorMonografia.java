package br.psc.model.entity.manyToOne;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.psc.model.entity.EntityInterface;

// @ E ntity
public class AutorMonografia implements EntityInterface {
	
	/**
	 * - Serial Version UID
	 */
	private static final long serialVersionUID = 1778758595184235108L;
	
	@Id
	private int codigo;
	private int nome;
	
	@OneToMany(fetch=FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	private Collection<Monografia> monografias;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getNome() {
		return nome;
	}
	public void setNome(int nome) {
		this.nome = nome;
	}
	
	public Collection<Monografia> getMonografias() {
		return monografias;
	}
	public void setMonografias(Collection<Monografia> monografias) {
		this.monografias = monografias;
	}
	public void addMonografia(Monografia pMonografia) {
		if ( this.monografias == null ) {
			this.monografias = new ArrayList<Monografia>();
		}
		
		this.monografias.add(pMonografia);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((monografias == null) ? 0 : monografias.hashCode());
		result = prime * result + nome;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		AutorMonografia other = (AutorMonografia) obj;
		
		if (codigo != other.codigo)
			return false;
		
		if (monografias == null) {
			if (other.monografias != null && !other.monografias.isEmpty())
				return false;
		} else if (!monografias.equals(other.monografias))
			return false;
		
		if (nome != other.nome)
			return false;
		return true;
	}
	
	public Object getPrimaryKey() {
		return getCodigo();
	}
	
}