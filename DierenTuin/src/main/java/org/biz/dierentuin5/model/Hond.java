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
import org.springframework.stereotype.Repository;

@Entity
@Table(name = "HOND")
@NamedQueries( { @NamedQuery(name = "Hond.findAll", query = "SELECT h FROM Hond h") })
@Named("hond")
@Repository
public class Hond implements IDier {

	@Transient
	private Log log = LogFactory.getLog(Hond.class);
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int hondId;

	private String naam;
	
	public Hond() {
		log.info("Hond " + getHondId() + " geboren");
	}
	
	@ManyToOne
	@JoinColumn(name="hokId")
	private Hok hok;

	public int getHondId() {
		return hondId;
	}

	public void setHondId(int hondId) {
		this.hondId = hondId;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Hok getHok() {
		return hok;
	}

	public void setHok(Hok hok) {
		this.hok = hok;
	}

	public String praat() {
		log.info("Woef!!!");
		return "Woef!!!";
	}
}
