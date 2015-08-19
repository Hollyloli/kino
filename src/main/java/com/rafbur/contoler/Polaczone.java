package com.rafbur.contoler;


import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.rafbur.entity.Adresy;
import com.rafbur.entity.Kontakty;
import com.rafbur.entity.Uzytkownicy;


public class Polaczone {
	
	@Valid
	public Uzytkownicy getUzytkownicy() {
		return uzytkownicy;
	}
	public void setUzytkownicy(Uzytkownicy uzytkownicy) {
		this.uzytkownicy = uzytkownicy;
	}
	@Valid
	public Adresy getAdresy() {
		return adresy;
	}
	public void setAdresy(Adresy adresy) {
		this.adresy = adresy;
	}
	Uzytkownicy uzytkownicy;
	Adresy adresy;
	Kontakty kontakty;
	public Kontakty getKontakty() {
		return kontakty;
	}
	public void setKontakty(Kontakty kontakty) {
		this.kontakty = kontakty;
	}

}
