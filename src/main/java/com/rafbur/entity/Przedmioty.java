package com.rafbur.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Przedmioty {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idPrzedmiotu;
	
	private String nazwa;
	
	@ManyToMany(mappedBy="przedmioty")
	private List<Uczniowie> uczniowie;

	
	public List<Uczniowie> getUczniowie() {
		return uczniowie;
	}


	public void setUczniowie(List<Uczniowie> uczniowie) {
		this.uczniowie = uczniowie;
	}


	public Integer getIdPrzedmiotu() {
		return idPrzedmiotu;
	}
	

	public void setIdPrzedmiotu(Integer idPrzedmiotu) {
		this.idPrzedmiotu = idPrzedmiotu;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
}
