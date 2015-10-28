package com.rafbur.service;

import java.util.ArrayList;
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
			List<Oceny> oceny2 = ocenyRepository.findByPrzedmiotyAndUczniowieAndRokNaukiAndSemestr(przedmiot, uczniowie2.get(i),rokNauki, semestr);
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
	public void dodajKlase(Klasa klasa) {
		klasaRepository.save(klasa);
	}
	public List<Klasa> znjadzWszyskieKlasy() {
		List<Klasa> klasy = klasaRepository.findAll();
		
		return klasy;
	}
	public void dodajUcznia(Uczniowie uczen) {
		String[] rokIsymbol = uczen.getKlasa().getSymbol().split(" ");
		Integer rok = Integer.parseInt(rokIsymbol[0]);
		String symbol = rokIsymbol[1];
		Klasa klasaBaza = klasaRepository.findByRokAndSymbol(rok, symbol);
		
		String[] imieINazwisko = uczen.getImie().split(" ");
		Uczniowie uczenBaza = uczniowieRepository.findByImieAndNazwisko(imieINazwisko[0], imieINazwisko[1]);
		uczenBaza.setKlasa(klasaBaza);
		uczniowieRepository.saveAndFlush(uczenBaza);
		
	}
	public List<Integer> statusOcenPodKoniecRoku(List<Klasa> klasy) {
		List<Integer> statusOcen = new ArrayList<Integer>();
		for (Klasa klasa : klasy) {
			List<Uczniowie> uczniowie = uczniowieRepository.findByKlasa(klasa);
			boolean pojedynczyStatusOcen = false;
			if(uczniowie.size()>0) {
				for (Uczniowie uczen : uczniowie) {
					List<Oceny> oceny = ocenyRepository.findByUczniowieAndRokNauki(uczen, klasa.getRok());
					if(oceny.size()>0) {
						List<Przedmioty> przedmiotyUcznia = przedmiotyRepository.findByUczniowieAndOceny(uczen,oceny.get(0));
						for (Przedmioty przedmiot : przedmiotyUcznia) {
							if(ocenyRepository.findByPrzedmiotyAndUczniowieAndRokNaukiAndTyp(przedmiot, uczen, klasa.getRok(), "koncowa").size()==0) {
								pojedynczyStatusOcen = true;
								break;
							}
						}
					}
					else {
						pojedynczyStatusOcen = true;
					}
					//zrobic kolejnosc
					//zrobic zakonczenie roku szkolnego
				}
			}
			else {
				pojedynczyStatusOcen = true;
			}
			if(pojedynczyStatusOcen) {
				// 1 to nie wszystkie oceny wpisane
				statusOcen.add(new Integer(1));
			}
			else {
				statusOcen.add(new Integer(0));
			}
		}
		return statusOcen;
	}
	public void zakonczRokSzkolny() {
		List<Klasa> klasy = klasaRepository.findAll();
		for (Klasa klasa : klasy) {
			klasa.setRok(klasa.getRok()+1);
			klasaRepository.saveAndFlush(klasa);
		}
	}
}
