package br.psc.model.entity.multipleBags;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.psc.model.entity.EntityInterface;

@Entity
public class Son implements EntityInterface {
	
	/**
	 * - Serial Version UID
	 */
	private static final long serialVersionUID = -7398785172686303322L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private short id;
	
	private String name;
	
	public Son() {
		super();
	}
	
	public Son(String pName) {
		super();
		this.name = pName;
	}

	public short getId() {
		return id;
	}
	
	public void setId(short pId) {
		this.id = pId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String pName) {
		this.name = pName;
	}
	
	@Override
	public Object getPrimaryKey() {
		return getId();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object pObj) {
		if (this == pObj)
			return true;
		if (pObj == null)
			return false;
		if (getClass() != pObj.getClass())
			return false;
		Son other = (Son) pObj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}