package com.rafbur.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Miejsce implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idMiejsca;
	
	@NotNull(message="brak numeru miejsca")
	@Min(value=1,message="Ilosc miejsc w rzedzie nie moze byc mniejsza niz 0")
	@Max(value=15,message="Ilosc miesc w rzedzie nie moze byc wieksza niz 15")
	private Integer numerMiejsca;
	
	private Boolean zajetoscMiejsca;
	
	public Boolean getZajetoscMiejsca() {
		return zajetoscMiejsca;
	}

	public void setZajetoscMiejsca(Boolean zajetoscMiejsca) {
		this.zajetoscMiejsca = zajetoscMiejsca;
	}

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
