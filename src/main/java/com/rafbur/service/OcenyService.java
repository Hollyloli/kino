package com.rafbur.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafbur.entity.Adresy;
import com.rafbur.entity.Klasa;
import com.rafbur.entity.Nauczyciele;
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
public class OcenyService {
	
	@Autowired
	private OcenyRepository ocenyRepository;
	
	@Autowired
	private UczniowieRepository uczniowieRepository;

	@Autowired
	private KlasaRepository klasaRepository;
	
	@Autowired
	private PrzedmiotyRepository przedmiotyRepository;
	
	public void zapiszOcene(Uczniowie uczniowie) {
		Oceny ocena = uczniowie.getOceny().get(0);
		ocenyRepository.save(ocena);
	}

	public void zapiszOcene(Uczniowie uczen, Oceny ocena, String nazwaPrzedmiotu) {
		Klasa klasa = klasaRepository.findByUczniowie(uczen);
		Przedmioty przedmiot = przedmiotyRepository.findByNazwa(nazwaPrzedmiotu);
		List<Oceny> ocenaBaza = ocenyRepository.findByPrzedmiotyAndUczniowieAndRokNaukiAndSemestrAndTyp(przedmiot, uczen,klasa.getRok(),new Integer(1), "ukonczono");
		System.out.println("gdzie wywala 2");
		if(ocenaBaza == null ) {
			ocena.setSemestr(new Integer(1));
		}
		else {
			ocena.setSemestr(new Integer(2));
		}
			ocena.setRokNauki(klasa.getRok());
			ocena.setTyp("czastkowa");
			ocenyRepository.save(ocena);
			List<Oceny> oceny = ocenyRepository.findByPrzedmiotyAndUczniowie(przedmiot, uczen);
			
			List<Oceny> ocenyZprzedmiotow = ocenyRepository.findByPrzedmioty(przedmiot);
			oceny.add(ocena);
			Uczniowie uczen1 = uczniowieRepository.findOne(uczen.getIdUcznia());
			
			uczen1.setOceny(oceny);
			uczniowieRepository.saveAndFlush(uczen1);
			ocenyZprzedmiotow.add(ocena);
			przedmiot.setOceny(ocenyZprzedmiotow);
			przedmiotyRepository.saveAndFlush(przedmiot);
	}

	public boolean CzyJestOcenaRoczna(Klasa klasa, Integer rokNauki, Integer semestr, String nazwaPrzedmiotu) {
		Przedmioty przedmiot = przedmiotyRepository.findByNazwa(nazwaPrzedmiotu);
		boolean czyWszyscyMajaOceneSemestralna=true;
		for(int i=0; i<klasa.getUczniowie().size(); i++) {
			if(ocenyRepository.findByPrzedmiotyAndUczniowieAndRokNaukiAndSemestrAndTyp(przedmiot, klasa.getUczniowie().get(i), rokNauki, semestr, "ukonczono") == null) {
				czyWszyscyMajaOceneSemestralna=false;
				break;
			}
		}
		return czyWszyscyMajaOceneSemestralna;
	}

	public void zaaktualizujOCene(Uczniowie uczen, Oceny ocena,String nazwaPrzedmiotu) {
		Oceny ocenaZBazy = ocenyRepository.findOne(ocena.getIdOceny());
		
		ocenaZBazy.setOcena(ocena.getOcena());
		ocenaZBazy.setWagaOceny(ocena.getWagaOceny());
		
		ocenyRepository.saveAndFlush(ocenaZBazy);
		
		
	}
	
	
}
