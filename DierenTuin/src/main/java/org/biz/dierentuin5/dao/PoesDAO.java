package org.biz.dierentuin5.dao;

import javax.inject.Named;

import org.biz.dierentuin5.model.Poes;
import org.springframework.stereotype.Repository;

@Named("poesDao")
@Repository
public class PoesDAO extends AbstractDAO<Poes> {

	public PoesDAO(){
		setClassT(Poes.class);
	}
}