package org.biz.dierentuin5.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.biz.dierentuin5.model.Hok;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/dierentuin5.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class HokDAOTest {
	
	private Log log = LogFactory.getLog(HokDAOTest.class);
	
	@Autowired
	protected HokDAO hokDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testSave() {
		log.info("testSave");
		hokDao.deleteAll();
		Hok hok = new Hok();
		hok.setNaam("Hok1");
		assertTrue(hokDao.save(hok));
		List<Hok> l = hokDao.find("Hok1");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Hok1");
	}
	
	@Test
	public void testUpdate() {
		log.info("testUpdate");
		hokDao.deleteAll();
		Hok hok = new Hok();
		hok.setNaam("Hok1");
		assertTrue(hokDao.save(hok));
		List<Hok> l = hokDao.find("Hok1");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Hok1");	
		hok = l.get(0);
		hok.setNaam("Hok2");
		assertTrue(hokDao.update(hok.getHokId(), hok));
		l = hokDao.find("Hok2");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Hok2");			
	}

	@Test
	public void testUpdateException() {
		log.info("testUpdate");
		hokDao.deleteAll();
		Hok hok = new Hok();
		hok.setNaam("Hok1");
		hokDao.update(hok.getHokId(), hok);
	}
	
	@Test
	public void testGetAll() {
		log.info("testGetAll");
		hokDao.deleteAll();
		Hok hok1 = new Hok();
		hok1.setNaam("Hok1");
		hokDao.save(hok1);
		Hok hok2 = new Hok();
		hok2.setNaam("Hok2");
		hokDao.save(hok2);
		List<Hok> l = hokDao.getAll();
		for (Hok h : l) {
			log.info("Id = " +  h.getHokId() + " / Naam : " + h.getNaam());
		}
		assertEquals(l.size(), 2);
		l = hokDao.find("Hok1");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Hok1");
	}	
	
	@Test
	public void testDelete() {
		log.info("testDelete");
		hokDao.deleteAll();
		Hok hok = new Hok();
		hok.setNaam("Hok1");
		assertTrue(hokDao.save(hok));
		List<Hok> l = hokDao.find("Hok1");
		assertEquals(l.size(), 1);
		hok = l.get(0);
		assertEquals(hok.getNaam(), "Hok1");
		assertTrue(hokDao.delete(hok.getHokId()));
		l = hokDao.find("Hok1");
		assertEquals(l.size(), 0);
		assertFalse(hokDao.delete(hok.getHokId()));
	}
	
	@Test
	public void testDeleteAll() {
		log.info("testDeleteAll");
		hokDao.deleteAll();
		Hok hok1 = new Hok();
		hok1.setNaam("Hok1");
		hokDao.save(hok1);
		Hok hok2 = new Hok();
		hok2.setNaam("Hok2");
		hokDao.save(hok2);
		List<Hok> l = hokDao.getAll();
		assertEquals(l.size(), 2);
		assertTrue(hokDao.deleteAll());
		l = hokDao.getAll();
		assertEquals(l.size(), 0);
	}
	
}
