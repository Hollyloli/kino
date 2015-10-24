package com.rafbur.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/*musze rozpoznawac po typie roli jestli typ roli jest ROLE_UCZEN to wspisuje login to tabeli 
 *  uczen jesli jest ROLE_nauczyciel wpisuje do tabeli nauczycielale
 * 
 * 
 */

@Entity
public class Uczniowie implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idUcznia;
	
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

	private String login;
	
	public List<Oceny> getOceny() {
		return oceny;
	}

	public void setOceny(List<Oceny> oceny) {
		this.oceny = oceny;
	}

	private String imie;
	
	private String nazwisko;
	
	@ManyToMany
	@JoinTable
	private List<Opiekunowie> opiekunowie;
	
	@ManyToMany
	@JoinTable
	private List<Oceny> oceny;
	
	@ManyToMany
	@JoinTable
	private List<Przedmioty> przedmioty;
	
	@ManyToOne
	@JoinColumn(name="klasa_id")
	private Klasa klasa;
	

	public Klasa getKlasa() {
		return klasa;
	}

	public void setKlasa(Klasa klasa) {
		this.klasa = klasa;
	}

	public List<Opiekunowie> getOpiekunowie() {
		return opiekunowie;
	}

	public void setOpiekunowie(List<Opiekunowie> opiekunowie) {
		this.opiekunowie = opiekunowie;
	}

	public List<Przedmioty> getPrzedmioty() {
		return przedmioty;
	}

	public void setPrzedmioty(List<Przedmioty> przedmioty) {
		this.przedmioty = przedmioty;
	}

	public Integer getIdUcznia() {
		return idUcznia;
	}

	public void setIdUcznia(Integer idUcznia) {
		this.idUcznia = idUcznia;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
