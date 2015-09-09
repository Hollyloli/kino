package com.rafbur.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Klasa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idKlasy;
	
	private Integer rok;

	private String symbol;
	
	@OneToMany(mappedBy="klasa")
	private List<Uczniowie> uczniowie;
	
	public List<Nauczyciele> getNauczyciele() {
		return nauczyciele;
	}

	public void setNauczyciele(List<Nauczyciele> nauczyciele) {
		this.nauczyciele = nauczyciele;
	}

	@ManyToMany(mappedBy="klasaNauczyciel")
	private List<Nauczyciele> nauczyciele; 

	public Integer getIdKlasy() {
		return idKlasy;
	}

	public void setIdKlasy(Integer idKlasy) {
		this.idKlasy = idKlasy;
	}

	public Integer getRok() {
		return rok;
	}

	public void setRok(Integer rok) {
		this.rok = rok;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public List<Uczniowie> getUczniowie() {
		return uczniowie;
	}

	public void setUczniowie(List<Uczniowie> uczniowie) {
		this.uczniowie = uczniowie;
	}

	

}
