package org.biz.dierentuin;

public class DierenTuin {

	public static void main(String[] args) {
		
		//maak dieren
		Forel forel = new Forel();
		Poes poes = new Poes();
		Hond hond = new Hond();

		//maak dierentuin
		Aquarium aq = new Aquarium(forel);
		Hok hok = new Hok();

		//vul Hok
		hok.setHond(hond);
		hok.setPoes(poes);

		//gebruik dierentuin
		aq.getForel().praat();
		hok.getHond().praat();		
		hok.getPoes().praat();		
	}
}
