package com.rafbur.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rafbur.contoler.Polaczone;
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
	
	
	public void save(Polaczone polaczeone) {
		adresyRepository.save(polaczeone.getAdresy());
		List<Adresy> adresy= new ArrayList<Adresy>();
		adresy.add(polaczeone.getAdresy());
		
		kontaktyRepository.save(polaczeone.getKontakty());
		List<Kontakty> kontakty = new ArrayList<Kontakty>();
		kontakty.add(polaczeone.getKontakty());
		
		Uzytkownicy uzytkownik = polaczeone.getUzytkownicy();
		uzytkownik.setKontakty(kontakty);
		uzytkownik.setAdresy(adresy);
		uzytkownicyRepository.save(uzytkownik);
	}

	public Uzytkownicy znajdUzytkownika(String login) {
		System.out.println("wypisuje imie " + login);
		Uzytkownicy uzytkownik = uzytkownicyRepository.findByLogin(login);
		System.out.println(" wypisuje imie uzytkownika ze znajdzUzytkownika " + uzytkownik.getImie());
		System.out.println(" wypisuje nazwisko uzytkownika ze znajdzUzytkownika " + uzytkownik.getLogin());
		
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
		for(int i = 0; i<uzytkownikDane.getAdresy().size(); i++)
		{
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
		uzytkownik.setHaslo(encoder.encode(uzytkownik.getHaslo()));
		uzytkownik.setKontakty(kontakty);
		uzytkownik.setAdresy(adresy);
		uzytkownicyRepository.save(uzytkownik);
		
		
	}	
}