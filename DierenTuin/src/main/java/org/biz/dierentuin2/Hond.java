package org.biz.dierentuin2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Hond implements IDier {

	private Log log = LogFactory.getLog(Hond.class);

	public String praat() {
		log.info("Woef!!!");
		return "Woef!!!";
	}
}
