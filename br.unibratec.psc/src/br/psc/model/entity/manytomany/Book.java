package br.psc.model.entity.manytomany;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.psc.model.entity.EntityInterface;

@Entity
public class Book implements EntityInterface {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -6395240399913380002L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long isbn;
	
	private String title;
	
	@ManyToMany
	private Collection<Author> authors;
	
	public Book() {
		super();
	}
	
	public Book(String pTitle) {
		super();
		this.title = pTitle;
	}
	
	public long getIsbn() {
		return isbn;
	}
	
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Collection<Author> getAuthors() {
		return authors;
	}
	
	public void setAuthors(Collection<Author> authors) {
		this.authors = authors;
	}
	
	@Override
	public Object getPrimaryKey() {
		return getIsbn();
	}
	
}