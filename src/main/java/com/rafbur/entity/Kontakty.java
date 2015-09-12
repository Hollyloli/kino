package com.rafbur.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

@Entity
public class Kontakty {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idKontaktu;
	
	@Pattern(regexp="^([0-9]{9})", message="Niepoprawny numer telefonu")
	private String telefon;
	
	@Email(message="Niepoprawny emial")
	private String email;
	
	@ManyToMany(mappedBy="kontakty")
	private List<Uzytkownicy> uzytkownicy;

	public List<Uzytkownicy> getUzytkownicy() {
		return uzytkownicy;
	}

	public void setUzytkownicy(List<Uzytkownicy> uzytkownicy) {
		this.uzytkownicy = uzytkownicy;
	}

	public Integer getIdKontaktu() {
		return idKontaktu;
	}

	public void setIdKontaktu(Integer idKontaktu) {
		this.idKontaktu = idKontaktu;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
