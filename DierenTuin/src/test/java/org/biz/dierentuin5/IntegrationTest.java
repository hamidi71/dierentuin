package org.biz.dierentuin5;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.biz.dierentuin5.dao.AquariumDAO;
import org.biz.dierentuin5.dao.ForelDAO;
import org.biz.dierentuin5.dao.HokDAO;
import org.biz.dierentuin5.dao.HondDAO;
import org.biz.dierentuin5.dao.PlantDAO;
import org.biz.dierentuin5.dao.PoesDAO;
import org.biz.dierentuin5.model.Aquarium;
import org.biz.dierentuin5.model.Forel;
import org.biz.dierentuin5.model.Hok;
import org.biz.dierentuin5.model.Hond;
import org.biz.dierentuin5.model.Plant;
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
public class IntegrationTest {
	
	private Log log = LogFactory.getLog(IntegrationTest.class);
	
	@Autowired protected HokDAO hokDao;
	@Autowired protected AquariumDAO aquariumDao;
	@Autowired protected HondDAO hondDao;
	@Autowired protected PoesDAO poesDao;
	@Autowired protected ForelDAO forelDao;
	@Autowired protected PlantDAO plantDao;
	
	Hok hok1, hok2;
	Hond pluto, fikkie;
	Poes minoes, minet;
	Aquarium aq1;
	Forel bluppie;
	Plant waterplant;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void integrationTest() {
		log.info("integrationTest");
		VulDatabase();
		
		log.info("====== Lijst Forellen in Aquarium " + aq1.getNaam() + " =========");
		List<Forel> forellen = aquariumDao.getForellen(aq1);
		for (Forel f: forellen) {
			log.info("Forel Id = " + f.getForelId() + " /  Naam = " + f.getNaam());
		}
		assertEquals("Bluppie", forellen.get(0).getNaam());

		log.info("====== Lijst Planten in Aquarium " + aq1.getNaam() + " =========");
		List<Plant> planten = aquariumDao.getPlanten(aq1);
		for (Plant p: planten) {
			log.info("Plant Id = " + p.getPlantId() + " /  Naam = " + p.getNaam());
		}
		assertEquals("Waterplant", planten.get(0).getNaam());
		
		log.info("====== Lijst Honden in Hok " + hok1.getNaam() + " =========");
		List<Hond> honden = hokDao.getHonden(hok1);
		for (Hond h: honden) {
			log.info("Hond Id = " + h.getHondId() + " /  Naam = " + h.getNaam());
		}		
		assertEquals("Fikkie", honden.get(0).getNaam());
		assertEquals("Pluto", honden.get(1).getNaam());
		
		log.info("====== Lijst Poezen in Hok " + hok1.getNaam() + " =========");
		List<Poes> poezen = hokDao.getPoezen(hok1);
		for (Poes p: poezen) {
			log.info("Poes Id = " + p.getPoesId() + " /  Naam = " + p.getNaam());
		}		
		assertEquals("Minet", poezen.get(0).getNaam());
		assertEquals("Minoes", poezen.get(1).getNaam());		
	}	
	
	void VulDatabase() {
		hokDao.deleteAll();
		hok1 = new Hok();
		hok1.setNaam("Hok1");
		hokDao.save(hok1);
		hok2 = new Hok();
		hok2.setNaam("Hok2");
		hokDao.save(hok2);
		
		pluto = new Hond();
		pluto.setNaam("Pluto");
		pluto.setHok(hok1);
		hondDao.save(pluto);

		fikkie = new Hond();
		fikkie.setNaam("Fikkie");
		fikkie.setHok(hok1);
		hondDao.save(fikkie);

		minet = new Poes();
		minet.setNaam("Minet");
		minet.setHok(hok1);
		poesDao.save(minet);

		minoes = new Poes();
		minoes.setNaam("Minoes");
		minoes.setHok(hok1);
		poesDao.save(minoes);

		aquariumDao.deleteAll();
		aq1 = new Aquarium();
		aq1.setNaam("Aquarium1");
		aquariumDao.save(aq1);
		
		bluppie  = new Forel();
		bluppie.setNaam("Bluppie");
		bluppie.setAquarium(aq1);
		forelDao.save(bluppie);
		
		waterplant = new Plant();
		waterplant.setNaam("Waterplant");
		waterplant.setAquarium(aq1);
		plantDao.save(waterplant);		
	}
}
