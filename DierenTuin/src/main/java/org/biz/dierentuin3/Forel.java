package org.biz.dierentuin3;

import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Named("forel")
public class Forel implements IDier {

	private Log log = LogFactory.getLog(Forel.class);

	public String praat() {
		log.info("Blub!!!");
		return "Blub!!!";
	}
}
