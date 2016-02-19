package com.rafbur.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Seans {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idSeansu;
	
	@ManyToOne
	@JoinColumn(name = "film_id")
	private Filmy film;
	
	private Date data;
	
	
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@OneToMany(mappedBy="seans")
	private List<Bilet> bilety;
	
	@ManyToOne
	@JoinColumn(name = "sala_id")
	private Sala sala;

	public Integer getIdSeansu() {
		return idSeansu;
	}

	public void setIdSeansu(Integer idSeansu) {
		this.idSeansu = idSeansu;
	}

	public Filmy getFilm() {
		return film;
	}

	public void setFilm(Filmy film) {
		this.film = film;
	}

	public List<Bilet> getBilety() {
		return bilety;
	}

	public void setBilety(List<Bilet> bilety) {
		this.bilety = bilety;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
}
