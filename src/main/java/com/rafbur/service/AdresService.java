package com.rafbur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafbur.entity.Adresy;
import com.rafbur.entity.Uzytkownicy;
import com.rafbur.repository.AdresyRepository;
import com.rafbur.repository.UzytkownicyRepository;

@Service
public class AdresService {
	
	@Autowired
	private AdresyRepository adresyRepository;
	
	@Autowired
	private UzytkownicyRepository uzytkownicyRepository;

	
	public void delete(int id, String login) {
		System.out.println("wypisuje id " +id);
		Uzytkownicy uzytkownik = uzytkownicyRepository.findByLogin(login);
		List<Adresy> adresy = adresyRepository.findByUzytkownicy(uzytkownik);
		// tu jest blad
		Adresy adresDousuniecia = adresyRepository.findOne(id);
		
		System.out.println(" adres do usuniecia " +adresDousuniecia.getUlica());
		System.out.println(" id do usuniecia " + adresDousuniecia.getIdAdresy());
		int cos=0;
		for(int i=0; i<adresy.size(); i++)
		{
			if(adresy.get(i).getIdAdresy()==adresDousuniecia.getIdAdresy()) {
				cos=i;
				break;
			}
		}
		System.out.println("zwraca index " + cos);
		
		System.out.println("wypisuje rozmiar adresow " + adresy.size());
		adresy.remove(cos);
		System.out.println("wypisuje rozmiar adresow " + adresy.size());
		uzytkownik.setAdresy(adresy);
		uzytkownicyRepository.saveAndFlush(uzytkownik);
		
		adresyRepository.delete(id);
	}
	
	public void save(Uzytkownicy uzytkownikDane, String login) {
		Uzytkownicy uzytkownik = uzytkownicyRepository.findByLogin(login);
		List<Adresy> adresy = adresyRepository.findByUzytkownicy(uzytkownik);
		adresy.add(uzytkownikDane.getAdresy().get(0));
		uzytkownik.setAdresy(adresy);
		adresyRepository.save(adresy);
		uzytkownicyRepository.save(uzytkownik);
	}
	
}
