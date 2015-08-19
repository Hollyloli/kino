package com.rafbur.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Adresy {
	
	public Integer getIdAdresy() {
		return idAdresy;
	}

	public void setIdAdresy(Integer idAdresy) {
		this.idAdresy = idAdresy;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getNumerMieszkania() {
		return numerMieszkania;
	}

	public void setNumerMieszkania(String numerMieszkania) {
		this.numerMieszkania = numerMieszkania;
	}

	public String getKodPocztowy() {
		return kodPocztowy;
	}

	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	public String getMiasto() {
		return miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idAdresy;
	
	private String ulica;
	
	private String numerMieszkania;
	
	private String kodPocztowy;
	
	@Size(min=3, message="dupa blada")
	private String miasto;
	
	@ManyToMany(mappedBy="adresy")
	private List<Uzytkownicy> uzytkownicy;

	public List<Uzytkownicy> getUzytkownicy() {
		return uzytkownicy;
	}

	public void setUzytkownicy(List<Uzytkownicy> uzytkownicy) {
		this.uzytkownicy = uzytkownicy;
	}
}
