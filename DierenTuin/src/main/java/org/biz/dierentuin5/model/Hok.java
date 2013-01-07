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
@Table(name = "HOK")
@NamedQueries( { @NamedQuery(name = "Hok.findAll", query = "SELECT h FROM Hok h") })
@Named("hok")
public class Hok {
	
	@Transient
	private Log log = LogFactory.getLog(Hok.class);

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int hokId;

	private String naam;
	
	public Hok() {
	}
	
	@OneToMany(mappedBy="hok")
	private List<Hond> honden;

	@OneToMany(mappedBy="hok")
	private List<Poes> poezen;


	public int getHokId() {
		return hokId;
	}

	public void setHokId(int hokId) {
		this.hokId = hokId;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public List<Hond> getHonden() {
		return honden;
	}

	public void setHonden(List<Hond> honden) {
		this.honden = honden;
	}

	public List<Poes> getPoezen() {
		return poezen;
	}

	public void setPoezen(List<Poes> poezen) {
		this.poezen = poezen;
	}
	
}
