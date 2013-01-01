package org.biz.dierentuin5.model;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Entity
@Table(name = "PLANT")
@NamedQueries( { @NamedQuery(name = "Plant.findAll", query = "SELECT p FROM Plant p") })
@Named("plant")
public class Plant {

	@Transient
	private Log log = LogFactory.getLog(Plant.class);
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int plantId;

	private String Naam;
	
	private int size; 
		
	@ManyToOne
	@JoinColumn(name="aquariumId")
	private Aquarium aquarium;
	
	
	public Plant() {
		this.size = 0;
	}
	
	public Plant(int size) {
		this.size = size;
	}

	public void praat() {
		log.info("Stilte!!!");
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void groei(int size) {
		this.size = this.size + size;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public String getNaam() {
		return Naam;
	}

	public void setNaam(String naam) {
		Naam = naam;
	}

	public Aquarium getAquarium() {
		return aquarium;
	}

	public void setAquarium(Aquarium aquarium) {
		this.aquarium = aquarium;
	}

}
