package org.biz.dierentuin5.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.biz.dierentuin5.model.Hond;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/dierentuin5.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class HondDAOTest {
	
	private Log log = LogFactory.getLog(HondDAOTest.class);
	
	@Autowired
	protected HondDAO hondDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testSave() {
		log.info("testSave");
		hondDao.deleteAll();
		Hond hond = new Hond();
		hond.setNaam("Pluto");
		assertTrue(hondDao.save(hond));
		List<Hond> l = hondDao.find("Pluto");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Pluto");
	}
	
	@Test
	public void testUpdate() {
		log.info("testUpdate");
		hondDao.deleteAll();
		Hond hond = new Hond();
		hond.setNaam("Pluto");
		assertTrue(hondDao.save(hond));
		List<Hond> l = hondDao.find("Pluto");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Pluto");	
		hond = l.get(0);
		hond.setNaam("Fikkie");
		assertTrue(hondDao.update(hond.getHondId(), hond));
		l = hondDao.find("Fikkie");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Fikkie");			
	}

	//@Test(expected=Exception.class)
	@Test
	public void testUpdateException() {
		log.info("testUpdate");
		hondDao.deleteAll();
		Hond hond = new Hond();
		hond.setNaam("Pluto");
		hondDao.update(hond.getHondId(), hond);
	}

	
	@Test
	public void testGetAll() {
		log.info("testGetAll");
		hondDao.deleteAll();
		Hond hond1 = new Hond();
		hond1.setNaam("Fikkie");
		hondDao.save(hond1);
		Hond hond2 = new Hond();
		hond2.setNaam("Hector");
		hondDao.save(hond2);
		List<Hond> l = hondDao.getAll();
		for (Hond h : l) {
			log.info("Id = " +  h.getHondId() + " / Naam : " + h.getNaam());
		}
		assertEquals(l.size(), 2);
		l = hondDao.find("Fikkie");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Fikkie");
	}	
	
	@Test
	public void testDelete() {
		log.info("testDelete");
		hondDao.deleteAll();
		Hond hond = new Hond();
		hond.setNaam("Pluto");
		assertTrue(hondDao.save(hond));
		List<Hond> l = hondDao.find("Pluto");
		assertEquals(l.size(), 1);
		hond = l.get(0);
		assertEquals(hond.getNaam(), "Pluto");
		assertTrue(hondDao.delete(hond.getHondId()));
		l = hondDao.find("Pluto");
		assertEquals(l.size(), 0);
		assertFalse(hondDao.delete(hond.getHondId()));
	}
	
	@Test
	public void testDeleteAll() {
		log.info("testDeleteAll");
		hondDao.deleteAll();
		Hond hond1 = new Hond();
		hond1.setNaam("Fikkie");
		hondDao.save(hond1);
		Hond hond2 = new Hond();
		hond2.setNaam("Hector");
		hondDao.save(hond2);
		List<Hond> l = hondDao.getAll();
		assertEquals(l.size(), 2);
		assertTrue(hondDao.deleteAll());
		l = hondDao.getAll();
		assertEquals(l.size(), 0);
	}
	
}
