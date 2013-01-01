package org.biz.dierentuin5.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.biz.dierentuin5.model.Plant;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/dierentuin5.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PlantDAOTest {
	
	private Log log = LogFactory.getLog(PlantDAOTest.class);
	
	@Autowired
	protected PlantDAO plantDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testSave() {
		log.info("testSave");
		plantDao.deleteAll();
		Plant plant = new Plant();
		plant.setNaam("PlantX");
		assertTrue(plantDao.save(plant));
		List<Plant> l = plantDao.find("PlantX");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "PlantX");
	}
	
	@Test
	public void testUpdate() {
		log.info("testUpdate");
		plantDao.deleteAll();
		Plant plant = new Plant();
		plant.setNaam("PlantX");
		assertTrue(plantDao.save(plant));
		List<Plant> l = plantDao.find("PlantX");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "PlantX");	
		plant = l.get(0);
		plant.setNaam("PlantY");
		assertTrue(plantDao.update(plant.getPlantId(), plant));
		l = plantDao.find("PlantY");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "PlantY");			
	}

	//@Test(expected=Exception.class)
	@Test
	public void testUpdateException() {
		log.info("testUpdate");
		plantDao.deleteAll();
		Plant plant = new Plant();
		plant.setNaam("PlantX");
		plantDao.update(plant.getPlantId(), plant);
	}

	
	@Test
	public void testGetAll() {
		log.info("testGetAll");
		plantDao.deleteAll();
		Plant plant1 = new Plant();
		plant1.setNaam("PlantX");
		plantDao.save(plant1);
		Plant plant2 = new Plant();
		plant2.setNaam("PlantY");
		plantDao.save(plant2);
		List<Plant> l = plantDao.getAll();
		for (Plant h : l) {
			log.info("Id = " +  h.getPlantId() + " / Naam : " + h.getNaam());
		}
		assertEquals(l.size(), 2);
		l = plantDao.find("PlantX");
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "PlantX");
	}	
	
	@Test
	public void testDelete() {
		log.info("testDelete");
		plantDao.deleteAll();
		Plant plant = new Plant();
		plant.setNaam("PlantX");
		assertTrue(plantDao.save(plant));
		List<Plant> l = plantDao.find("PlantX");
		assertEquals(l.size(), 1);
		plant = l.get(0);
		assertEquals(plant.getNaam(), "PlantX");
		assertTrue(plantDao.delete(plant.getPlantId()));
		l = plantDao.find("PlantX");
		assertEquals(l.size(), 0);
		assertFalse(plantDao.delete(plant.getPlantId()));
	}
	
	@Test
	public void testDeleteAll() {
		log.info("testDeleteAll");
		plantDao.deleteAll();
		Plant plant1 = new Plant();
		plant1.setNaam("PlantX");
		plantDao.save(plant1);
		Plant plant2 = new Plant();
		plant2.setNaam("PlantY");
		plantDao.save(plant2);
		List<Plant> l = plantDao.getAll();
		assertEquals(l.size(), 2);
		assertTrue(plantDao.deleteAll());
		l = plantDao.getAll();
		assertEquals(l.size(), 0);
	}
	
}
