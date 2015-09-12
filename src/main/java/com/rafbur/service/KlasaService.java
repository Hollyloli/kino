package com.rafbur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafbur.entity.Klasa;
import com.rafbur.entity.Oceny;
import com.rafbur.entity.Przedmioty;
import com.rafbur.entity.Uczniowie;
import com.rafbur.repository.KlasaRepository;
import com.rafbur.repository.OcenyRepository;
import com.rafbur.repository.PrzedmiotyRepository;
import com.rafbur.repository.UczniowieRepository;

@Service
public class KlasaService {
	
	@Autowired
	private OcenyRepository ocenyRepository;

	@Autowired
	private PrzedmiotyRepository przedmiotyRepository;

	@Autowired
	private KlasaRepository klasaRepository;
	
	@Autowired
	private UczniowieRepository uczniowieRepository;
	
	public Klasa znajdzOcenyUczniowZroku(Klasa klasa, Integer rokNauki,Integer semestr,String nazwaPrzedmiotu) {
		Klasa klasa2 = klasaRepository.findOne(klasa.getIdKlasy());
		List<Uczniowie> uczniowie2 = uczniowieRepository.findByKlasa(klasa2);
		Przedmioty przedmiot = przedmiotyRepository.findByNazwa(nazwaPrzedmiotu);
		for(int i=0; i<uczniowie2.size(); i++) {
			List<Oceny> oceny2 = ocenyRepository.findByPrzedmiotyAndUczniowieAndRokNaukiAndSemestr(przedmiot, uczniowie2.get(i),klasa.getRok(), semestr);
			System.out.println("wypisuje rozmiar listy ocen " + oceny2.size());
			uczniowie2.get(i).setOceny(oceny2);
		}
		klasa2.setUczniowie(uczniowie2);
		return klasa2;
	}
	public Klasa znajdzOcenyUczniowZroku2(Klasa klasa, Integer rokNauki,Integer semestr,String nazwaPrzedmiotu) {
		Klasa klasa2 = klasaRepository.findOne(klasa.getIdKlasy());
		List<Uczniowie> uczniowie2 = uczniowieRepository.findByKlasa(klasa2);
		Przedmioty przedmiot = przedmiotyRepository.findByNazwa(nazwaPrzedmiotu);
		for(int i=0; i<uczniowie2.size(); i++) {
			List<Oceny> oceny2 = ocenyRepository.findByPrzedmiotyAndUczniowieAndRokNaukiAndSemestrAndTyp(przedmiot, uczniowie2.get(i),klasa.getRok(), semestr,"czastkowa");
			System.out.println("wypisuje rozmiar listy ocen " + oceny2.size());
			uczniowie2.get(i).setOceny(oceny2);
		}
		klasa2.setUczniowie(uczniowie2);
		return klasa2;
	}

	public Klasa znajdzUczniowWKlasie(String nazwaPRzedmiotu, String[] rokIsymbol) {
		Klasa klasa = klasaRepository.findByRokAndSymbol(Integer.parseInt(rokIsymbol[0]),rokIsymbol[1]);
		List<Uczniowie> uczniowie = uczniowieRepository.findByKlasa(klasa);
		klasa.setUczniowie(uczniowie);
		
		return klasa;
	}
	public boolean czyWszyscyMajaOcKoncowa(String nazwaPrzedmiotu, Integer rok, String symbol,String typOceny) {
		Klasa klasa = klasaRepository.findByRokAndSymbol(rok,symbol);
		List<Uczniowie> uczniowie = uczniowieRepository.findByKlasa(klasa);
		Przedmioty przedmiot = przedmiotyRepository.findByNazwa(nazwaPrzedmiotu);
		boolean  czyWszyscyMajaOcenyKoncowe = true;
		for (Uczniowie uczen : uczniowie) {
			Oceny ocenaKoncowa = ocenyRepository.findByUczniowieAndPrzedmiotyAndRokNaukiAndTyp(uczen,przedmiot,rok,typOceny);
			if(ocenaKoncowa==null) { //czyli ktos nie ma oceny
				czyWszyscyMajaOcenyKoncowe = false;
			}
		}
		return czyWszyscyMajaOcenyKoncowe;
	}

	
}
