package org.biz.dierentuin3;

import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Named("poes")
public class Poes implements IDier {

	private Log log = LogFactory.getLog(Poes.class);

	public String praat() {
		log.info("Miauw!!!");
		return "Miauw!!!";
	}
}
