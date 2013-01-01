package org.biz.dierentuin4;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Forel implements IDier {

	private Log log = LogFactory.getLog(Forel.class);

	public void praat() {
		log.info("Blub!!!");
	}
}
