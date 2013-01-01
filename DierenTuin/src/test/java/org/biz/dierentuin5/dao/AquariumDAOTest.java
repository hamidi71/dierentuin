package org.biz.dierentuin5.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.biz.dierentuin5.model.Aquarium;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/dierentuin5.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AquariumDAOTest {
	
	private Log log = LogFactory.getLog(AquariumDAOTest.class);
	
	@Autowired
	protected AquariumDAO aquariumDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testSave() {
		log.info("testSave");
		aquariumDao.deleteAll();
		Aquarium aquarium = new Aquarium();
		aquarium.setNaam("Aq1");
		assertTrue(aquariumDao.save(aquarium));
		List<Aquarium> l = aquariumDao.find("Aq1");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Aq1");
	}
	
	@Test
	public void testUpdate() {
		log.info("testUpdate");
		aquariumDao.deleteAll();
		Aquarium aquarium = new Aquarium();
		aquarium.setNaam("Aq1");
		assertTrue(aquariumDao.save(aquarium));
		List<Aquarium> l = aquariumDao.find("Aq1");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Aq1");	
		aquarium = l.get(0);
		aquarium.setNaam("Aq2");
		assertTrue(aquariumDao.update(aquarium.getAquariumId(), aquarium));
		l = aquariumDao.find("Aq2");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Aq2");			
	}

	@Test
	public void testUpdateException() {
		log.info("testUpdate");
		aquariumDao.deleteAll();
		Aquarium aquarium = new Aquarium();
		aquarium.setNaam("Aq1");
		aquariumDao.update(aquarium.getAquariumId(), aquarium);
	}

	
	@Test
	public void testGetAll() {
		log.info("testGetAll");
		aquariumDao.deleteAll();
		Aquarium aquarium1 = new Aquarium();
		aquarium1.setNaam("Aq1");
		aquariumDao.save(aquarium1);
		Aquarium aquarium2 = new Aquarium();
		aquarium2.setNaam("Aq2");
		aquariumDao.save(aquarium2);
		List<Aquarium> l = aquariumDao.getAll();
		for (Aquarium h : l) {
			log.info("Id = " +  h.getAquariumId() + " / Naam : " + h.getNaam());
		}
		assertEquals(l.size(), 2);
		l = aquariumDao.find("Aq1");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Aq1");
	}	
	
	@Test
	public void testDelete() {
		log.info("testDelete");
		aquariumDao.deleteAll();
		Aquarium aquarium = new Aquarium();
		aquarium.setNaam("Aq1");
		assertTrue(aquariumDao.save(aquarium));
		List<Aquarium> l = aquariumDao.find("Aq1");
		assertEquals(l.size(), 1);
		aquarium = l.get(0);
		assertEquals(aquarium.getNaam(), "Aq1");
		assertTrue(aquariumDao.delete(aquarium.getAquariumId()));
		l = aquariumDao.find("Aq1");
		assertEquals(l.size(), 0);
		assertFalse(aquariumDao.delete(aquarium.getAquariumId()));
	}
	
	@Test
	public void testDeleteAll() {
		log.info("testDeleteAll");
		aquariumDao.deleteAll();
		Aquarium aquarium1 = new Aquarium();
		aquarium1.setNaam("Aq1");
		aquariumDao.save(aquarium1);
		Aquarium aquarium2 = new Aquarium();
		aquarium2.setNaam("Aq2");
		aquariumDao.save(aquarium2);
		List<Aquarium> l = aquariumDao.getAll();
		assertEquals(l.size(), 2);
		assertTrue(aquariumDao.deleteAll());
		l = aquariumDao.getAll();
		assertEquals(l.size(), 0);
	}
	
}
