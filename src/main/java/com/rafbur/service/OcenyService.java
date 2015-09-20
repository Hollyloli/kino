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
		if(ocenaBaza.size() == 0 ) {
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
			System.out.println("rozmiar klasy " + klasa.getUczniowie().size());
			if(ocenyRepository.findByPrzedmiotyAndUczniowieAndRokNaukiAndSemestrAndTyp(przedmiot, klasa.getUczniowie().get(i), rokNauki, semestr, "ukonczono").size()==0) {
				czyWszyscyMajaOceneSemestralna=false;
				break;
			}
		}
		return czyWszyscyMajaOceneSemestralna;
	}

	public void zaaktualizujOCene(Oceny ocena) {
		Oceny ocenaZBazy = ocenyRepository.findOne(ocena.getIdOceny());
		
		ocenaZBazy.setOcena(ocena.getOcena());
		ocenaZBazy.setWagaOceny(ocena.getWagaOceny());
		
		ocenyRepository.saveAndFlush(ocenaZBazy);
		
		
	}

	public void usunOcene(Integer idOceny,Uczniowie uczen, String nazwaPrzedmiotu) {
		Uczniowie uczenBaza = uczniowieRepository.findByImieAndNazwisko(uczen.getImie(), uczen.getNazwisko());
		
		System.out.println("wypisuje rok i semest " + uczen.getOceny().get(0).getRokNauki()+" " + uczen.getOceny().get(0).getSemestr());
		Przedmioty przedmiot = przedmiotyRepository.findByNazwa(nazwaPrzedmiotu);
		List<Oceny> ocenyZPrzedmiotu = ocenyRepository.findByPrzedmioty(przedmiot);
		for(int i = 0; i<ocenyZPrzedmiotu.size(); i++) {
			if(ocenyZPrzedmiotu.get(i).getIdOceny().equals(idOceny)) {
				ocenyZPrzedmiotu.remove(i);
			}
		}
		przedmiot.setOceny(ocenyZPrzedmiotu);
		przedmiotyRepository.saveAndFlush(przedmiot);
		List<Oceny> ocenyUczniow = ocenyRepository.findByUczniowieAndRokNaukiAndSemestr(uczenBaza, 1, 1);
		System.out.println("wypisuje rozmiar ocen uczniow " + ocenyUczniow.size());
		for(int i = 0; i<ocenyUczniow.size(); i++) {
			
			if(ocenyUczniow.get(i).getIdOceny().equals(idOceny)) {
				System.out.println("wypisuje id usuwanej oceny " + idOceny);
				ocenyUczniow.remove(i);
			}
		}
		uczenBaza.setOceny(ocenyUczniow);
		uczniowieRepository.saveAndFlush(uczenBaza);
		ocenyRepository.delete(idOceny);
		
	}

	public Uczniowie wystawOceneKoncowa(Uczniowie uczen, Oceny ocena,String nazwaPrzedmiotu) {
		Przedmioty przedmiot = przedmiotyRepository.findByNazwa(nazwaPrzedmiotu);
		System.out.println("wypisuje semestr i rok " + uczen.getOceny().get(0).getRokNauki() + " " + uczen.getOceny().get(0).getSemestr());

		Uczniowie uczenBaza = uczniowieRepository.findOne(uczen.getIdUcznia());
		
		Oceny ocenaKoncowa = new Oceny();
		
		ocenaKoncowa.setOcena(ocena.getOcena());
		ocenaKoncowa.setRokNauki(uczen.getOceny().get(0).getRokNauki());
		ocenaKoncowa.setSemestr(uczen.getOceny().get(0).getSemestr());
		ocenaKoncowa.setTyp("koncowa");
		ocenyRepository.save(ocenaKoncowa);

		List<Oceny> ocenyUcznia = ocenyRepository.findByUczniowie(uczenBaza);
		List<Oceny> ocenyZprzedmiotow = ocenyRepository.findByPrzedmioty(przedmiot);
		System.out.println("wypisuje ilosc ocen  " + ocenyUcznia.size());
		
		ocenyUcznia.add(ocenaKoncowa);
		uczenBaza.setOceny(ocenyUcznia);
		
		uczniowieRepository.saveAndFlush(uczenBaza);
		
		
		ocenyZprzedmiotow.add(ocenaKoncowa);
		przedmiot.setOceny(ocenyZprzedmiotow);	
		
		przedmiotyRepository.saveAndFlush(przedmiot);
		
		uczen.getOceny().add(ocenaKoncowa);
		return uczen;
		
	}
	
	
}
