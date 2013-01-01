package org.biz.dierentuin5.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.biz.dierentuin5.model.Forel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/dierentuin5.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ForelDAOTest {
	
	private Log log = LogFactory.getLog(ForelDAOTest.class);
	
	@Autowired
	protected ForelDAO forelDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testSave() {
		log.info("testSave");
		forelDao.deleteAll();
		Forel forel = new Forel();
		forel.setNaam("Bluppie");
		assertTrue(forelDao.save(forel));
		List<Forel> l = forelDao.find("Bluppie");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Bluppie");
	}
	
	@Test
	public void testUpdate() {
		log.info("testUpdate");
		forelDao.deleteAll();
		Forel forel = new Forel();
		forel.setNaam("Bluppie");
		assertTrue(forelDao.save(forel));
		List<Forel> l = forelDao.find("Bluppie");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Bluppie");	
		forel = l.get(0);
		forel.setNaam("Blinkie");
		assertTrue(forelDao.update(forel.getForelId(), forel));
		l = forelDao.find("Blinkie");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Blinkie");			
	}

	//@Test(expected=Exception.class)
	@Test
	public void testUpdateException() {
		log.info("testUpdate");
		forelDao.deleteAll();
		Forel forel = new Forel();
		forel.setNaam("Bluppie");
		forelDao.update(forel.getForelId(), forel);
	}

	
	@Test
	public void testGetAll() {
		log.info("testGetAll");
		forelDao.deleteAll();
		Forel forel1 = new Forel();
		forel1.setNaam("Bluppie");
		forelDao.save(forel1);
		Forel forel2 = new Forel();
		forel2.setNaam("Blinkie");
		forelDao.save(forel2);
		List<Forel> l = forelDao.getAll();
		for (Forel h : l) {
			log.info("Id = " +  h.getForelId() + " / Naam : " + h.getNaam());
		}
		assertEquals(l.size(), 2);
		l = forelDao.find("Bluppie");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Bluppie");
	}	
	
	@Test
	public void testDelete() {
		log.info("testDelete");
		forelDao.deleteAll();
		Forel forel = new Forel();
		forel.setNaam("Bluppie");
		assertTrue(forelDao.save(forel));
		List<Forel> l = forelDao.find("Bluppie");
		assertEquals(l.size(), 1);
		forel = l.get(0);
		assertEquals(forel.getNaam(), "Bluppie");
		assertTrue(forelDao.delete(forel.getForelId()));
		l = forelDao.find("Bluppie");
		assertEquals(l.size(), 0);
		assertFalse(forelDao.delete(forel.getForelId()));
	}
	
	@Test
	public void testDeleteAll() {
		log.info("testDeleteAll");
		forelDao.deleteAll();
		Forel forel1 = new Forel();
		forel1.setNaam("Bluppie");
		forelDao.save(forel1);
		Forel forel2 = new Forel();
		forel2.setNaam("Blinkie");
		forelDao.save(forel2);
		List<Forel> l = forelDao.getAll();
		assertEquals(l.size(), 2);
		assertTrue(forelDao.deleteAll());
		l = forelDao.getAll();
		assertEquals(l.size(), 0);
	}
	
}
