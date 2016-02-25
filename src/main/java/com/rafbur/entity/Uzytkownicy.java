package com.rafbur.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Uzytkownicy implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idUzytkownika;	
	
	@Size(min=4, message="login jest za krótki")
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="Login u¿ytkownika nie mo¿e zawieraæ spacji")
	private String login;	
	@Pattern(regexp="^[a-zA-Z]+$", message="Imie nie moze zawieraæ cyfr lub spacji")
	@Size(min=3,max=20, message="Niepoprawna d³ugoœæ imienia")
	private String imie;	
	@Pattern(regexp="^[a-zA-Z]+$", message="Nazwisko nie moze zawieraæ cyfr lub spacji")
	@Size(min=2, max=15, message="Niepoprawna d³ugoœæ nazwiska")
	private String nazwisko;	
	@Size(min=4, message="Haslo nie moze byæ krótsze ni¿ 4 znaki")
	private String haslo;
	@ManyToMany
	@JoinTable
	@Valid
	private List<Kontakty> kontakty;
	@ManyToMany
	@JoinTable
	@Valid
	private List<Adresy> adresy;	
	@ManyToMany
	@JoinTable
	private List<Role> role;
	
	public List<Bilet> getBilety() {
		return bilety;
	}

	public void setBilety(List<Bilet> bilety) {
		this.bilety = bilety;
	}

	@OneToMany(mappedBy="uzytkownik")
	private List<Bilet> bilety;
	
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

}
