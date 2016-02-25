package com.rafbur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafbur.entity.Kontakty;
import com.rafbur.entity.Uzytkownicy;
import com.rafbur.repository.KontaktyRepository;
import com.rafbur.repository.UzytkownicyRepository;

@Service
public class KontaktyService {

	@Autowired
	private UzytkownicyRepository uzytkownicyRepository;
	
	@Autowired
	private KontaktyRepository kontaktyRepository;
	
	public void delete(int id, String login) {
		Uzytkownicy uzytkownik = uzytkownicyRepository.findByLogin(login);
		List<Kontakty> kontakty = kontaktyRepository.findByUzytkownicy(uzytkownik);
		Kontakty kontaktDousuniecia = kontaktyRepository.findOne(id);
		int indeksKontaktuDoUsuniecia = 0;
		for(int i=0; i<kontakty.size(); i++) {
			if(kontakty.get(i).getIdKontaktu()==kontaktDousuniecia.getIdKontaktu()) {
				indeksKontaktuDoUsuniecia=i;
				break;
			}
		}
		kontakty.remove(indeksKontaktuDoUsuniecia);
		uzytkownik.setKontakty(kontakty);
		uzytkownicyRepository.saveAndFlush(uzytkownik);
		kontaktyRepository.delete(id);
	}

	public void save(Uzytkownicy uzytkownikDane, String login) {
		Uzytkownicy uzytkownik = uzytkownicyRepository.findByLogin(login);
		List<Kontakty> kontakty = kontaktyRepository.findByUzytkownicy(uzytkownik);
		kontakty.add(uzytkownikDane.getKontakty().get(0));
		uzytkownik.setKontakty(kontakty);
		kontaktyRepository.save(kontakty);
		uzytkownicyRepository.save(uzytkownik);
	}
	
	
}
