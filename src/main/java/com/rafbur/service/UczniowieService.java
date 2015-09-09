package com.rafbur.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafbur.entity.Adresy;
import com.rafbur.entity.Klasa;
import com.rafbur.entity.Oceny;
import com.rafbur.entity.Przedmioty;
import com.rafbur.entity.Uczniowie;
import com.rafbur.entity.Uzytkownicy;
import com.rafbur.repository.AdresyRepository;
import com.rafbur.repository.KlasaRepository;
import com.rafbur.repository.OcenyRepository;
import com.rafbur.repository.PrzedmiotyRepository;
import com.rafbur.repository.UczniowieRepository;
import com.rafbur.repository.UzytkownicyRepository;

@Service
public class UczniowieService {

	@Autowired
	private UczniowieRepository uczniowieRepository;
	
	@Autowired
	private KlasaRepository klasaRepository;
	
	@Autowired
	private PrzedmiotyRepository przedmiotyRepository;
	
	@Autowired
	private OcenyRepository ocenyRepository;
	public Uczniowie znajdzUcznia(String[] imieInazwisko) {
		Uczniowie uczen = uczniowieRepository.findByImieAndNazwisko(imieInazwisko[0], imieInazwisko[1]);
		return uczen;
	}

	public Uczniowie znajdzUczniaZOcenami(String[] imieInazwisko, String nazwaPrzedmiotu) {
		Uczniowie uczen = uczniowieRepository.findByImieAndNazwisko(imieInazwisko[0], imieInazwisko[1]);
		Klasa klasa = klasaRepository.findByUczniowie(uczen);

		Przedmioty przedmiot = przedmiotyRepository.findByNazwa(nazwaPrzedmiotu);
		List<Oceny> ocenaBaza = ocenyRepository.findByPrzedmiotyAndUczniowieAndRokNaukiAndSemestrAndTyp(przedmiot, uczen,klasa.getRok(),new Integer(1), "ukonczono");
		System.out.println("gdzie wywala 2");
		List<Oceny> oceny = new ArrayList<Oceny>();
		if(ocenaBaza == null ) {
			//wypisuje oceny uzytkownika z 1 semestru
			
			oceny = ocenyRepository.findByPrzedmiotyAndUczniowieAndRokNaukiAndSemestrAndTyp(przedmiot, uczen,klasa.getRok(), new Integer(1),"czastkowa");
		}
		else {
			//wypisuje oceny ucznia z 2 semestru
			System.out.println("KURWA MAC DUPA");
			oceny = ocenyRepository.findByPrzedmiotyAndUczniowieAndRokNaukiAndSemestrAndTyp(przedmiot, uczen,klasa.getRok(), new Integer(2),"czastkowa");
			for(int i=0; i<oceny.size(); i++) {
				System.out.println("wagi oceny " + oceny.get(i).getWagaOceny());
			}
		}
		
		uczen.setOceny(oceny);
		return uczen;
	}
	
	
	
}
