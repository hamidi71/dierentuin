package org.biz.dierentuin5.dao;

import javax.inject.Named;

import org.biz.dierentuin5.model.Hond;
import org.springframework.stereotype.Repository;

@Named("hondDao")
@Repository
public class HondDAO extends AbstractDAO<Hond> {
	
	public HondDAO(){
		setClassT(Hond.class);
	}

}