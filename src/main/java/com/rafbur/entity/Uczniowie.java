package com.rafbur.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/*musze rozpoznawac po typie roli jestli typ roli jest ROLE_UCZEN to wspisuje login to tabeli 
 *  uczen jesli jest ROLE_nauczyciel wpisuje do tabeli nauczycielale
 * 
 * 
 */

@Entity
public class Uczniowie {
	

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idUcznia;
	
	private String login;
	
	@ManyToMany
	@JoinTable
	private List<Opiekunowie> opiekunowie;
	
	@ManyToMany
	@JoinTable
	private List<Oceny> oceny;
	
	@ManyToMany
	@JoinTable
	private List<Przedmioty> przedmioty;
	

	public List<Opiekunowie> getOpiekunowie() {
		return opiekunowie;
	}

	public void setOpiekunowie(List<Opiekunowie> opiekunowie) {
		this.opiekunowie = opiekunowie;
	}

	public List<Oceny> getOceny() {
		return oceny;
	}

	public void setOceny(List<Oceny> oceny) {
		this.oceny = oceny;
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
