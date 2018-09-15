package br.psc.model.entity.dao.antiAnemic;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import br.psc.model.entity.EntityInterface;
import br.psc.model.entity.antiAnemic.ContaCorrente;

public class ContaCorrenteDAOTest {
	
	@Test
	public void testInsert() {
		ContaCorrente cc = new ContaCorrente((short) 15091, "21685-2", new BigDecimal(100.0));
		
		ContaCorrenteDAO<ContaCorrente> dao = new ContaCorrenteDAO<>();
		dao.insert(cc);
	}
	
	@Test
	public void testSelect() {
		ContaCorrente cc = new ContaCorrente((short) 15091, "21685-2", new BigDecimal(100.0));
		
		ContaCorrenteDAO<ContaCorrente> dao = new ContaCorrenteDAO<>();
		ContaCorrente selectedCC = (ContaCorrente) dao.selectByPrimaryKey((Class<EntityInterface>) cc.getClass(), "21685-2");
		
		Assert.assertEquals(	cc,		selectedCC);
		Assert.assertNotSame(	cc,		selectedCC);
	}
	
}