package org.biz.dierentuin3;

import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Named("hond")
public class Hond implements IDier {

	private Log log = LogFactory.getLog(Hond.class);

	public String praat() {
		log.info("Woef!!!");
		return "Woef!!!";
	}
}
