package org.biz.dierentuin;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Poes implements IDier {

	private Log log = LogFactory.getLog(Poes.class);

	public String praat() {
		log.info("Miauw!!!");
		return "Miauw!!!";
	}
}
