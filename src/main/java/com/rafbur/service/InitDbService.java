package com.rafbur.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rafbur.entity.Adresy;
import com.rafbur.entity.Klasa;
import com.rafbur.entity.Kontakty;
import com.rafbur.entity.Nauczyciele;
import com.rafbur.entity.Oceny;
import com.rafbur.entity.Opiekunowie;
import com.rafbur.entity.Przedmioty;
import com.rafbur.entity.Role;
import com.rafbur.entity.Uczniowie;
import com.rafbur.entity.Uzytkownicy;
import com.rafbur.repository.AdresyRepository;
import com.rafbur.repository.KlasaRepository;
import com.rafbur.repository.KontaktyRepository;
import com.rafbur.repository.NauczycieleRepository;
import com.rafbur.repository.OcenyRepository;
import com.rafbur.repository.OpiekunowieRepository;
import com.rafbur.repository.PrzedmiotyRepository;
import com.rafbur.repository.RoleRepository;
import com.rafbur.repository.UczniowieRepository;
import com.rafbur.repository.UzytkownicyRepository;

@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	
	
	@Autowired
	private UzytkownicyRepository uzytkownicyRepository;	
	
	@Autowired
	private KontaktyRepository KontaktyRepository;
	
	@Autowired
	private AdresyRepository adresyRepository;
	
	@Autowired
	private UczniowieRepository uczniowieRepository;
	
	@Autowired
	private OcenyRepository ocenyRepository; 
	
	@Autowired
	private PrzedmiotyRepository przedmiotyRepository;
	
	@Autowired
	private KlasaRepository klasaRepository;
	
	@Autowired
	private NauczycieleRepository nauczycieleRepository;
	
	@Autowired
	private OpiekunowieRepository opiekunowieRepository;
	
	@PostConstruct
	public void init() throws ParseException {
		Role roleUser = new Role();
		roleUser.setTypRoli("ROLE_DYREKTOR");
		roleRepository.save(roleUser);
		
		Role roleUser2 = new Role();
		roleUser2.setTypRoli("ROLE_NAUCZYCIEL");
		roleRepository.save(roleUser2);
		
		Role roleUser3 = new Role();
		roleUser3.setTypRoli("ROLE_OPIEKUN");
		roleRepository.save(roleUser3);
		
		
		Role roleUser4 = new Role();
		roleUser4.setTypRoli("ROLE_UCZEN");
		roleRepository.save(roleUser4);
		
	
		
		Uzytkownicy uzytkwonikUczen = new Uzytkownicy();
		uzytkwonikUczen.setImie("Rafal");
		uzytkwonikUczen.setNazwisko("Burnejko");
		uzytkwonikUczen.setLogin("admin");
		uzytkwonikUczen.setAktywny(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		uzytkwonikUczen.setHaslo(encoder.encode("admin"));
		List<Role> role = new ArrayList<Role>();
		role.add(roleUser);
		role.add(roleUser2);
		role.add(roleUser4);
		uzytkwonikUczen.setRole(role);
		
		Adresy adres1 = new Adresy();
		adres1.setUlica("Retkinska");;
		adres1.setKodPocztowy("94-004");
		adres1.setMiasto("Lodz");
		adres1.setNumerMieszkania(new Integer(5));
		adresyRepository.save(adres1);
		
		Adresy adres2 = new Adresy();
		adres2.setUlica("Bratyslawska");;
		adres2.setKodPocztowy("94-004");
		adres2.setMiasto("Lodz");
		adres2.setNumerMieszkania(new Integer(17));
		adresyRepository.save(adres2);
		
		
		Kontakty kontakt1 = new Kontakty();
		kontakt1.setEmail("rafal@email.pl");
		kontakt1.setTelefon("510389421");
		KontaktyRepository.save(kontakt1);
		
		
		List<Adresy> adresy= new ArrayList<Adresy>();
		adresy.add(adres1);
		adresy.add(adres2);
		uzytkwonikUczen.setAdresy(adresy);
		
		List<Kontakty> kontakty = new ArrayList<Kontakty>();
		kontakty.add(kontakt1);
		uzytkwonikUczen.setKontakty(kontakty);
		
		uzytkownicyRepository.save(uzytkwonikUczen);
		
		Uzytkownicy uzytkwonikOpiekun = new Uzytkownicy();
		uzytkwonikOpiekun.setImie("imieOpiekun");
		uzytkwonikOpiekun.setNazwisko("nazwiskoOpiekun");
		uzytkwonikOpiekun.setLogin("opiekun");
		uzytkwonikOpiekun.setHaslo(encoder.encode("opiekun"));
		uzytkwonikOpiekun.setAktywny(true);
		List<Role> roleOpiekuna = new ArrayList<Role>();
		roleOpiekuna.add(roleUser3);
		uzytkwonikOpiekun.setRole(roleOpiekuna);
		uzytkownicyRepository.save(uzytkwonikOpiekun);
		
		Uzytkownicy uzytkwonikNauczyciel = new Uzytkownicy();
		uzytkwonikNauczyciel.setImie("Ann");
		uzytkwonikNauczyciel.setNazwisko("Kon");
		uzytkwonikNauczyciel.setLogin("Akon");
		uzytkwonikNauczyciel.setAktywny(true);;
		uzytkwonikNauczyciel.setHaslo(encoder.encode("12345"));
		List<Role> role2 = new ArrayList<Role>();
//		role2.add(roleUser2);
		uzytkwonikNauczyciel.setRole(role2);
		uzytkownicyRepository.save(uzytkwonikNauczyciel);
		
		
//		Oceny ocena = new Oceny();
//		ocena.setOcena(4);
//		ocena.setWagaOceny(1);
//		ocena.setRokNauki(1);
//		ocena.setSemestr(2);
//		ocena.setTyp("koncowa");
//		ocenyRepository.save(ocena);
		
		Oceny ocena2 = new Oceny();
		ocena2.setOcena(4);
		ocena2.setRokNauki(1);
		ocena2.setSemestr(1);
		ocena2.setTyp("semestralna");
		ocenyRepository.save(ocena2);
		
		Oceny ocena3 = new Oceny();
		ocena3.setOcena(4);
		ocena3.setWagaOceny(3);
		ocena3.setRokNauki(1);
		ocena3.setSemestr(1);
		ocena3.setTyp("czastkowa");
		ocenyRepository.save(ocena3);
		
		Oceny ocena5 = new Oceny();
		ocena5.setOcena(3);
		ocena5.setWagaOceny(1);
		ocena5.setRokNauki(1);
		ocena5.setSemestr(2);
		ocena5.setTyp("czastkowa");
		ocenyRepository.save(ocena5);
		
		Oceny ocena4 = new Oceny();
		ocena4.setOcena(3);
		ocena4.setRokNauki(1);
		ocena4.setSemestr(1);
		ocena4.setTyp("semestralna");
		ocenyRepository.save(ocena4);
		
		Oceny ocena11 = new Oceny();
		ocena11.setOcena(4);
		ocena11.setWagaOceny(2);
		ocena11.setRokNauki(1);
		ocena11.setSemestr(2);
		ocena11.setTyp("czastkowa");
		ocenyRepository.save(ocena11);
		
		Oceny ocena12 = new Oceny();
		ocena12.setOcena(5);
		ocena12.setWagaOceny(1);
		ocena12.setRokNauki(1);
		ocena12.setSemestr(2);
		ocena12.setTyp("czastkowa");
		ocenyRepository.save(ocena12);
		
		
		
		List<Oceny> oceny = new ArrayList<Oceny>();
//		oceny.add(ocena);
		oceny.add(ocena2);
		oceny.add(ocena3);
		oceny.add(ocena5);
		oceny.add(ocena11);
		oceny.add(ocena12);
		
		
		Oceny ocena7 = new Oceny();
		ocena7.setOcena(2);
		ocena7.setWagaOceny(3);
		ocena7.setRokNauki(1);
		ocena7.setSemestr(1);
		ocena7.setTyp("czastkowa");
		ocenyRepository.save(ocena7);
		
		Oceny ocena8 = new Oceny();
		ocena8.setOcena(5);
		ocena8.setWagaOceny(2);
		ocena8.setRokNauki(1);
		ocena8.setSemestr(1);
		ocena8.setTyp("czastkowa");
		ocenyRepository.save(ocena8);
		
		Oceny ocena9 = new Oceny();
		ocena9.setOcena(1);
		ocena9.setWagaOceny(2);
		ocena9.setRokNauki(1);
		ocena9.setSemestr(1);
		ocena9.setTyp("czastkowa");
		ocenyRepository.save(ocena9);
		
		Oceny ocena10 = new Oceny();
		ocena10.setOcena(6);
		ocena10.setWagaOceny(1);
		ocena10.setRokNauki(1);
		ocena10.setSemestr(1);
		ocena10.setTyp("czastkowa");
		ocenyRepository.save(ocena10);
		
		
		
		List<Oceny> oceny2 = new ArrayList<Oceny>();
		oceny2.add(ocena4);
		oceny2.add(ocena7);
		oceny2.add(ocena8);
		oceny2.add(ocena9);
		oceny2.add(ocena10);
		
		
		List<Oceny> wszystkieOceny = new ArrayList<Oceny>();
		wszystkieOceny.addAll(oceny);
		wszystkieOceny.addAll(oceny2);
		Przedmioty przedmiot = new Przedmioty();
		przedmiot.setNazwa("jezyk polski");
		przedmiot.setOceny(wszystkieOceny);
		List<Przedmioty> przedmioty = new ArrayList<Przedmioty>();
		przedmioty.add(przedmiot);
		przedmiotyRepository.save(przedmiot);
		
		
		Klasa pierwszaKlasa = new Klasa();
		pierwszaKlasa.setRok(1);
		pierwszaKlasa.setSymbol("A");
		List<Klasa> klasy = new ArrayList<Klasa>();
		klasy.add(pierwszaKlasa);
		klasaRepository.save(pierwszaKlasa);
		
//		Klasa pierwszaKlasa2 = new Klasa();
//		pierwszaKlasa2.setRok(2);
//		pierwszaKlasa2.setSymbol("B");
//		klasy.add(pierwszaKlasa2);
//		klasaRepository.save(pierwszaKlasa2);
		
		Opiekunowie opiekun = new Opiekunowie();
		opiekun.setLogin(uzytkwonikOpiekun.getLogin());
//		List<Uczniowie> uczniowie = new ArrayList<Uczniowie>();
//		uczniowie.add(uczen);
//		opiekun.setUczniowie(uczniowie);
		opiekunowieRepository.save(opiekun);
		
		List<Opiekunowie> opiekunowie = new ArrayList<Opiekunowie>();
		opiekunowie.add(opiekun);
		
		Uczniowie uczen = new Uczniowie();
		uczen.setLogin(uzytkwonikUczen.getLogin());
		uczen.setImie(uzytkwonikUczen.getImie());
		uczen.setNazwisko(uzytkwonikUczen.getNazwisko());
		uczen.setPrzedmioty(przedmioty);
		uczen.setKlasa(pierwszaKlasa);
		uczen.setOceny(oceny);
		uczen.setOpiekunowie(opiekunowie);
		uczniowieRepository.save(uczen);
		
		Uczniowie uczen2 = new Uczniowie();
		uczen2.setLogin("aklepka");
		uczen2.setImie("Anna");
		uczen2.setNazwisko("Klepka");
		uczen2.setPrzedmioty(przedmioty);
		uczen2.setKlasa(pierwszaKlasa);
		uczen2.setOceny(oceny2);
		uczniowieRepository.save(uczen2);
		
		Nauczyciele nauczyciel = new Nauczyciele();
		nauczyciel.setLogin(uzytkwonikUczen.getLogin());
		nauczyciel.setPrzedmiotyNauczycieli(przedmioty);
		nauczyciel.setKlasaNauczyciel(klasy);
		nauczycieleRepository.save(nauczyciel);
		
	
		
	}
	
}
