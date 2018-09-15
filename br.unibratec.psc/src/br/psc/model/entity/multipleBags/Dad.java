package br.psc.model.entity.multipleBags;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.psc.model.entity.EntityInterface;

//@Entity
public class Dad implements EntityInterface {
	
	/**
	 * - Serial Version UID
	 */
	private static final long serialVersionUID = -8410007084226305980L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private short id;
	
	// Chance to All or Persist. to test Delete
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Son> sonsList;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Son> sonsSet;
	
	// Comment and uncomment to show students
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Daugther> daugthersList;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Daugther> daugthersSet;
	
	public short getId() {
		return id;
	}
	
	public void setId(short id) {
		this.id = id;
	}
	
	public List<Son> getSonsList() {
		return sonsList;
	}
	
	public void setSonsList(List<Son> pSonsList) {
		this.sonsList = pSonsList;
	}
	
	public List<Daugther> getDaugthersList() {
		return daugthersList;
	}
	
	public void setDaugthersList(List<Daugther> pDaugthersList) {
		this.daugthersList = pDaugthersList;
	}
	
	public void addSonToList(Son pSon) {
		if ( this.sonsList == null ) {
			this.sonsList = new ArrayList<Son>();
		}
		
		this.sonsList.add(pSon);
	}
	
	public void addDaugtherToList(Daugther pDaugther) {
		if ( this.daugthersList == null ) {
			this.daugthersList = new ArrayList<Daugther>();
		}
		
		this.daugthersList.add(pDaugther);
	}
	
	public Set<Son> getSonsSet() {
		return sonsSet;
	}

	public void setSonsSet(Set<Son> pSonsSet) {
		this.sonsSet = pSonsSet;
	}

	public Set<Daugther> getDougthersSet() {
		return daugthersSet;
	}

	public void setDougthersSet(Set<Daugther> pDougthersSet) {
		this.daugthersSet = pDougthersSet;
	}
	
	public void addSonToSet(Son pSon) {
		if ( this.sonsSet == null ) {
			this.sonsSet = new HashSet<Son>();
		}
		
		this.sonsSet.add(pSon);
	}
	
	public void addDaugtherToSet(Daugther pDaugther) {
		if ( this.daugthersSet == null ) {
			this.daugthersSet = new HashSet<Daugther>();
		}
		
		this.daugthersSet.add(pDaugther);
	}
	
	@Override
	public Object getPrimaryKey() {
		return getId();
	}
	
}