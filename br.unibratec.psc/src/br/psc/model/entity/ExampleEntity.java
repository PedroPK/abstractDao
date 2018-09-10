package br.psc.model.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// @ E ntity
public class ExampleEntity implements EntityInterface {
	
	/**
	 * - Serial Version UID
	 */
	private static final long serialVersionUID = 4013783019226645429L;
	
	@Id
	private String							id;
	private String							name;
	private Date							registrationDate;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Collection<CollectableEntity>	collectionEntities;
	
	public ExampleEntity() {}
	
	public ExampleEntity(String pId, String pName) {
		this.id = pId;
		this.name = pName;
		
		this.registrationDate = Calendar.getInstance().getTime();
	}
	
	public Object getPrimaryKey() {
		return getId();
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String pId) {
		this.id = pId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String pName) {
		this.name = pName;
	}
	
	public Date getRegistrationDate() {
		return this.registrationDate;
	}
	
	public void setRegistrationDate(Date pRegistrationData) {
		this.registrationDate = pRegistrationData;
	}
	
	public Collection<CollectableEntity> getCollectionEntities() {
		return collectionEntities;
	}

	public void setCollectionEntities(Collection<CollectableEntity> pCollectionEntities) {
		this.collectionEntities = pCollectionEntities;
	}
	
	public void addCollectableEntity(CollectableEntity pCollectableEntity) {
		if ( this.collectionEntities == null ) {
			this.collectionEntities = new ArrayList<CollectableEntity>();
		}
		
		this.collectionEntities.add(pCollectableEntity);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
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
		
		ExampleEntity other = (ExampleEntity) obj;
		
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		
		return true;
	}
	
}