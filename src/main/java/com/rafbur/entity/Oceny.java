package com.rafbur.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Oceny {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idOceny;
	
	private Integer ocena;
	
	private Integer wagaOceny;
	
	private Integer rokNauki;
	
	private Integer semestr;
	
	@ManyToMany(mappedBy="oceny")
	private List<Uczniowie> uczniowie;

	public List<Uczniowie> getUczniowie() {
		return uczniowie;
	}

	public void setUczniowie(List<Uczniowie> uczniowie) {
		this.uczniowie = uczniowie;
	}

	public Integer getIdOceny() {
		return idOceny;
	}

	public void setIdOceny(Integer idOceny) {
		this.idOceny = idOceny;
	}

	public Integer getOcena() {
		return ocena;
	}

	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}

	public Integer getWagaOceny() {
		return wagaOceny;
	}

	public void setWagaOceny(Integer wagaOceny) {
		this.wagaOceny = wagaOceny;
	}

	public Integer getRokNauki() {
		return rokNauki;
	}

	public void setRokNauki(Integer rokNauki) {
		this.rokNauki = rokNauki;
	}

	public Integer getSemestr() {
		return semestr;
	}

	public void setSemestr(Integer semestr) {
		this.semestr = semestr;
	}
}
