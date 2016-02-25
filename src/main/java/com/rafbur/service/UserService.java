package com.rafbur.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rafbur.entity.Adresy;
import com.rafbur.entity.Kontakty;
import com.rafbur.entity.Role;
import com.rafbur.entity.Uzytkownicy;
import com.rafbur.repository.AdresyRepository;
import com.rafbur.repository.KontaktyRepository;
import com.rafbur.repository.RoleRepository;
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
	
	@Autowired
	private RoleRepository roleRepository;
	

	public Uzytkownicy znajdUzytkownika(String login) {
		Uzytkownicy uzytkownik = uzytkownicyRepository.findByLogin(login);
		return znajdzAdresy(uzytkownik.getIdUzytkownika());
	}

	private Uzytkownicy znajdzAdresy(int idUzytkownika) {
		Uzytkownicy uzytkownik = uzytkownicyRepository.findOne(idUzytkownika);
		List<Adresy> adresy = adresyRepository.findByUzytkownicy(uzytkownik);
		uzytkownik.setAdresy(adresy);
		List<Kontakty> kontakty = kontaktyRepository.findByUzytkownicy(uzytkownik);
		uzytkownik.setKontakty(kontakty);
		return uzytkownik;
	}


	public void aktualizuj(Uzytkownicy uzytkownikDane, String login) {
		Uzytkownicy uzytkownik = uzytkownicyRepository.findByLogin(login);
		List<Adresy> adresy = adresyRepository.findByUzytkownicy(uzytkownik);
		List<Kontakty> kontakty = kontaktyRepository.findByUzytkownicy(uzytkownik);
		for(int i = 0; i<uzytkownikDane.getAdresy().size(); i++) {
			adresy.get(i).setMiasto(uzytkownikDane.getAdresy().get(i).getMiasto());
			adresy.get(i).setUlica(uzytkownikDane.getAdresy().get(i).getUlica());
			adresy.get(i).setNumerMieszkania(uzytkownikDane.getAdresy().get(i).getNumerMieszkania());
			adresy.get(i).setKodPocztowy(uzytkownikDane.getAdresy().get(i).getKodPocztowy());
			adresyRepository.saveAndFlush(adresy.get(i));
		}
		for (int i = 0; i<uzytkownikDane.getKontakty().size(); i++) {
			kontakty.get(i).setEmail(uzytkownikDane.getKontakty().get(i).getEmail());
			kontakty.get(i).setTelefon(uzytkownikDane.getKontakty().get(i).getTelefon());
			kontaktyRepository.saveAndFlush(kontakty.get(i));
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		uzytkownik.setHaslo(encoder.encode(uzytkownikDane.getHaslo()));
		uzytkownicyRepository.saveAndFlush(uzytkownik);
	}

	public List<Role> znajdzTypRoliUzytkownika(String login) {
		Uzytkownicy uzytkownik = uzytkownicyRepository.findByLogin(login);
		List<Role> role = roleRepository.findByUzytkownicy(uzytkownik);
		return role;
	}

	public void zarejestruj(Uzytkownicy uzytkownik) {
		adresyRepository.save(uzytkownik.getAdresy());
		List<Adresy> adresy= new ArrayList<Adresy>();
		adresy.add(uzytkownik.getAdresy().get(0));
		kontaktyRepository.save(uzytkownik.getKontakty());
		List<Kontakty> kontakty = new ArrayList<Kontakty>();
		kontakty.add(uzytkownik.getKontakty().get(0));
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		uzytkownik.setHaslo(encoder.encode("1234"));
		uzytkownik.setKontakty(kontakty);
		uzytkownik.setAdresy(adresy);
		uzytkownik.setRole(znajdzTypRoliUzytkownika(uzytkownik.getLogin()));
		uzytkownicyRepository.save(uzytkownik);
	}

	public List<Uzytkownicy> znajdzNieaktywowanychUzytkownikow() {
		List<Uzytkownicy> uzytkownicy = uzytkownicyRepository.findAll();
		List<Uzytkownicy> uzytkownicyBezRoli = new ArrayList<Uzytkownicy>();
		for (Uzytkownicy uzytkownik : uzytkownicy) {
			if(uzytkownik.getRole().isEmpty()) {
				uzytkownicyBezRoli.add(uzytkownik);
			}
		}
		return uzytkownicyBezRoli;
	}


	public List<Uzytkownicy> znajdzNauczycieli() {
		Role rola = roleRepository.findByTypRoli("ROLE_NAUCZYCIEL");
		List<Uzytkownicy> nauczyciele = uzytkownicyRepository.findByRole(rola);
		return nauczyciele;
	}

	public String znajdzNauczyciela(String login) {
		String[] imieINazwisko = login.split(" ");
		Uzytkownicy uzytkownik = uzytkownicyRepository.findByImieAndNazwisko(imieINazwisko[0], imieINazwisko[1]);
		return uzytkownik.getLogin();
	}	
}