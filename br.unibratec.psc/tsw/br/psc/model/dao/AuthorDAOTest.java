package br.psc.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.junit.Test;

import br.psc.model.entity.manyToMany.Author;
import br.psc.model.entity.manyToMany.Book;

public class AuthorDAOTest  {
	
	@Test
	public void testAuthorInsert() {
		Author author = new Author();
		author.setName("Arthur Conan Doyle");
		
		AuthorDAO dao = new AuthorDAO();
		dao.insert(author);
		
		Author selectedAuthor = dao.selectByPrimaryKey(Author.class, author.getPrimaryKey());
		
		assertNotNull(selectedAuthor);
		
		/* Cannot be used, once the Attribute of Books Collection is not null, but will invoke an InvocationException
		Assert.assertEquals(author, selectedAuthor);*/
		
		assertNotSame(author, selectedAuthor);
		
		dao.deleteObject(author);
	}
	
	@Test(expected=RollbackException.class)
	public void testTransientObjectException() {
		Author author = new Author("Alan Moore");
		Book book = new Book("Promethea");
		author.addBook(book);
		
		AuthorDAO dao = new AuthorDAO();
		dao.insert(author);
		
		dao.deleteObject(author);
	}
	
	@Test(expected=PersistenceException.class)
	public void testDetachedEntityPersist() {
		Author author = new Author(1, "Neil Gaiman");
		AuthorDAO dao = new AuthorDAO();
		
		dao.insert(author);
		
		dao.deleteObject(author);
	}
	
	@Test
	public void testUpdateUnexistentAuthor() {
		Author author = new Author(1, "Brian Greene");
		AuthorDAO dao = new AuthorDAO();
		
		dao.update(author);
		
		Author selectedAuthor = (Author) dao.selectByEntity(Author.class, author);
		
		assertNotNull(selectedAuthor);
		
		/* Cannot be used, once the Attribute of Books Collection is not null, but will invoke an InvocationException
		Assert.assertEquals(author, selectedAuthor);*/
		
		assertNotSame(author, selectedAuthor);
		assertEquals(author.getId(), selectedAuthor.getId());
		assertEquals(author.getName(), selectedAuthor.getName());
		
		dao.deleteObject(author);
	}
	
}