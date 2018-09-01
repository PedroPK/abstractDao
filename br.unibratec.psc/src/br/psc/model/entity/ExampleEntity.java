package br.psc.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExampleEntity implements EntityInterface {
	
	@Id
	private String	id;
	private String	name;
	private Date	registrationDate;
	
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

}
