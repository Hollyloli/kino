package com.rafbur.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bilet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idBiletu;
	
	@ManyToOne
	@JoinColumn(name = "seans_id")
	private Seans seans;
	
	public Integer getIdBiletu() {
		return idBiletu;
	}

	public void setIdBiletu(Integer idBiletu) {
		this.idBiletu = idBiletu;
	}

	public Seans getSeans() {
		return seans;
	}

	public void setSeans(Seans seans) {
		this.seans = seans;
	}

	public Uzytkownicy getUzytkownik() {
		return uzytkownik;
	}

	public void setUzytkownik(Uzytkownicy uzytkownik) {
		this.uzytkownik = uzytkownik;
	}

	@ManyToOne
	@JoinColumn(name = "uzytkownik_id")
	private Uzytkownicy uzytkownik;
}