package com.rafbur.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/*musze rozpoznawac po typie roli jestli typ roli jest ROLE_UCZEN to wspisuje login to tabeli 
 *  uczen jesli jest ROLE_nauczyciel wpisuje do tabeli nauczycielale
 * 
 * 
 */

@Entity
public class Nauczyciele {
	

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idNauczyciela;
	
	private String login;
	
	@ManyToMany
	@JoinTable
	private List<Klasa> klasaNauczyciel;
	
	@ManyToMany
	@JoinTable
	private List<Przedmioty> przedmiotyNauczycieli;

	public Integer getIdNauczyciela() {
		return idNauczyciela;
	}

	public void setIdNauczyciela(Integer idNauczyciela) {
		this.idNauczyciela = idNauczyciela;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Klasa> getKlasaNauczyciel() {
		return klasaNauczyciel;
	}

	public void setKlasaNauczyciel(List<Klasa> klasaNauczyciel) {
		this.klasaNauczyciel = klasaNauczyciel;
	}

	public List<Przedmioty> getPrzedmiotyNauczycieli() {
		return przedmiotyNauczycieli;
	}

	public void setPrzedmiotyNauczycieli(List<Przedmioty> przedmiotyNauczycieli) {
		this.przedmiotyNauczycieli = przedmiotyNauczycieli;
	}
}
