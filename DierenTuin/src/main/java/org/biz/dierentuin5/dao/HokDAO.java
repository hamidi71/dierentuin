package org.biz.dierentuin5.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.biz.dierentuin5.model.Hok;
import org.biz.dierentuin5.model.Hond;
import org.biz.dierentuin5.model.Poes;
import org.springframework.stereotype.Repository;

@Named("hokDao")
@Repository
public class HokDAO extends AbstractDAO<Hok> {

	@PersistenceContext
	private EntityManager em;
	   
	public HokDAO(){
		setClassT(Hok.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Hond> getHonden(final Hok hok) {
		return  em.createQuery(
				"SELECT h FROM Hond h WHERE h.hok.hokId = " + hok.getHokId() + " ORDER BY h.naam")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Poes> getPoezen(final Hok hok) {
		return  em.createQuery(
				"SELECT p FROM Poes p WHERE p.hok = :Hok ORDER BY p.naam")
				.setParameter("Hok", hok).getResultList();
	}
	
}