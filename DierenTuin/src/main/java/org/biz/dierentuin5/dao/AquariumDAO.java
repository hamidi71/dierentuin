package org.biz.dierentuin5.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.biz.dierentuin5.model.Aquarium;
import org.biz.dierentuin5.model.Forel;
import org.biz.dierentuin5.model.Plant;
import org.springframework.stereotype.Repository;

@Named("aquariumDao")
@Repository
public class AquariumDAO extends AbstractDAO<Aquarium> {
	
	@PersistenceContext
	private EntityManager em;
	
	public AquariumDAO(){
      setClassT(Aquarium.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Forel> getForellen(final Aquarium aquarium) {
		return  em.createQuery(
				"SELECT f FROM Forel f WHERE f.aquarium = :Aquarium ORDER BY f.Naam")
				.setParameter("Aquarium", aquarium).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Plant> getPlanten(final Aquarium aquarium) {
		return  em.createQuery(
				"SELECT p FROM Plant p WHERE p.aquarium = :Aquarium ORDER BY p.Naam")
				.setParameter("Aquarium", aquarium).getResultList();
	}	
	
}