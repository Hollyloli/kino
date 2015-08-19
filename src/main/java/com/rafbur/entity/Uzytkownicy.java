package com.rafbur.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Uzytkownicy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idUzytkownika;
	
	
	private String imie;
	
	
	private String nazwisko;

	public List<Kontakty> getKontakty() {
		return kontakty;
	}

	public void setKontakty(List<Kontakty> kontakty) {
		this.kontakty = kontakty;
	}

	public List<Adresy> getAdresy() {
		return adresy;
	}

	public void setAdresy(List<Adresy> adresy) {
		this.adresy = adresy;
	}
	@NotEmpty(message="nie moze byc puste")
	private String login;
	
	private String haslo;
	
	private Date dataUrodzenia;
	
	@ManyToMany
	@JoinTable
	private List<Role> role;
	
	@ManyToMany
	@JoinTable
	private List<Kontakty> kontakty;

	@ManyToMany
	@JoinTable
	private List<Adresy> adresy;
	
	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public Integer getIdUzytkownika() {
		return idUzytkownika;
	}

	public void setIdUzytkownika(Integer idUzytkownika) {
		this.idUzytkownika = idUzytkownika;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}



	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public Date getDataUrodzenia() {
		return dataUrodzenia;
	}

	public void setDataUrodzenia(Date dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}

}
