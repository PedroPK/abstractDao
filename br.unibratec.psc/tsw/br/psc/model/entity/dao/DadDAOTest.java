package br.psc.model.entity.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.psc.model.entity.multipleBags.Dad;
import br.psc.model.entity.multipleBags.Daugther;
import br.psc.model.entity.multipleBags.Son;

public class DadDAOTest {
	
	@Ignore
	@Test
	public void testInsertIntoListMultipleBagsDifferentSizes() {
		Dad dad = new Dad();
		dad.addSonToList(new Son("Benny"));
		dad.addSonToList(new Son("Danny"));
		dad.addDaugtherToList(new Daugther("Morgan"));
		dad.addDaugtherToList(new Daugther("Grace"));
		dad.addDaugtherToList(new Daugther("Mary"));
		
		DadDAO dao = new DadDAO();
		dao.insert(dad);
		
		Dad selectedDad = (Dad) dao.selectByEntity(dad.getClass(), dad);
		
		dao.deleteObject(dad);
	}
	
	@Ignore
	@Test
	public void testInsertIntoListMultipleBagsSameSizes() {
		Dad dad = new Dad();
		dad.addSonToList(new Son("Benny"));
		dad.addSonToList(new Son("Danny"));
		dad.addDaugtherToList(new Daugther("Morgan"));
		dad.addDaugtherToList(new Daugther("Grace"));
		dad.addDaugtherToList(new Daugther("Mary"));
		
		dad.addSonToList(new Son("Extra son"));
		
		DadDAO dao = new DadDAO();
		dao.insert(dad);
		
		Dad selectedDad = (Dad) dao.selectByEntity(dad.getClass(), dad);
		
		dao.deleteObject(dad);
	}
	
	@Test
	public void testInsertIntoSetsMultipleBagsDifferentSizes() {
		Dad dad = new Dad();
		dad.addSonToSet(new Son("Benny"));
		dad.addSonToSet(new Son("Danny"));
		dad.addDaugtherToSet(new Daugther("Morgan"));
		dad.addDaugtherToSet(new Daugther("Grace"));
		dad.addDaugtherToSet(new Daugther("Mary"));
		
		DadDAO dao = new DadDAO();
		dao.insert(dad);
		
		Dad selectedDad = (Dad) dao.selectByEntity(dad.getClass(), dad);
		
		dao.deleteObject(dad);
	}
	
}