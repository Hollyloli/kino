package com.rafbur.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafbur.entity.Klasa;
import com.rafbur.entity.Nauczyciele;
import com.rafbur.entity.Przedmioty;
import com.rafbur.entity.Uczniowie;
import com.rafbur.repository.KlasaRepository;
import com.rafbur.repository.NauczycieleRepository;
import com.rafbur.repository.OcenyRepository;
import com.rafbur.repository.PrzedmiotyRepository;
import com.rafbur.repository.UczniowieRepository;
import com.rafbur.repository.UzytkownicyRepository;

@Service
public class NauczycielService {
	
	@Autowired
	private NauczycieleRepository nauczycieleRepository;
	
	@Autowired 
	private PrzedmiotyRepository przedmiotyRepository;
	
	@Autowired
	private KlasaRepository klasaRepository;
	
	@Autowired
	private UczniowieRepository uczniowieRepository;
	
	@Autowired
	private UzytkownicyRepository uzytkownicyRepository;
	
	@Autowired
	private OcenyRepository ocenyRepository;

	public Nauczyciele znajdzPrzedmioty(String login) {
		Nauczyciele nauczyciel = nauczycieleRepository.findByLogin(login);
		List<Przedmioty> przedmioty = przedmiotyRepository.findByNauczyciele(nauczyciel);
		if(przedmioty.size()!=0) {
			nauczyciel.setPrzedmiotyNauczycieli(przedmioty);
		}
		return nauczyciel;
	}

	public Nauczyciele znajdzKlasyIPrzedmiotNaucz(String login, String nazwaPrzedmiotu) {
		Nauczyciele nauczyciel = nauczycieleRepository.findByLogin(login);
		List<Przedmioty> przedmioty = new ArrayList<Przedmioty>();
		przedmioty.add(przedmiotyRepository.findByNazwa(nazwaPrzedmiotu));
		List<Klasa> klasy = klasaRepository.findByNauczyciele(nauczyciel);
		nauczyciel.setPrzedmiotyNauczycieli(przedmioty);
		nauczyciel.setKlasaNauczyciel(klasy);
		return nauczyciel;
	}

	public Nauczyciele znajdzUczniowKlasyIPrzedmiot(String login, String nazwaPrzedmiotu,String[] rokIsymbol) {
		Nauczyciele nauczyciel = nauczycieleRepository.findByLogin(login);
		Klasa klasa = klasaRepository.findByRokAndSymbol(Integer.parseInt(rokIsymbol[0]),rokIsymbol[1]);
		List<Uczniowie> uczniowie2 = uczniowieRepository.findByKlasa(klasa);
		List<Przedmioty> przedmioty = new ArrayList<Przedmioty>();
		przedmioty.add(przedmiotyRepository.findByNazwa(nazwaPrzedmiotu));
		klasa.setUczniowie(uczniowie2);
		List<Klasa> klasy = new ArrayList<Klasa>();
		klasy.add(klasa);
		nauczyciel.setKlasaNauczyciel(klasy);	
		nauczyciel.setPrzedmiotyNauczycieli(przedmioty);
		return nauczyciel;
	}

	public Nauczyciele znajdzNauczyciela(String login) {
		return nauczycieleRepository.findByLogin(login);
	}

	public List<Nauczyciele> znajdzNauczycieli() {
		List<Nauczyciele> nauczyciele = nauczycieleRepository.findAll();
		return nauczyciele;
	}

	public void dopiszPrzedmiotNauczycielowi(String login, String nazwaPrzedmiotu, Integer rok, String symbol) {
		Nauczyciele nauczyciel = nauczycieleRepository.findByLogin(login);
		System.out.println("wypisuje nauczycila " + nauczyciel.getLogin());
		Przedmioty przedmiot = przedmiotyRepository.findByNazwa(nazwaPrzedmiotu);
		List<Przedmioty> przedmioty = przedmiotyRepository.findByNauczyciele(nauczyciel);
		przedmioty.add(przedmiot);
		Klasa klasa = klasaRepository.findByRokAndSymbol(rok, symbol);
		List<Klasa> klasy = new ArrayList<Klasa>();
		klasy.add(klasa);
		nauczyciel.setPrzedmiotyNauczycieli(przedmioty);
		nauczyciel.setKlasaNauczyciel(klasy);
		nauczycieleRepository.saveAndFlush(nauczyciel);
	}
}