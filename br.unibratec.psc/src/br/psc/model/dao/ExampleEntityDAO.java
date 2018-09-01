package br.psc.model.dao;

import javax.persistence.EntityManager;

import br.psc.model.entity.EntityInterface;
import br.psc.model.entity.ExampleEntity;;

public class ExampleEntityDAO extends AbstractDAO {
	
	private ExampleEntity aEntity;
	
	public ExampleEntityDAO() {
		this.aEntity = new ExampleEntity();
	}
	
	public ExampleEntity selectByPrimaryKey(Object pPrimaryKey) {
		return (ExampleEntity) selectByPrimaryKey(aEntity.getClass(), pPrimaryKey);
	}
	
	public ExampleEntity selectByPrimaryKey(Object pPrimaryKey, EntityManager pEntityManager, boolean pCloseEntityManager) {
		return (ExampleEntity) selectByPrimaryKey(this.aEntity.getClass(), pPrimaryKey, pEntityManager, pCloseEntityManager);
	}
	
	public ExampleEntity selectByEntity(ExampleEntity pEntity) {
		return (ExampleEntity) selectByEntity(aEntity.getClass(), pEntity);
	}
	
	public ExampleEntity selectByEntity(ExampleEntity pEntity, EntityManager pEntityManager, boolean pCloseEntityManager) {
		return (ExampleEntity) selectByEntity(this.aEntity.getClass(), pEntity, pEntityManager, pCloseEntityManager);
	}
	
}