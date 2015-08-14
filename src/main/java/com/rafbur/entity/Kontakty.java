package com.rafbur.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Kontakty {
	@Id
	@GeneratedValue
	private Integer idKontaktu;
	
	private String telefon;
	
	private String email;
	
	@ManyToMany(mappedBy="kontakty")
	private List<User> uzytkownicy;

	public List<User> getUzytkownicy() {
		return uzytkownicy;
	}

	public void setUzytkownicy(List<User> uzytkownicy) {
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
