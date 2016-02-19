package com.rafbur.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Filmy {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idFilmu;	
	
	private String tytulFilmu;
	
	private Integer dlugsc;

	@OneToMany(mappedBy="film")
	private List<Seans> seanse;
	
	public Integer getIdFilmu() {
		return idFilmu;
	}

	public void setIdFilmu(Integer idFilmu) {
		this.idFilmu = idFilmu;
	}

	public String getTytulFilmu() {
		return tytulFilmu;
	}

	public void setTytulFilmu(String tytulFilmu) {
		this.tytulFilmu = tytulFilmu;
	}

	public Integer getDlugsc() {
		return dlugsc;
	}

	public void setDlugsc(Integer dlugsc) {
		this.dlugsc = dlugsc;
	}
	
	
}
