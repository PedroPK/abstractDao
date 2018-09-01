package br.psc.model.dao;

import java.util.Calendar;

import org.junit.Test;

import br.psc.model.dao.ExampleEntityDAO;
import br.psc.model.entity.ExampleEntity;

public class ExampleEntityDAOTest {
	
	@Test
	public void testInsertionDeleteExampleEntity() {
		ExampleEntityDAO exampleEntityDao = new ExampleEntityDAO();
		
		ExampleEntity exampleEntity = new ExampleEntity();
		exampleEntity.setId("012.345.678-90");
		exampleEntity.setName("HAL 9000");
		exampleEntity.setRegistrationDate(Calendar.getInstance().getTime());
		
		
		exampleEntityDao.insert(exampleEntity);
		exampleEntityDao.deleteObject(exampleEntity);
	}
	
}