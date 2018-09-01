package br.psc.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.psc.model.entity.EntityInterface;

public abstract class AbstractDAO //implements InterfaceDAO
{
	
	private Class entityClass;
	
	public void defineEntityClass(Class pEntityClass) {
		this.entityClass = pEntityClass;
	}
	
	public Class getEntityClass() {
		return this.entityClass;
	}
	
	/*
	 * Method to Insert/Create a new Registry in the Database
	 */
	public void insert(Object pObject) {
		insert(pObject, UtilJPA.getEntityManager(), true);
	}
	
	public void insert(Object pObject, EntityManager pEntityManager, boolean pCloseEntityManager) {
		EntityTransaction transaction = pEntityManager.getTransaction();
		transaction.begin();
		
		pEntityManager.persist(pObject);
		
		transaction.commit();
		
		if ( pCloseEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/*
	 * Method to Update/Merge a Registry in the Database
	 */
	public void update(Object pObject) {
		update(pObject, UtilJPA.getEntityManager(), true);
	}
	
	public void update(Object pObject, EntityManager pEntityManager, boolean pCloseEntityManager) {
		EntityTransaction transaction = pEntityManager.getTransaction();
		transaction.begin();
		
		pEntityManager.merge(pObject);
		
		transaction.commit();
		
		if ( pCloseEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/*
	 * Method to Delete/Remove a Registry in the Database, by receiving an Entity's
	/*/
	public void deleteObject(EntityInterface pEntity) {
		deleteObject(pEntity.getClass(), pEntity, UtilJPA.getEntityManager(), true);
	}
	public void deleteObject(Class pClass, EntityInterface pEntity) {
		deleteObject(pClass, pEntity, UtilJPA.getEntityManager(), true);
	}
	public void deleteObject(Class pClass, EntityInterface pEntidade, EntityManager pEntityManager, boolean pCloseEntityManager) {
		EntityTransaction transaction = pEntityManager.getTransaction();
		transaction.begin();
		
		Object registry = pEntityManager.find(pClass, pEntidade.getPrimaryKey());
		pEntityManager.remove(registry);
		
		transaction.commit();
		
		if ( pCloseEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/*
	 * Method to Delete/Remove a Registry in the Database, by receiving an Entity's Primary Key
	*/
	public void deleteByPrimaryKey(Class pClass, Object pPrimaryKey) {
		deleteByPrimaryKey(pClass, pPrimaryKey, UtilJPA.getEntityManager(), true);
	}
	public void deleteByPrimaryKey(Class pClass, Object pPrimaryKey, EntityManager pEntityManager, boolean pCloseEntityManager) {
		EntityTransaction transaction = pEntityManager.getTransaction();
		transaction.begin();
		
		Object registry = pEntityManager.find(pClass, pPrimaryKey);
		pEntityManager.remove(registry);
		
		transaction.commit();
		if ( pCloseEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/**
	 * Method to Select/Find a Registry in the Database, by receiving an Entity's Primary Key
	 */
	public Object select(Class pClass, Object pPrimaryKey) {
		return select(pClass, pPrimaryKey, UtilJPA.getEntityManager(), true);
	}
	public Object select(Class pClass, Object pPrimaryKey, EntityManager pEntityManager, boolean pCloseEntityManager) {
		Object registry = pEntityManager.find(pClass, pPrimaryKey);
		
		if ( pCloseEntityManager ) {
			pEntityManager.close();
		}
		
		return registry;
	}
	
}
