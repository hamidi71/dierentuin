package org.biz.dierentuin4;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Hond implements IDier {

	private Log log = LogFactory.getLog(Hond.class);

	public void praat() {
		log.info("Woef!!!");
	}
}
