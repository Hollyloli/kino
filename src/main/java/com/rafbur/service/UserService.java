package com.rafbur.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.rafbur.contoler.Polaczone;
import com.rafbur.entity.Adresy;
import com.rafbur.entity.Kontakty;
import com.rafbur.entity.Uzytkownicy;
import com.rafbur.repository.AdresyRepository;
import com.rafbur.repository.KontaktyRepository;
import com.rafbur.repository.UzytkownicyRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UzytkownicyRepository uzytkownicyRepository;
	
	@Autowired
	private AdresyRepository adresyRepository;
	
	@Autowired
	private KontaktyRepository kontaktyRepository;
	
	
	public void save(Polaczone polaczeone) {
//		adresyRepository.save(polaczeone.getAdresy());
//		List<Adresy> adresy= new ArrayList<Adresy>();
//		adresy.add(polaczeone.getAdresy());
//		
//		kontaktyRepository.save(polaczeone.getKontakty());
//		List<Kontakty> kontakty = new ArrayList<Kontakty>();
//		kontakty.add(polaczeone.getKontakty());
//		
//		Uzytkownicy uzytkownik = polaczeone.getUzytkownicy();
//		uzytkownik.setKontakty(kontakty);
//		uzytkownik.setAdresy(adresy);
//		uzytkownicyRepository.save(uzytkownik);
	}



	public List<Uzytkownicy> znajdUzytkownika() {
		return uzytkownicyRepository.findAll();
	}



	
}
