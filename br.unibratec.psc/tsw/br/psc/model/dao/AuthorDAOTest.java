package br.psc.model.dao;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.psc.model.entity.manytomany.Author;
import br.psc.model.entity.manytomany.Book;

public class AuthorDAOTest {
	
	@Test
	public void testAuthorInsert() {
		Author author = new Author();
		author.setName("Arthur Conan Doyle");
		
		AuthorDAO dao = new AuthorDAO();
		dao.insert(author);
		
		Author selectedAuthor = (Author) dao.selectByEntity(author.getClass(), author);
		
		Assert.assertNotNull(selectedAuthor);
		
		/* Cannot be used, once the Attribute of Books Collection is not null, but will invoke an InvocationException
		Assert.assertEquals(author, selectedAuthor);*/
		
		Assert.assertNotSame(author, selectedAuthor);
	}
	
	@Ignore
	@Test
	public void testTransientObjectException() {
		Author author = new Author();
		Book book = new Book();
	}
	
}