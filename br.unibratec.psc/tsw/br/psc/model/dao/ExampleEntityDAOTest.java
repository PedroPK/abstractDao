package br.psc.model.dao;

import java.util.Calendar;
import java.util.Collection;

import static org.junit.Assert.*;
import org.junit.Test;

import br.psc.model.dao.ExampleEntityDAO;
import br.psc.model.entity.CollectableEntity;
import br.psc.model.entity.ExampleEntity;

public class ExampleEntityDAOTest {
	
	@Test
	public void testInsertionSelectDeleteExampleEntity() {
		// Arranging the Test Data
		ExampleEntity exampleEntity = new ExampleEntity("012.345.678-90", "HAL 9000");
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
	
	@Test
	public void testOneToManyMapping() {
		// Arrange the Test Data
		ExampleEntity exampleEntity = new ExampleEntity("123.456.789-01", "Wall-E");
		exampleEntity.addCollectableEntity(new CollectableEntity("Coins"));
		exampleEntity.addCollectableEntity(new CollectableEntity("Stamples"));
		exampleEntity.addCollectableEntity(new CollectableEntity("Comic Books"));
		exampleEntity.addCollectableEntity(new CollectableEntity("Action Figures"));
		ExampleEntityDAO eeDao = new ExampleEntityDAO();
		
		// Act
		eeDao.insert(exampleEntity);
		ExampleEntity selectedEntity = eeDao.selectByEntity(exampleEntity);
		Collection<CollectableEntity> collectables = selectedEntity.getCollectionEntities();
		
		eeDao.deleteObject(exampleEntity);
	}
	
}