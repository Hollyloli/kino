package com.rafbur.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Miejsce {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idMiejsca;
	
	private Integer numerMiejsca;
	
	public Integer getIdMiejsca() {
		return idMiejsca;
	}

	public void setIdMiejsca(Integer idMiejsca) {
		this.idMiejsca = idMiejsca;
	}

	public Integer getNumerMiejsca() {
		return numerMiejsca;
	}

	public void setNumerMiejsca(Integer numerMiejsca) {
		this.numerMiejsca = numerMiejsca;
	}

	public Rzad getRzad() {
		return rzad;
	}

	public void setRzad(Rzad rzad) {
		this.rzad = rzad;
	}

	@ManyToOne
	@JoinColumn(name = "rzad_id")
	private Rzad rzad;
	
}
