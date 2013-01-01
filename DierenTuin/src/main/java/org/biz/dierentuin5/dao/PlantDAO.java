package org.biz.dierentuin5.dao;

import javax.inject.Named;

import org.biz.dierentuin5.model.Plant;
import org.springframework.stereotype.Repository;

@Named("plantDao")
@Repository
public class PlantDAO extends AbstractDAO<Plant> {

	public PlantDAO(){
		setClassT(Plant.class);	
	}

}