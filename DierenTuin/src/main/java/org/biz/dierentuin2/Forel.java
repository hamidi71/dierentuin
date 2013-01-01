package org.biz.dierentuin2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Forel implements IDier {

	private Log log = LogFactory.getLog(Forel.class);

	public String praat() {
		log.info("Blub!!!");
		return "Blub!!!";
	}
}
