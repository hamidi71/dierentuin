package org.biz.dierentuin5.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.biz.dierentuin5.model.Poes;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/dierentuin5.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PoesDAOTest {
	
	private Log log = LogFactory.getLog(PoesDAOTest.class);
	
	@Autowired
	protected PoesDAO poesDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testSave() {
		log.info("testSave");
		poesDao.deleteAll();
		Poes poes = new Poes();
		poes.setNaam("Minoes");
		assertTrue(poesDao.save(poes));
		List<Poes> l = poesDao.find("Minoes");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Minoes");
	}
	
	@Test
	public void testUpdate() {
		log.info("testUpdate");
		poesDao.deleteAll();
		Poes poes = new Poes();
		poes.setNaam("Minoes");
		assertTrue(poesDao.save(poes));
		List<Poes> l = poesDao.find("Minoes");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Minoes");	
		poes = l.get(0);
		poes.setNaam("Minet");
		assertTrue(poesDao.update(poes.getPoesId(), poes));
		l = poesDao.find("Minet");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Minet");			
	}

	//@Test(expected=Exception.class)
	@Test
	public void testUpdateException() {
		log.info("testUpdate");
		poesDao.deleteAll();
		Poes poes = new Poes();
		poes.setNaam("Minoes");
		poesDao.update(poes.getPoesId(), poes);
	}

	
	@Test
	public void testGetAll() {
		log.info("testGetAll");
		poesDao.deleteAll();
		Poes poes1 = new Poes();
		poes1.setNaam("Minoes");
		poesDao.save(poes1);
		Poes poes2 = new Poes();
		poes2.setNaam("Minet");
		poesDao.save(poes2);
		List<Poes> l = poesDao.getAll();
		for (Poes h : l) {
			log.info("Id = " +  h.getPoesId() + " / Naam : " + h.getNaam());
		}
		assertEquals(l.size(), 2);
		l = poesDao.find("Minoes");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Minoes");
	}	
	
	@Test
	public void testDelete() {
		log.info("testDelete");
		poesDao.deleteAll();
		Poes poes = new Poes();
		poes.setNaam("Minoes");
		assertTrue(poesDao.save(poes));
		List<Poes> l = poesDao.find("Minoes");
		assertEquals(l.size(), 1);
		poes = l.get(0);
		assertEquals(poes.getNaam(), "Minoes");
		assertTrue(poesDao.delete(poes.getPoesId()));
		l = poesDao.find("Minoes");
		assertEquals(l.size(), 0);
		assertFalse(poesDao.delete(poes.getPoesId()));
	}
	
	@Test
	public void testDeleteAll() {
		log.info("testDeleteAll");
		poesDao.deleteAll();
		Poes poes1 = new Poes();
		poes1.setNaam("Minoes");
		poesDao.save(poes1);
		Poes poes2 = new Poes();
		poes2.setNaam("Minet");
		poesDao.save(poes2);
		List<Poes> l = poesDao.getAll();
		assertEquals(l.size(), 2);
		assertTrue(poesDao.deleteAll());
		l = poesDao.getAll();
		assertEquals(l.size(), 0);
	}
	
}
