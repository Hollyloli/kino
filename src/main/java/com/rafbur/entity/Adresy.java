package com.rafbur.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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

	public Integer getNumerMieszkania() {
		return numerMieszkania;
	}

	public void setNumerMieszkania(Integer numerMieszkania) {
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
	
	@Size(min=4,max=25, message="D³ugoœæ ulicy jest za któtka")
	private String ulica;
	
	@NotNull(message="Brak numeru mieszkania")
	@Min(value=0,message="Numer mieszkania mniejszy od 0")
	private Integer numerMieszkania;
	
	@Pattern(regexp="^([0-9]{2})(-[0-9]{3})", message="Niepoprawny format kodu pocztowego")
	private String kodPocztowy;
	
	@Size(min=3,max=20, message="d³ugoœc miasta jest za krótka")
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
