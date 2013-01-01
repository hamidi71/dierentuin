
package org.biz.dierentuin3;

import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Named("hok")
public class Hok {
	
	@Autowired
	private Hond hond;
	@Autowired
	private Poes poes;
		
	public void setHond(Hond hond) {
		this.hond = hond;
	}
	
	public Hond getHond() {
		return hond;
	}

	public void setPoes(Poes poes) {
		this.poes = poes;
	}

	public Poes getPoes() {
		return poes;
	}

}
