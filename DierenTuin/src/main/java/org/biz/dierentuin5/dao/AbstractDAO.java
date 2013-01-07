package org.biz.dierentuin5.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;


@Transactional
public abstract class AbstractDAO< T > {
	protected Class<T> classT;

	@PersistenceContext
	private EntityManager em;
	    	   
	public void setClassT( final Class<T> classT ){
	   this.classT = classT;
	}
		
	@SuppressWarnings("unchecked")
	public List<T> find(final String naam) {
		return  em.createQuery(
				"SELECT e FROM " + classT.getSimpleName() + " e WHERE e.naam LIKE :Naam")
				.setParameter("Naam", naam).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Query query = em.createNamedQuery(classT.getSimpleName() + ".findAll");
		return (List<T>) query.getResultList(); 
	}

	public boolean save(final T ent) {
		em.persist(ent);
		em.flush();
		return true;
	}	
	
	public boolean update(final int id, final T ent) {
		final T e =  em.find(classT,id);
		if (e == null) return false;
		em.merge(ent);
		em.flush();
		return true;
	}
	
	public boolean delete(final int id) {
		final T e =  em.find(classT,id);
		if (e == null) return false;
		em.remove(e);
		em.flush();
		return true;
	}
	
	public boolean deleteAll() {
		Query query = em.createQuery("Delete from " + classT.getName());
		query.executeUpdate();
		return true;
	}	
}
