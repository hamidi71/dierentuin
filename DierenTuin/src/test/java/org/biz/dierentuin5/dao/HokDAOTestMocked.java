package org.biz.dierentuin5.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.biz.dierentuin5.model.Hok;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HokDAOTestMocked {
	
	private Log log = LogFactory.getLog(HokDAOTestMocked.class);

	@Mock private EntityManager em;
	@Mock private Query query;
	
	@InjectMocks protected HokDAO hokDao;

	@Test
	public void testSave() {
		log.info("testSave");

		//Stel reactie in voor find() query
		List<Hok> lst = new ArrayList<Hok>();
		Hok h = new Hok();
		h.setNaam("Hok1");
		lst.add(h);
		assertEquals(lst.size(), 1);
		String naam = "Hok1";
		when(em.createQuery("SELECT e FROM Hok e WHERE e.Naam LIKE :Naam")).thenReturn(query);
		when(query.setParameter("Naam", naam)).thenReturn(query);
		when(query.getResultList()).thenReturn(lst);
		
		//Voer save uit
		Hok hok = new Hok();
		hok.setNaam("Hok1");
		assertTrue(hokDao.save(hok));

		//Test save middels find() van het opgeslagen object
		List<Hok> l = hokDao.find("Hok1");		
		assertEquals(l.size(), 1);
		assertEquals(l.get(0).getNaam(), "Hok1");

		//Verifieer of de JPA queries zijn aangeroepen
		verify(em).persist(hok);
		verify(em).createQuery("SELECT e FROM Hok e WHERE e.Naam LIKE :Naam");
	}
		
}
