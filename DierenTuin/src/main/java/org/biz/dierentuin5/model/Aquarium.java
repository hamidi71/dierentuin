package org.biz.dierentuin5.model;

import java.util.List;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Entity
@Table(name = "AQUARIUM")
@NamedQueries( { @NamedQuery(name = "Aquarium.findAll", query = "SELECT a FROM Aquarium a") })
@Named("aquarium")
public class Aquarium {
	
	@Transient
	private Log log = LogFactory.getLog(Hok.class);

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aquariumId;

	private String naam;
	
	public Aquarium() {
	}
	
	@OneToMany(mappedBy="aquarium")
	private List<Forel> forellen;

	@OneToMany(mappedBy="aquarium")
	private List<Plant> planten;

	public int getAquariumId() {
		return aquariumId;
	}

	public void setAquariumId(int aquariumId) {
		this.aquariumId = aquariumId;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public List<Forel> getForellen() {
		return forellen;
	}

	public void setForellen(List<Forel> forellen) {
		this.forellen = forellen;
	}

	public List<Plant> getPlanten() {
		return planten;
	}

	public void setPlanten(List<Plant> planten) {
		this.planten = planten;
	}

}

