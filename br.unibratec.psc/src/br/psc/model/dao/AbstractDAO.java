package br.psc.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.psc.model.entity.EntityInterface;

public abstract class AbstractDAO<T extends EntityInterface> implements InterfaceDAO<T>
{
	
	private Class<T> aEntityClass;
	
	public void defineEntityClass(Class<T> pEntityClass) {
		this.aEntityClass = pEntityClass;
	}
	
	public Class<T> getEntityClass() {
		return this.aEntityClass;
	}
	
	/*
	 * Method to Insert/Create a new Registry in the Database
	 */
	public void insert(T pObject) {
		insert(pObject, UtilJPA.getEntityManager(), true);
	}
	
	public void insert(T pObject, EntityManager pEntityManager, boolean pCloseEntityManager) {
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
	public void update(T pObject) {
		update(pObject, UtilJPA.getEntityManager(), true);
	}
	
	public void update(T pObject, EntityManager pEntityManager, boolean pCloseEntityManager) {
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
	public void deleteObject(T pEntity) {
		deleteObject((Class<T>) pEntity.getClass(), pEntity, UtilJPA.getEntityManager(), true);
	}
	public void deleteObject(Class<T> pClass, T pEntity) {
		deleteObject(pClass, pEntity, UtilJPA.getEntityManager(), true);
	}
	public void deleteObject(
		Class<T>			pClass, 
		T					pEntidade, 
		EntityManager		pEntityManager, 
		boolean				pCloseEntityManager
	) {
		EntityTransaction transaction = pEntityManager.getTransaction();
		transaction.begin();
		
		T registryToBeDeleted = pEntityManager.find(pClass, pEntidade.getPrimaryKey());
		pEntityManager.remove(registryToBeDeleted);
		
		transaction.commit();
		
		if ( pCloseEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/*
	 * Method to Delete/Remove a Registry in the Database, by receiving an Entity's Primary Key
	*/
	public void deleteByPrimaryKey(Class<T> pClass, Object pPrimaryKey) {
		deleteByPrimaryKey(pClass, pPrimaryKey, UtilJPA.getEntityManager(), true);
	}
	public void deleteByPrimaryKey(Class<T> pClass, Object pPrimaryKey, EntityManager pEntityManager, boolean pCloseEntityManager) {
		EntityTransaction transaction = pEntityManager.getTransaction();
		transaction.begin();
		
		T registry = pEntityManager.find(pClass, pPrimaryKey);
		pEntityManager.remove(registry);
		
		transaction.commit();
		if ( pCloseEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/**
	 * Method to Select/Find a Registry in the Database, by receiving an Entity's Primary Key
	 */
	public T selectByPrimaryKey(Class<T> pClass, Object pPrimaryKey) {
		return selectByPrimaryKey(pClass, pPrimaryKey, UtilJPA.getEntityManager(), true);
	}
	public T selectByPrimaryKey(Class<T> pClass, Object pPrimaryKey, EntityManager pEntityManager, boolean pCloseEntityManager) {
		T registry = pEntityManager.find(pClass, pPrimaryKey);
		
		if ( pCloseEntityManager ) {
			pEntityManager.close();
		}
		
		return registry;
	}
	
	/**
	 * Method to Select/Find a Registry in the Database, by receiving an Entity's Primary Key
	 */
	public T selectByEntity(Class<T> pClass, EntityInterface pEntity) {
		return selectByEntity(pClass, pEntity, UtilJPA.getEntityManager(), true);
	}
	public T selectByEntity(Class<T> pClass, EntityInterface pEntity, EntityManager pEntityManager, boolean pCloseEntityManager) {
		T registry = pEntityManager.find(pClass, pEntity.getPrimaryKey());
		
		if ( pCloseEntityManager ) {
			pEntityManager.close();
		}
		
		return registry;
	}
	
}