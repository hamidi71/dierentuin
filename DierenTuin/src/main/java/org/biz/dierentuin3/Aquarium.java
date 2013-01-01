package org.biz.dierentuin3;

import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Named("aquarium")
public class Aquarium {
	
	private Forel forel;
	
	@Autowired
	public Aquarium(Forel forel) {
		this.forel = forel;
	}	
	
	public Forel getForel() {
		return forel;
	}
}
