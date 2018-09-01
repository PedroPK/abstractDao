package br.psc.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.psc.model.entity.EntityInterface;

public abstract class AbstractDAO //implements InterfaceDAO
{
	
	private Class classeEntidade;
	
	public void definirClasseEntidade(Class pClasseEntidade ) {
		this.classeEntidade = pClasseEntidade;
	}
	
	public Class getClasseEntidade() {
		return this.classeEntidade;
	}
	
	/*
	 * Versão anterior do método abaixo
	 * 
	 * 
	public void inserir(Object pObject) {
		EntityManager manager = UtilJPA.getEntityManager();
		inserir(pObject, manager, true);
	}
	*/
	public void inserir(Object pObject) {
		inserir(pObject, UtilJPA.getEntityManager(), true);
	}
	
	public void inserir(Object pObject, EntityManager pEntityManager, boolean pFecharEntityManager) {
		EntityTransaction transacao = pEntityManager.getTransaction();
		transacao.begin();
		
		pEntityManager.persist(pObject);
		
		transacao.commit();
		
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/*
	 * Versão anterior do método abaixo
	 * 
	 * 
	public void alterar(Object pObject) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.merge(pObject);
		
		transacao.commit();
		manager.close();
	}*/
	public void alterar(Object pObject) {
		alterar(pObject, UtilJPA.getEntityManager(), true);
	}
	
	public void alterar(Object pObject, EntityManager pEntityManager, boolean pFecharEntityManager) {
		EntityTransaction transacao = pEntityManager.getTransaction();
		transacao.begin();
		
		pEntityManager.merge(pObject);
		
		transacao.commit();
		
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/*
	 * Versão anterior do método abaixo
	 * 
	 * 
	public void excluirPorObjeto(Class pClasse, Entidade pEntidade) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		Object registro = manager.find(pClasse, pEntidade.getChavePrimaria());
		manager.remove(registro);
		
		transacao.commit();
		manager.close();
	}
	/*/
	public void excluirPorObjeto(EntityInterface pEntidade) {
		excluirPorObjeto(pEntidade.getClass(), pEntidade, UtilJPA.getEntityManager(), true);
	}
	public void excluirPorObjeto(Class pClasse, EntityInterface pEntidade) {
		excluirPorObjeto(pClasse, pEntidade, UtilJPA.getEntityManager(), true);
	}
	public void excluirPorObjeto(Class pClasse, EntityInterface pEntidade, EntityManager pEntityManager, boolean pFecharEntityManager) {
		EntityTransaction transacao = pEntityManager.getTransaction();
		transacao.begin();
		
		Object registro = pEntityManager.find(pClasse, pEntidade.getChavePrimaria());
		pEntityManager.remove(registro);
		
		transacao.commit();
		
		if (pFecharEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/*
	 * Versão anterior do método abaixo
	 * 
	 * 
	public void excluirPorChavePrimaria(Class pClasse, Object pChavePrimaria) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		Object registro = manager.find(pClasse, pChavePrimaria);
		manager.remove(registro);
		
		transacao.commit();
		manager.close();
	}
	*/
	public void excluirPorChavePrimaria(Class pClasse, Object pChavePrimaria) {
		excluirPorChavePrimaria(pClasse, pChavePrimaria, UtilJPA.getEntityManager(), true);
	}
	public void excluirPorChavePrimaria(Class pClasse, Object pChavePrimaria, EntityManager pEntityManager, boolean pFecharEntityManager) {
		EntityTransaction transacao = pEntityManager.getTransaction();
		transacao.begin();
		
		Object registro = pEntityManager.find(pClasse, pChavePrimaria);
		pEntityManager.remove(registro);
		
		transacao.commit();
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/*
	 * Versão anterior do método abaixo
	 * 
	 * 
	public Object consultar(Class pClasse, Object pPrimaryKey) {
		EntityManager manager = UtilJPA.getEntityManager();
		
		Object registro = manager.find(pClasse, pPrimaryKey);
		
		manager.close();
		return registro;
	}
	*/
	public Object consultar(Class pClasse, Object pPrimaryKey) {
		return consultar(pClasse, pPrimaryKey, UtilJPA.getEntityManager(), true);
	}
	public Object consultar(Class pClasse, Object pPrimaryKey, EntityManager pEntityManager, boolean pFecharEntityManager) {
		Object registro = pEntityManager.find(pClasse, pPrimaryKey);
		
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
		
		return registro;
	}
	
}
