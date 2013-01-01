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
@Table(name = "POES")
@NamedQueries( { @NamedQuery(name = "Poes.findAll", query = "SELECT p FROM Poes p") })
@Named("poes")
public class Poes implements IDier {

	@Transient
	private Log log = LogFactory.getLog(Poes.class);

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int poesId;

	private String Naam;
	
	public Poes() {
	}
	
	@ManyToOne
	@JoinColumn(name="hokId")
	private Hok hok;
	
	public int getPoesId() {
		return poesId;
	}

	public void setPoesId(int poesId) {
		this.poesId = poesId;
	}

	public String getNaam() {
		return Naam;
	}

	public void setNaam(String naam) {
		Naam = naam;
	}

	public Hok getHok() {
		return hok;
	}

	public void setHok(Hok hok) {
		this.hok = hok;
	}

	public String praat() {
		log.info("Miauw!!!");
		return "Miauw!!!";
	}
	
}
