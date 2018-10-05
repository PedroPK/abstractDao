package br.psc.model.dao;

import javax.persistence.EntityManager;

import br.psc.model.entity.manyToMany.Author;

public class AuthorDAO extends AbstractDAO<Author>
//implements InterfaceDAO 
{

	@Override
	public Author selectByEntity(Class<Author> pClass, Author pEntity, EntityManager pEntityManager,
			boolean pCloseEntityManager) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}