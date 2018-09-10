package br.psc.model.entity.manyToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.psc.model.entity.EntityInterface;

// @ E ntity
public class Monografia implements EntityInterface {
	
	/**
	 * - Serial Version UID
	 */
	private static final long serialVersionUID = 3076507830924402450L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int doi;
	
	@ManyToOne
	private AutorMonografia autor;
	
	public int getDoi() {
		return doi;
	}
	
	public void setDoi(int doi) {
		this.doi = doi;
	}
	
	public AutorMonografia getAutor() {
		return autor;
	}
	
	public void setAutor(AutorMonografia autor) {
		this.autor = autor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + doi;
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
		
		Monografia other = (Monografia) obj;
		
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		
		if (doi != other.doi)
			return false;
		
		return true;
	}

	@Override
	public Object getPrimaryKey() {
		return getDoi();
	}
	
}