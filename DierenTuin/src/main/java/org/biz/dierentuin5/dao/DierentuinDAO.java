package org.biz.dierentuin5.dao;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.biz.dierentuin5.model.Aquarium;
import org.biz.dierentuin5.model.Forel;
import org.biz.dierentuin5.model.Hok;
import org.biz.dierentuin5.model.Hond;
import org.biz.dierentuin5.model.Plant;
import org.biz.dierentuin5.model.Poes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Named("dierentuinDao")
@Repository
public class DierentuinDAO  {
	private Log log = LogFactory.getLog(DierentuinDAO.class);
	
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
	
	@PersistenceContext
	private EntityManager em;
		
	public void vulDierentuin() {
		log.info("vulDierentuin");

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
		plantDao.save(waterplant);		}	
}