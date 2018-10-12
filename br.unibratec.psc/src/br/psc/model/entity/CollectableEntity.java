package br.psc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CollectableEntity implements EntityInterface {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 4842161357647159762L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int		id;
	
	private String	name;
	
	public CollectableEntity() {
		super();
	}

	public CollectableEntity(String pName) {
		super();
		this.name = pName;
	}
	
	@Override
	public Object getPrimaryKey() {
		return getId();
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int pId) {
		this.id = pId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String pName) {
		this.name = pName;
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (this.getClass() != obj.getClass())
			return false;
		
		CollectableEntity other = (CollectableEntity) obj;
		
		if (this.id != other.id)
			return false;
		
		if (this.name == null) {
			if (other.name != null)
				return false;
		} else if (!this.name.equals(other.name))
			return false;
		
		return true;
	}
	
}