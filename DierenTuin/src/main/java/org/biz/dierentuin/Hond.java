package org.biz.dierentuin;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Hond implements IDier {

	private Log log = LogFactory.getLog(Hond.class);
	
	public Hond() {
	}

	public String praat() {
		log.info("Woef!!!");
		return "Woef!!!";
	}
}
