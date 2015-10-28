package com.rafbur.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafbur.entity.Klasa;
import com.rafbur.entity.Oceny;
import com.rafbur.entity.Opiekunowie;
import com.rafbur.entity.Przedmioty;
import com.rafbur.entity.Uczniowie;
import com.rafbur.repository.KlasaRepository;
import com.rafbur.repository.OcenyRepository;
import com.rafbur.repository.OpiekunowieRepository;
import com.rafbur.repository.PrzedmiotyRepository;
import com.rafbur.repository.UczniowieRepository;

@Service
public class UczniowieService {

	@Autowired
	private UczniowieRepository uczniowieRepository;
	
	@Autowired
	private KlasaRepository klasaRepository;
	
	@Autowired
	private PrzedmiotyRepository przedmiotyRepository;
	
	@Autowired
	private OpiekunowieRepository opiekunowieRepository;
	
	@Autowired
	private OcenyRepository ocenyRepository;
	public Uczniowie znajdzUcznia(String[] imieInazwisko) {
		Uczniowie uczen = uczniowieRepository.findByImieAndNazwisko(imieInazwisko[0], imieInazwisko[1]);
		return uczen;
	}
	
	public boolean sprawdzCzyjestOcSemLubKon(Uczniowie uczen, Przedmioty przedmiot,Integer rok, String typOceny) {
		List<Oceny> ocenaSemLubRocz = ocenyRepository.findByPrzedmiotyAndUczniowieAndRokNaukiAndTyp(przedmiot, uczen, rok, typOceny);
		System.out.println("wypisuje rozmiar oceny " + ocenaSemLubRocz.size());
		System.out.println("wypisuje rozmiar oceny semestralnej " +ocenaSemLubRocz.size());
		if(ocenaSemLubRocz.size() != 0 ) {
			return true;
		}
		else {
			return false;
		}
	}

	public Uczniowie znajdzUczniaZOcenami(Uczniowie uczen,Przedmioty przedmiot, Integer rok, Integer semestr) {
		List<Oceny> oceny = new ArrayList<Oceny>();
		oceny = ocenyRepository.findByPrzedmiotyAndUczniowieAndRokNaukiAndSemestrAndTyp(przedmiot, uczen,rok, semestr,"czastkowa");
		uczen.setOceny(oceny);
		return uczen;
	}

	public List<Uczniowie> znajdzUczniowBezKlasy() {
		Klasa klasa = null;
		List<Uczniowie> uczniowie = uczniowieRepository.findByKlasa(klasa);
		
		System.out.println("wypisuje ilosc uczniow " + uczniowie.size());
		
		return uczniowie;
	}

	public List<Uczniowie> znajdzWszystkichUczniow() {
		List<Uczniowie> uczniowie = uczniowieRepository.findAll();
		return uczniowie;
	}

	public void dopiszPrzedmiotUcznowi(String login, String nazwaPrzedmiotu) {
		Uczniowie uczen = uczniowieRepository.findByLogin(login);
		Przedmioty przedmiot = przedmiotyRepository.findByNazwa(nazwaPrzedmiotu);
		List<Przedmioty> przedmioty = przedmiotyRepository.findByUczniowie(uczen);
		przedmioty.add(przedmiot);
		uczen.setPrzedmioty(przedmioty);
		uczniowieRepository.saveAndFlush(uczen);
	}

	public List<String> lataISemestryZWpisanymiOcenami(String login) {
		Uczniowie uczen = uczniowieRepository.findByLogin(login);
		List<String> lataIsemestryZOcenami = new ArrayList<String>();
		for(int i=1; i<4; i++) {
			for(int j=1; j<3; j++) {
				if (ocenyRepository.findByUczniowieAndRokNaukiAndSemestr(uczen, i, j).size()==0) {
					return lataIsemestryZOcenami;
				}
				else {
					lataIsemestryZOcenami.add("rok " + i + " semestr " + j);
				}
			}
		}
		return lataIsemestryZOcenami;
	}

	public Map<Przedmioty, List<Oceny>> znajdzOcenyUcznia(String login,int rok, int semestr) {
		Uczniowie uczen = uczniowieRepository.findByLogin(login);
		List<Przedmioty> przedmiotyUcznia = przedmiotyRepository.findByUczniowie(uczen);
		Map<Przedmioty, List<Oceny>> mapa = new HashMap<Przedmioty, List<Oceny>>();
		for (Przedmioty przedmiot : przedmiotyUcznia) {
			mapa.put(przedmiot, ocenyRepository.findByPrzedmiotyAndUczniowieAndRokNaukiAndSemestr(przedmiot, uczen, rok, semestr));
		}
		return mapa;
	}

	public void przypiszOpiekunaDziecku(String loginOpiekuna, String loginDziecka) {
		List<Opiekunowie> opiekunowie = new ArrayList<Opiekunowie>();
		Uczniowie uczen = uczniowieRepository.findByLogin(loginDziecka);
		Opiekunowie opiekun = opiekunowieRepository.findByLogin(loginOpiekuna);
		opiekunowie.add(opiekun);
		uczen.setOpiekunowie(opiekunowie);
		uczniowieRepository.saveAndFlush(uczen);
	}
}
