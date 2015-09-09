package com.rafbur.contoler;

import com.rafbur.entity.Nauczyciele;
import com.rafbur.entity.Uczniowie;

public class Polaczone2 {
	
	private Nauczyciele nauczyciel;
	private String wyborCZynnosci;
	private Uczniowie uczen;
	public Uczniowie getUczen() {
		return uczen;
	}
	public void setUczen(Uczniowie uczen) {
		this.uczen = uczen;
	}
	public Nauczyciele getNauczyciel() {
		return nauczyciel;
	}
	public void setNauczyciel(Nauczyciele nauczyciel) {
		this.nauczyciel = nauczyciel;
	}
	public String getWyborCZynnosci() {
		return wyborCZynnosci;
	}
	public void setWyborCZynnosci(String wyborCZynnosci) {
		this.wyborCZynnosci = wyborCZynnosci;
	}
	

}
