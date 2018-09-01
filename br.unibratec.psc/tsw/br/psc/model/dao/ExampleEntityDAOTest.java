package br.psc.model.dao;

import java.util.Calendar;

import static org.junit.Assert.*;
import org.junit.Test;

import br.psc.model.dao.ExampleEntityDAO;
import br.psc.model.entity.ExampleEntity;

public class ExampleEntityDAOTest {
	
	@Test
	public void testInsertionSelectDeleteExampleEntity() {
		// Arranging the Test Data
		ExampleEntity exampleEntity = new ExampleEntity();
		exampleEntity.setId("012.345.678-90");
		exampleEntity.setName("HAL 9000");
		exampleEntity.setRegistrationDate(Calendar.getInstance().getTime());
		
		ExampleEntityDAO eeDao = new ExampleEntityDAO();
		
		// Act
		eeDao.insert(exampleEntity);
		ExampleEntity selectedEntity = eeDao.selectByEntity(exampleEntity);
		
		// Assert
		assertEquals(exampleEntity,				selectedEntity);
		assertEquals(exampleEntity.hashCode(),	selectedEntity.hashCode());
		assertNotSame(exampleEntity, 			selectedEntity);
		
		// Reset the Database
		eeDao.deleteObject(exampleEntity);
	}
	
}