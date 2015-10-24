package com.rafbur.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rafbur.annotation.UniqueNazwaKlasy;


@Entity
@UniqueNazwaKlasy(poleRok="rok",poleSymbol="symbol")
public class Klasa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idKlasy;
	
	@NotNull(message="Brak warto�ci w polu rok")
	@Min(value=1, message="Najmniejsza warto�ci musi by� wi�ksza od zera")
	@Max(value=3,message="Najwi�ksza warto�c musi by� mniejsza od czterech")
	private Integer rok;

	@Pattern(regexp="^[A-Z]{1}", message="mo�liwe tylko jedna du�a litera z zakresu od A do Z")
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
