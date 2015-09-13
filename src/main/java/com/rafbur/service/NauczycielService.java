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
		System.out.println("wypisuje login z metody znajdzPrzedmioty " + login);
		Nauczyciele nauczyciel = nauczycieleRepository.findByLogin(login);
		List<Przedmioty> przedmioty = przedmiotyRepository.findByNauczyciele(nauczyciel);
		if(przedmioty.size()!=0) {
			nauczyciel.setPrzedmiotyNauczycieli(przedmioty);
		}
		
//		System.out.println("wypisuje nauczyciela ze " + nauczycieleRepository.findByLogin(login).getLogin());
		
		
		return nauczyciel;
	}

	public Nauczyciele znajdzKlasyIPrzedmiotNaucz(String login, String nazwaPrzedmiotu) {
		Nauczyciele nauczyciel = nauczycieleRepository.findByLogin(login);
		
		List<Przedmioty> przedmioty = new ArrayList<Przedmioty>();
		przedmioty.add(przedmiotyRepository.findByNazwa(nazwaPrzedmiotu));
		
		List<Klasa> klasy = klasaRepository.findByNauczyciele(nauczyciel);
		System.out.println("wypisuje klasy " +klasy.get(0).getRok());
		nauczyciel.setPrzedmiotyNauczycieli(przedmioty);
		nauczyciel.setKlasaNauczyciel(klasy);
//		System.out.println("klasy nauczyciela " + nauczyciel.getKlasaNauczyciel().get(0).getRok());
		return nauczyciel;
	}

	public Nauczyciele znajdzUczniowKlasyIPrzedmiot(String login, String nazwaPrzedmiotu,String[] rokIsymbol) {
		System.out.println("wchodzi w znajdzUczniowKlasyIPrzedmiot");
		Nauczyciele nauczyciel = nauczycieleRepository.findByLogin(login);
		System.out.println("wypisuje rok i wymbol " + rokIsymbol[0]);
		Klasa klasa = klasaRepository.findByRokAndSymbol(Integer.parseInt(rokIsymbol[0]),rokIsymbol[1]);
		List<Uczniowie> uczniowie2 = uczniowieRepository.findByKlasa(klasa);
		List<Przedmioty> przedmioty = new ArrayList<Przedmioty>();
		System.out.println("wypisuje nazwa przedmiotu " +nazwaPrzedmiotu);
		przedmioty.add(przedmiotyRepository.findByNazwa(nazwaPrzedmiotu));
		System.out.println("wypisuje przedmioty " + przedmioty.get(0));
		
		//wydaje sie nie potrzebne
//		for(int i=0; i<uczniowie2.size(); i++) {
//			List<Oceny> oceny2 = ocenyRepository.findByPrzedmiotyAndUczniowie(przedmioty.get(0), uczniowie2.get(i));
//			System.out.println("wypisuje wielkosc listy ocen " + oceny2.size());
//			uczniowie2.get(i).setOceny(oceny2);
//		}
		klasa.setUczniowie(uczniowie2);
		List<Klasa> klasy = new ArrayList<Klasa>();
		klasy.add(klasa);
		nauczyciel.setKlasaNauczyciel(klasy);	
		nauczyciel.setPrzedmiotyNauczycieli(przedmioty);
		System.out.println("wypisuje czy sa jakies klasy " + klasy.size());
		return nauczyciel;
	}

	public Nauczyciele znajdzNauczyciela(String login) {
		return nauczycieleRepository.findByLogin(login);
	}

	public List<Nauczyciele> znajdzNauczycieli() {
		List<Nauczyciele> nauczyciele = nauczycieleRepository.findAll();
		return nauczyciele;
	}

	public void dopiszPrzedmiotNauczycielowi(String login, String nazwaPrzedmiotu) {
		Nauczyciele nauczyciel = nauczycieleRepository.findByLogin(login);
		Przedmioty przedmiot = przedmiotyRepository.findByNazwa(nazwaPrzedmiotu);
		List<Przedmioty> przedmioty = przedmiotyRepository.findByNauczyciele(nauczyciel);
		przedmioty.add(przedmiot);
		
		
		nauczyciel.setPrzedmiotyNauczycieli(przedmioty);
		nauczycieleRepository.saveAndFlush(nauczyciel);
	}


	
}