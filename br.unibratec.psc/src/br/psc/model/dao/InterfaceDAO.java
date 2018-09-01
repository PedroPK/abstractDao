package br.psc.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.psc.model.entity.EntityInterface;

public interface InterfaceDAO {
	
	public void definirClasseEntidade(Class pClasseEntidade ) ;
	public Class getClasseEntidade();
	
	public void inserir(Object pObject);
	public void inserir(Object pObject, EntityManager pEntityManager, boolean pFecharEntityManager);
	
	public void alterar(Object pObject);
	public void alterar(Object pObject, EntityManager pEntityManager, boolean pFecharEntityManager);
	
	public void excluirPorObjeto(EntityInterface pEntidade);
	public void excluirPorObjeto(Class pClasse, EntityInterface pEntidade);
	public void excluirPorObjeto(Class pClasse, EntityInterface pEntidade, EntityManager pEntityManager, boolean pFecharEntityManager);
	
	public void excluirPorChavePrimaria(Class pClasse, Object pChavePrimaria);
	public void excluirPorChavePrimaria(Class pClasse, Object pChavePrimaria, EntityManager pEntityManager, boolean pFecharEntityManager);
	
	public Object consultar(Class pClasse, Object pPrimaryKey);
	
}
