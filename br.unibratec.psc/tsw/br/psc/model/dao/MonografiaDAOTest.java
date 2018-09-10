package br.psc.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import br.psc.model.entity.manyToOne.AutorMonografia;
import br.psc.model.entity.manyToOne.Monografia;

public class MonografiaDAOTest {
	
	@Test
	public void testInserMonografiaSemAutor() {
		Monografia monografia = new Monografia();
		MonografiaDAO dao = new MonografiaDAO();
		
		dao.insert(monografia);
		Monografia selectedMonografia = 
			(Monografia) dao.selectByEntity(monografia.getClass(), monografia);
		
		assertNotNull(selectedMonografia);
		assertNotSame(monografia, selectedMonografia);
		assertEquals(monografia, selectedMonografia);
	}
	
	@Test
	public void testInserAutor() {
		AutorMonografia autor = new AutorMonografia();
		AutorMonografiaDAO dao = new AutorMonografiaDAO();
		
		dao.insert(autor);
		AutorMonografia selectedAutor = 
			(AutorMonografia) dao.selectByEntity(autor.getClass(), autor);
		
		assertNotNull(selectedAutor);
		assertNotSame(autor, selectedAutor);
		assertEquals(autor, selectedAutor);
	}
	
	@Test
	public void testInserMonografiaComAutor() {
		Monografia monografia = new Monografia();
		AutorMonografia autor = new AutorMonografia();
		autor.addMonografia(monografia);
		
		MonografiaDAO dao = new MonografiaDAO();
		
		dao.insert(monografia);
		Monografia selectedMonografia = 
			(Monografia) dao.selectByEntity(monografia.getClass(), monografia);
		
		assertNotNull(selectedMonografia);
		assertNotSame(monografia, selectedMonografia);
		assertEquals(monografia, selectedMonografia);
	}
	
}