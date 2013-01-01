package org.biz.dierentuin5.dao;

import javax.inject.Named;

import org.biz.dierentuin5.model.Forel;
import org.springframework.stereotype.Repository;

@Named("forelDao")
@Repository
public class ForelDAO  extends AbstractDAO<Forel> {
	
	public ForelDAO(){
		setClassT(Forel.class);
	}

}