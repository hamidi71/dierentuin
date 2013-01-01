package org.biz.dierentuin2;

public class Aquarium {
	
	private Forel forel;
	private Plant plant;
	
	public Aquarium(Forel forel) {
		this.forel = forel;
	}	
	
	public Forel getForel() {
		return forel;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
		this.plant.groei(10);
	}
}
