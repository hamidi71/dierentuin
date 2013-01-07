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
@Table(name = "FOREL")
@NamedQueries( { @NamedQuery(name = "Forel.findAll", query = "SELECT f FROM Forel f") })
@Named("forel")
public class Forel implements IDier {

	@Transient
	private Log log = LogFactory.getLog(Forel.class);

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int forelId;

	private String naam;
	
	public Forel() {
	}
	
	@ManyToOne
	@JoinColumn(name="aquariumId")
	private Aquarium aquarium;

	
	public int getForelId() {
		return forelId;
	}

	public void setForelId(int forelId) {
		this.forelId = forelId;
	}


	public String getNaam() {
		return naam;
	}


	public void setNaam(String naam) {
		this.naam = naam;
	}


	public Aquarium getAquarium() {
		return aquarium;
	}


	public void setAquarium(Aquarium aquarium) {
		this.aquarium = aquarium;
	}


	public String praat() {
		log.info("Blub!!!");
		return "Blub!!!";
	}
}
