package com.rafbur.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.plaf.metal.OceanTheme;

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
		uzytkwonikUczen.setLogin("rbur");
		uzytkwonikUczen.setAktywny(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		uzytkwonikUczen.setHaslo(encoder.encode("rbur"));
		List<Role> role = new ArrayList<Role>();
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

		/* DEKLARACJA UZYTKOWNIKOW UCZNIOW */
		
		Uzytkownicy uzytkwonikUczen2 = new Uzytkownicy();
		uzytkwonikUczen2.setImie("Agata");
		uzytkwonikUczen2.setNazwisko("Adamczyk");
		uzytkwonikUczen2.setLogin("uczen2");
		uzytkwonikUczen2.setAktywny(true);
		uzytkwonikUczen2.setHaslo(encoder.encode("uczen2"));
		List<Role> roleUcznia = new ArrayList<Role>();
		roleUcznia.add(roleUser4);
		uzytkwonikUczen2.setRole(role);
		
		uzytkownicyRepository.save(uzytkwonikUczen2);

		
		Uzytkownicy uzytkwonikUczen3 = new Uzytkownicy();
		uzytkwonikUczen3.setImie("Marzena");
		uzytkwonikUczen3.setNazwisko("Borkowska");
		uzytkwonikUczen3.setLogin("uczen3");
		uzytkwonikUczen3.setAktywny(true);
		uzytkwonikUczen3.setHaslo(encoder.encode("uczen3"));
		roleUcznia.add(roleUser4);
		uzytkwonikUczen3.setRole(role);
		
		uzytkownicyRepository.save(uzytkwonikUczen3);

		
		Uzytkownicy uzytkwonikUczen4 = new Uzytkownicy();
		uzytkwonikUczen4.setImie("Jan");
		uzytkwonikUczen4.setNazwisko("Rek");
		uzytkwonikUczen4.setLogin("uczen4");
		uzytkwonikUczen4.setAktywny(true);
		uzytkwonikUczen4.setHaslo(encoder.encode("uczen4"));
		roleUcznia.add(roleUser4);
		uzytkwonikUczen4.setRole(role);
		
		uzytkownicyRepository.save(uzytkwonikUczen4);

		
		
		Uzytkownicy uzytkwonikUczen5 = new Uzytkownicy();
		uzytkwonikUczen5.setImie("Janusz");
		uzytkwonikUczen5.setNazwisko("Sabak");
		uzytkwonikUczen5.setLogin("uczen5");
		uzytkwonikUczen5.setAktywny(true);
		uzytkwonikUczen5.setHaslo(encoder.encode("uczen5"));
		roleUcznia.add(roleUser4);
		uzytkwonikUczen5.setRole(role);
		
		uzytkownicyRepository.save(uzytkwonikUczen5);

		/* KONIEC DEKLARACJI UZYTKOWNIKOW UCZEN */
		
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
		
		/* Tworzenie UZYTKWIOW NAUCZYCIEL */
		/* TWORZY UZYTKOWNIK DYREKTOR */
		
		Uzytkownicy uzytkwonikNauczyciel = new Uzytkownicy();
		uzytkwonikNauczyciel.setImie("Anna");
		uzytkwonikNauczyciel.setNazwisko("Konowicz");
		uzytkwonikNauczyciel.setLogin("admin");
		uzytkwonikNauczyciel.setAktywny(true);;
		uzytkwonikNauczyciel.setHaslo(encoder.encode("admin"));
		List<Role> rolaDyrektorINauczyciel = new ArrayList<Role>();
		rolaDyrektorINauczyciel.add(roleUser);
		rolaDyrektorINauczyciel.add(roleUser2);
		uzytkwonikNauczyciel.setRole(rolaDyrektorINauczyciel);
		uzytkownicyRepository.save(uzytkwonikNauczyciel);
		
		List<Role> roleNauczyciel = new ArrayList<Role>();
		roleNauczyciel.add(roleUser2);
		Uzytkownicy uzytkwonikNauczyciel2 = new Uzytkownicy();
		uzytkwonikNauczyciel2.setImie("Grzegorz");
		uzytkwonikNauczyciel2.setNazwisko("Kowalski");
		uzytkwonikNauczyciel2.setLogin("nauczyciel2");
		uzytkwonikNauczyciel2.setAktywny(true);;
		uzytkwonikNauczyciel2.setHaslo(encoder.encode("nauczyciel2"));
		uzytkwonikNauczyciel2.setRole(roleNauczyciel);
		uzytkownicyRepository.save(uzytkwonikNauczyciel2);
		
		Uzytkownicy uzytkwonikNauczyciel3 = new Uzytkownicy();
		uzytkwonikNauczyciel3.setImie("Ryszard");
		uzytkwonikNauczyciel3.setNazwisko("Nikczemny");
		uzytkwonikNauczyciel3.setLogin("nauczyciel3");
		uzytkwonikNauczyciel3.setAktywny(true);;
		uzytkwonikNauczyciel3.setHaslo(encoder.encode("nauczyciel3"));
		uzytkwonikNauczyciel3.setRole(roleNauczyciel);
		uzytkownicyRepository.save(uzytkwonikNauczyciel3);

		Uzytkownicy uzytkwonikNauczyciel4 = new Uzytkownicy();
		uzytkwonikNauczyciel4.setImie("Marian");
		uzytkwonikNauczyciel4.setNazwisko("Pazdzioch");
		uzytkwonikNauczyciel4.setLogin("nauczyciel4");
		uzytkwonikNauczyciel4.setAktywny(true);;
		uzytkwonikNauczyciel4.setHaslo(encoder.encode("nauczyciel4"));
		uzytkwonikNauczyciel4.setRole(roleNauczyciel);
		uzytkownicyRepository.save(uzytkwonikNauczyciel4);
		
		/* KONIEC Tworzenia UZYTKWIOW NAUCZYCIEL */
		
		
		
		Oceny ocena1 = new Oceny();
		ocena1.setOcena(1);
		ocena1.setWagaOceny(1);
		ocena1.setRokNauki(1);
		ocena1.setSemestr(1);
		ocena1.setTyp("czastkowa");
		ocenyRepository.save(ocena1);
		
		Oceny ocena2 = new Oceny();
		ocena2.setOcena(1);
		ocena2.setWagaOceny(2);
		ocena2.setRokNauki(1);
		ocena2.setSemestr(1);
		ocena2.setTyp("czastkowa");
		ocenyRepository.save(ocena2);
		
		Oceny ocena3 = new Oceny();
		ocena3.setOcena(1);
		ocena3.setWagaOceny(3);
		ocena3.setRokNauki(1);
		ocena3.setSemestr(1);
		ocena3.setTyp("czastkowa");
		ocenyRepository.save(ocena3);

		Oceny ocena4 = new Oceny();
		ocena4.setOcena(2);
		ocena4.setWagaOceny(1);
		ocena4.setRokNauki(1);
		ocena4.setSemestr(1);
		ocena4.setTyp("czastkowa");
		ocenyRepository.save(ocena4);
		
		Oceny ocena5 = new Oceny();
		ocena5.setOcena(2);
		ocena5.setWagaOceny(2);
		ocena5.setRokNauki(1);
		ocena5.setSemestr(1);
		ocena5.setTyp("czastkowa");
		ocenyRepository.save(ocena5);
		
		Oceny ocena6 = new Oceny();
		ocena6.setOcena(2);
		ocena6.setWagaOceny(3);
		ocena6.setRokNauki(1);
		ocena6.setSemestr(1);
		ocena6.setTyp("czastkowa");
		ocenyRepository.save(ocena6);

		Oceny ocena7 = new Oceny();
		ocena7.setOcena(3);
		ocena7.setWagaOceny(1);
		ocena7.setRokNauki(1);
		ocena7.setSemestr(1);
		ocena7.setTyp("czastkowa");
		ocenyRepository.save(ocena7);
		
		Oceny ocena8 = new Oceny();
		ocena8.setOcena(3);
		ocena8.setWagaOceny(2);
		ocena8.setRokNauki(1);
		ocena8.setSemestr(1);
		ocena8.setTyp("czastkowa");
		ocenyRepository.save(ocena8);
		
		Oceny ocena9 = new Oceny();
		ocena9.setOcena(3);
		ocena9.setWagaOceny(3);
		ocena9.setRokNauki(1);
		ocena9.setSemestr(1);
		ocena9.setTyp("czastkowa");
		ocenyRepository.save(ocena9);

		Oceny ocena10 = new Oceny();
		ocena10.setOcena(4);
		ocena10.setWagaOceny(1);
		ocena10.setRokNauki(1);
		ocena10.setSemestr(1);
		ocena10.setTyp("czastkowa");
		ocenyRepository.save(ocena10);
		
		Oceny ocena11 = new Oceny();
		ocena11.setOcena(4);
		ocena11.setWagaOceny(2);
		ocena11.setRokNauki(1);
		ocena11.setSemestr(1);
		ocena11.setTyp("czastkowa");
		ocenyRepository.save(ocena11);
		
		Oceny ocena12 = new Oceny();
		ocena12.setOcena(4);
		ocena12.setWagaOceny(3);
		ocena12.setRokNauki(1);
		ocena12.setSemestr(1);
		ocena12.setTyp("czastkowa");
		ocenyRepository.save(ocena12);

		Oceny ocena13 = new Oceny();
		ocena13.setOcena(5);
		ocena13.setWagaOceny(1);
		ocena13.setRokNauki(1);
		ocena13.setSemestr(1);
		ocena13.setTyp("czastkowa");
		ocenyRepository.save(ocena13);
		
		Oceny ocena14 = new Oceny();
		ocena14.setOcena(5);
		ocena14.setWagaOceny(2);
		ocena14.setRokNauki(1);
		ocena14.setSemestr(1);
		ocena14.setTyp("czastkowa");
		ocenyRepository.save(ocena14);
		
		Oceny ocena15 = new Oceny();
		ocena15.setOcena(5);
		ocena15.setWagaOceny(3);
		ocena15.setRokNauki(1);
		ocena15.setSemestr(1);
		ocena15.setTyp("czastkowa");
		ocenyRepository.save(ocena15);

		Oceny ocena16 = new Oceny();
		ocena16.setOcena(6);
		ocena16.setWagaOceny(1);
		ocena16.setRokNauki(1);
		ocena16.setSemestr(1);
		ocena16.setTyp("czastkowa");
		ocenyRepository.save(ocena16);
		
		Oceny ocena17 = new Oceny();
		ocena17.setOcena(6);
		ocena17.setWagaOceny(2);
		ocena17.setRokNauki(1);
		ocena17.setSemestr(1);
		ocena17.setTyp("czastkowa");
		ocenyRepository.save(ocena17);
		
		Oceny ocena18 = new Oceny();
		ocena18.setOcena(6);
		ocena18.setWagaOceny(3);
		ocena18.setRokNauki(1);
		ocena18.setSemestr(1);
		ocena18.setTyp("czastkowa");
		ocenyRepository.save(ocena18);

//		Oceny ocenaSem1 = new Oceny();
//		ocenaSem1.setOcena(1);
//		ocenaSem1.setRokNauki(1);
//		ocenaSem1.setSemestr(1);
//		ocenaSem1.setTyp("semestralna");
//		ocenyRepository.save(ocenaSem1);
//		
//		Oceny ocenaSem2 = new Oceny();
//		ocenaSem2.setOcena(2);
//		ocenaSem2.setRokNauki(1);
//		ocenaSem2.setSemestr(1);
//		ocenaSem2.setTyp("semestralna");
//		ocenyRepository.save(ocenaSem2);
//		
//		Oceny ocenaSem3 = new Oceny();
//		ocenaSem3.setOcena(3);
//		ocenaSem3.setRokNauki(1);
//		ocenaSem3.setSemestr(1);
//		ocenaSem3.setTyp("semestralna");
//		ocenyRepository.save(ocenaSem3);
//		
//		Oceny ocenaSem4 = new Oceny();
//		ocenaSem4.setOcena(4);
//		ocenaSem4.setRokNauki(1);
//		ocenaSem4.setSemestr(1);
//		ocenaSem4.setTyp("semestralna");
//		ocenyRepository.save(ocenaSem4);
//		
//		Oceny ocenaSem5 = new Oceny();
//		ocenaSem5.setOcena(5);
//		ocenaSem5.setRokNauki(1);
//		ocenaSem5.setSemestr(1);
//		ocenaSem5.setTyp("semestralna");
//		ocenyRepository.save(ocenaSem5);
//		
//		Oceny ocenaSem6 = new Oceny();
//		ocenaSem6.setOcena(6);
//		ocenaSem6.setRokNauki(1);
//		ocenaSem6.setSemestr(1);
//		ocenaSem6.setTyp("semestralna");
//		ocenyRepository.save(ocenaSem6);
//		
		
		
//		Oceny ocena3 = new Oceny();
//		ocena3.setOcena(4);
//		ocena3.setWagaOceny(3);
//		ocena3.setRokNauki(1);
//		ocena3.setSemestr(1);
//		ocena3.setTyp("czastkowa");
//		ocenyRepository.save(ocena3);
//		
//		Oceny ocena5 = new Oceny();
//		ocena5.setOcena(3);
//		ocena5.setWagaOceny(1);
//		ocena5.setRokNauki(1);
//		ocena5.setSemestr(2);
//		ocena5.setTyp("czastkowa");
//		ocenyRepository.save(ocena5);
//		
//		Oceny ocena4 = new Oceny();
//		ocena4.setOcena(3);
//		ocena4.setRokNauki(1);
//		ocena4.setSemestr(1);
//		ocena4.setTyp("czastkowa");
//		ocenyRepository.save(ocena4);
//		
//		Oceny ocena11 = new Oceny();
//		ocena11.setOcena(4);
//		ocena11.setWagaOceny(2);
//		ocena11.setRokNauki(1);
//		ocena11.setSemestr(2);
//		ocena11.setTyp("czastkowa");
//		ocenyRepository.save(ocena11);
//		
//		Oceny ocena12 = new Oceny();
//		ocena12.setOcena(5);
//		ocena12.setWagaOceny(1);
//		ocena12.setRokNauki(1);
//		ocena12.setSemestr(2);
//		ocena12.setTyp("czastkowa");
//		ocenyRepository.save(ocena12);
//		
//
//		
//		
//		Oceny ocena7 = new Oceny();
//		ocena7.setOcena(2);
//		ocena7.setWagaOceny(3);
//		ocena7.setRokNauki(1);
//		ocena7.setSemestr(1);
//		ocena7.setTyp("czastkowa");
//		ocenyRepository.save(ocena7);
//		
//		Oceny ocena8 = new Oceny();
//		ocena8.setOcena(5);
//		ocena8.setWagaOceny(2);
//		ocena8.setRokNauki(1);
//		ocena8.setSemestr(1);
//		ocena8.setTyp("czastkowa");
//		ocenyRepository.save(ocena8);
//		
//		Oceny ocena9 = new Oceny();
//		ocena9.setOcena(1);
//		ocena9.setWagaOceny(2);
//		ocena9.setRokNauki(1);
//		ocena9.setSemestr(1);
//		ocena9.setTyp("czastkowa");
//		ocenyRepository.save(ocena9);
//		
//		Oceny ocena10 = new Oceny();
//		ocena10.setOcena(6);
//		ocena10.setWagaOceny(1);
//		ocena10.setRokNauki(1);
//		ocena10.setSemestr(1);
//		ocena10.setTyp("czastkowa");
//		ocenyRepository.save(ocena10);
//		
//		List<Oceny> oceny = new ArrayList<Oceny>();
////		oceny.add(ocena);
//		oceny.add(ocena2);
//		oceny.add(ocena3);
//		oceny.add(ocena5);
//		oceny.add(ocena11);
//		oceny.add(ocena12);
//		
//		
//		
//		
//		
//		
//		List<Oceny> oceny2 = new ArrayList<Oceny>();
//		oceny2.add(ocena4);
//		oceny2.add(ocena7);
//		oceny2.add(ocena8);
//		oceny2.add(ocena9);
//		oceny2.add(ocena10);
//		
//		List<Oceny> oceny3 = new ArrayList<Oceny>();
//		oceny3.add(ocena3);
//		oceny3.add(ocena3);
//		oceny3.add(ocena9);
//		oceny3.add(ocena2);
//		
//		List<Oceny> wszystkieOceny = new ArrayList<Oceny>();
//		wszystkieOceny.addAll(oceny);
//		wszystkieOceny.addAll(oceny2);
//		wszystkieOceny.addAll(oceny3);
		
		
		
		
		/* TWORZENIE PRZEDMIOTOW */
		
		List<Oceny> ocenyZPolskiego = new ArrayList<Oceny>();
		ocenyZPolskiego.add(ocena18);
		ocenyZPolskiego.add(ocena12);
		ocenyZPolskiego.add(ocena1);
		ocenyZPolskiego.add(ocena5);
		ocenyZPolskiego.add(ocena17);
		ocenyZPolskiego.add(ocena15);
		ocenyZPolskiego.add(ocena2);
		ocenyZPolskiego.add(ocena8);
		
		Przedmioty przedmiot1 = new Przedmioty();
		przedmiot1.setNazwa("jezyk polski");
		przedmiot1.setOceny(ocenyZPolskiego);
		przedmiotyRepository.save(przedmiot1);
		
		Przedmioty przedmiot2 = new Przedmioty();
		przedmiot2.setNazwa("jezyk angielski");
//		przedmiot2.setOceny(wszystkieOceny);
		przedmiotyRepository.save(przedmiot2);
		
		Przedmioty przedmiot3 = new Przedmioty();
		przedmiot3.setNazwa("jezyk niemiecki");
//		przedmiot3.setOceny(wszystkieOceny);
		przedmiotyRepository.save(przedmiot3);

		List<Oceny> ocenyZmatematyki = new ArrayList<Oceny>();
//		uczen1
		ocenyZmatematyki.add(ocena15);
		ocenyZmatematyki.add(ocena8);
		ocenyZmatematyki.add(ocena2);

		
		Przedmioty przedmiot4 = new Przedmioty();
		przedmiot4.setNazwa("matematyka");
		przedmiot4.setOceny(ocenyZmatematyki);
		przedmiotyRepository.save(przedmiot4);
		
		List<Oceny> ocenyZbilogi = new ArrayList<Oceny>();
//		uczen1
		ocenyZbilogi.add(ocena17);
		ocenyZbilogi.add(ocena8);
		ocenyZbilogi.add(ocena4);

		
		Przedmioty przedmiot5 = new Przedmioty();
		przedmiot5.setNazwa("biologia");
		przedmiot5.setOceny(ocenyZbilogi);
		przedmiotyRepository.save(przedmiot5);
		
		List<Oceny> ocenyZfizyki = new ArrayList<Oceny>();
//		uczen1
		ocenyZfizyki.add(ocena8);
		ocenyZfizyki.add(ocena2);
		ocenyZfizyki.add(ocena4);
		
		Przedmioty przedmiot6 = new Przedmioty();
		przedmiot6.setNazwa("fizyka");
		przedmiot6.setOceny(ocenyZfizyki);
		przedmiotyRepository.save(przedmiot6);
		
		List<Oceny> ocenyZChemi = new ArrayList<Oceny>();
//		uczen1
		ocenyZChemi.add(ocena3);
		ocenyZChemi.add(ocena4);
		ocenyZChemi.add(ocena15);

		
		Przedmioty przedmiot7 = new Przedmioty();
		przedmiot7.setNazwa("chemia");
		przedmiot7.setOceny(ocenyZChemi);
		przedmiotyRepository.save(przedmiot7);
		
		
		Przedmioty przedmiot8 = new Przedmioty();
		przedmiot8.setNazwa("historia");
//		przedmiot8.setOceny(wszystkieOceny);
		przedmiotyRepository.save(przedmiot8);
		
		List<Oceny> ocenyZWOSu = new ArrayList<Oceny>();
//		uczen1
		ocenyZWOSu.add(ocena9);
		ocenyZWOSu.add(ocena3);
		ocenyZWOSu.add(ocena12);
		
		Przedmioty przedmiot9 = new Przedmioty();
		przedmiot9.setNazwa("WOS");
		przedmiot9.setOceny(ocenyZWOSu);
		przedmiotyRepository.save(przedmiot9);
		
		
		
		/* KONIEC TWORZENIA PRZEDMIOTOW */
		
		/* TWORZENIE KLAS */
		Klasa klasa1A = new Klasa();
		klasa1A.setRok(1);
		klasa1A.setSymbol("A");
		klasaRepository.save(klasa1A);
		
		Klasa klasa1B = new Klasa();
		klasa1B.setRok(1);
		klasa1B.setSymbol("B");
		klasaRepository.save(klasa1B);
		
		Klasa klasa2A = new Klasa();
		klasa2A.setRok(2);
		klasa2A.setSymbol("A");
		klasaRepository.save(klasa2A);

		Klasa klasa2B = new Klasa();
		klasa2B.setRok(2);
		klasa2B.setSymbol("B");
		klasaRepository.save(klasa2B);

		Klasa klasa3A = new Klasa();
		klasa3A.setRok(3);
		klasa3A.setSymbol("A");
		klasaRepository.save(klasa3A);

		Klasa klasa3B = new Klasa();
		klasa3B.setRok(3);
		klasa3B.setSymbol("B");
		klasaRepository.save(klasa3B);

		
		List<Klasa> klasy = new ArrayList<Klasa>();
		klasy.add(klasa1A);
		
		/* KONIEC TWORZENIA KLAS */
		
		
		
		
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
		
		
		/* DEKLARACJA UCZNIOW */
		List<Przedmioty> przedmiotyUczniow = new ArrayList<Przedmioty>();
		przedmiotyUczniow.add(przedmiot1);
		przedmiotyUczniow.add(przedmiot2);
		przedmiotyUczniow.add(przedmiot3);
		przedmiotyUczniow.add(przedmiot4);
		przedmiotyUczniow.add(przedmiot5);
		przedmiotyUczniow.add(przedmiot6);
		przedmiotyUczniow.add(przedmiot7);
		przedmiotyUczniow.add(przedmiot8);
		przedmiotyUczniow.add(przedmiot9);
		
		List<Oceny> ocenyUcznia1 = new ArrayList<Oceny>();
//		polski
		ocenyUcznia1.add(ocena17);
		ocenyUcznia1.add(ocena15);
		ocenyUcznia1.add(ocena2);
		ocenyUcznia1.add(ocena8);
//		WOS
		ocenyUcznia1.add(ocena4);
		ocenyUcznia1.add(ocena3);

		
		
		Uczniowie uczen = new Uczniowie();
		uczen.setLogin(uzytkwonikUczen.getLogin());
		uczen.setImie(uzytkwonikUczen.getImie());
		uczen.setNazwisko(uzytkwonikUczen.getNazwisko());
		uczen.setPrzedmioty(przedmiotyUczniow);
		uczen.setKlasa(klasa1A);
		uczen.setOceny(ocenyUcznia1);
		uczen.setOpiekunowie(opiekunowie);
		uczniowieRepository.save(uczen);
		
		List<Oceny> ocenyUcznia2 = new ArrayList<Oceny>();
//		polski
		ocenyUcznia2.add(ocena18);
		ocenyUcznia2.add(ocena12);
		ocenyUcznia2.add(ocena1);
		ocenyUcznia2.add(ocena5);
//		WOS
		ocenyUcznia2.add(ocena9);
		ocenyUcznia2.add(ocena3);
		ocenyUcznia2.add(ocena12);
		
		Uczniowie uczen2 = new Uczniowie();
		uczen2.setLogin("aklepka");
		uczen2.setImie("Anna");
		uczen2.setNazwisko("Klepka");
		uczen2.setPrzedmioty(przedmiotyUczniow);
		uczen2.setKlasa(klasa1A);
		uczen2.setOceny(ocenyUcznia2);
		uczen2.setOpiekunowie(opiekunowie);
		uczniowieRepository.save(uczen2);
		
		Uczniowie uczen3 = new Uczniowie();
		uczen3.setLogin(uzytkwonikUczen2.getLogin());
		uczen3.setImie(uzytkwonikUczen2.getImie());
		uczen3.setNazwisko(uzytkwonikUczen2.getNazwisko());
		uczen3.setPrzedmioty(przedmiotyUczniow);
		uczen3.setKlasa(klasa1A);
//		uczen3.setOceny(oceny);
		uczen3.setOpiekunowie(opiekunowie);
		uczniowieRepository.save(uczen3);
		
		Uczniowie uczen4 = new Uczniowie();
		uczen4.setLogin(uzytkwonikUczen3.getLogin());
		uczen4.setImie(uzytkwonikUczen3.getImie());
		uczen4.setNazwisko(uzytkwonikUczen3.getNazwisko());
		uczen4.setPrzedmioty(przedmiotyUczniow);
		uczen4.setKlasa(klasa1A);
//		uczen4.setOceny(oceny3);
		uczniowieRepository.save(uczen4);
		
		Uczniowie uczen5 = new Uczniowie();
		uczen5.setLogin(uzytkwonikUczen4.getLogin());
		uczen5.setImie(uzytkwonikUczen4.getImie());
		uczen5.setNazwisko(uzytkwonikUczen4.getNazwisko());
		uczen5.setPrzedmioty(przedmiotyUczniow);
		uczen5.setKlasa(klasa1A);
//		uczen5.setOceny(oceny);
		uczniowieRepository.save(uczen5);
		
		/*KONIEC DEKLARACJi UCZNIOW */
		
		/* TWORZENIA NAUCZYCIELI */
		List<Klasa> klasyNauczyciela = new ArrayList<Klasa>();
		klasyNauczyciela.add(klasa1A);
		klasyNauczyciela.add(klasa2A);
		klasyNauczyciela.add(klasa3B);
		
		List<Klasa> klasyNauczyciela2 = new ArrayList<Klasa>();
		klasyNauczyciela2.add(klasa1B);
		klasyNauczyciela2.add(klasa2B);
		klasyNauczyciela2.add(klasa3A);
		
		List<Przedmioty> przedmiotyNauczyciela = new ArrayList<Przedmioty>();
		przedmiotyNauczyciela.add(przedmiot9);
		przedmiotyNauczyciela.add(przedmiot1);
		
		List<Przedmioty> przedmiotyNauczyciela2 = new ArrayList<Przedmioty>();
		przedmiotyNauczyciela2.add(przedmiot1);
		
		Nauczyciele nauczycielPolskiegoIWosu = new Nauczyciele();
		nauczycielPolskiegoIWosu.setLogin(uzytkwonikNauczyciel.getLogin());
		nauczycielPolskiegoIWosu.setPrzedmiotyNauczycieli(przedmiotyNauczyciela);
		nauczycielPolskiegoIWosu.setKlasaNauczyciel(klasyNauczyciela);
		nauczycieleRepository.save(nauczycielPolskiegoIWosu);
		
		Nauczyciele nauczycielPolskiego2 = new Nauczyciele();
		nauczycielPolskiego2.setLogin(uzytkwonikNauczyciel2.getLogin());
		nauczycielPolskiego2.setPrzedmiotyNauczycieli(przedmiotyNauczyciela2);
		nauczycielPolskiego2.setKlasaNauczyciel(klasyNauczyciela2);
		nauczycieleRepository.save(nauczycielPolskiego2);

		
	}
	
}
