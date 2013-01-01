package org.biz.dierentuin2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Plant {

	private Log log = LogFactory.getLog(Plant.class);
	private int size; 
	
	public Plant() {
		this.size = 0;
	}
	
	public Plant(int size) {
		this.size = size;
	}

	public void praat() {
		log.info("Stilte!!!");
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void groei(int size) {
		this.size = this.size + size;
	}

}
