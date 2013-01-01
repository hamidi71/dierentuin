package org.biz.dierentuin4;

public class VierVoeter {
	
	private IDier dier;
	
	public VierVoeter(IDier dier) {
		this.dier = dier;
	}
		
	public void praat() {
		dier.praat();
	}
}
