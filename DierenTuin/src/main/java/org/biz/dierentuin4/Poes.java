package org.biz.dierentuin4;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Poes implements IDier {

	private Log log = LogFactory.getLog(Poes.class);

	public void praat() {
		log.info("Miauw!!!");
	}
}
