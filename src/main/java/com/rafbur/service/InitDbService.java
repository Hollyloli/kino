package com.rafbur.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



















import com.rafbur.entity.Adresy;
import com.rafbur.entity.Klasa;
import com.rafbur.entity.Kontakty;
import com.rafbur.entity.Nauczyciele;
import com.rafbur.entity.Oceny;
import com.rafbur.entity.Przedmioty;
import com.rafbur.entity.Role;
import com.rafbur.entity.Uczniowie;
import com.rafbur.entity.Uzytkownicy;
import com.rafbur.repository.AdresyRepository;
import com.rafbur.repository.KlasaRepository;
import com.rafbur.repository.KontaktyRepository;
import com.rafbur.repository.NauczycieleRepository;
import com.rafbur.repository.OcenyRepository;
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
	
	@PostConstruct
	public void init() {
		Role roleUser = new Role();
		roleUser.setTypRoli("ROLE_UCZEN");
		roleRepository.save(roleUser);
		
		Role roleUser2 = new Role();
		roleUser2.setTypRoli("ROLE_NAUCZYCIEL");
		roleRepository.save(roleUser2);
		
		Uzytkownicy uzytkwonikUczen = new Uzytkownicy();
		uzytkwonikUczen.setImie("Rafal");
		uzytkwonikUczen.setNazwisko("Be");
		uzytkwonikUczen.setLogin("admin");
		uzytkwonikUczen.setHaslo("admin");
		List<Role> role = new ArrayList<Role>();
		role.add(roleUser);
		role.add(roleUser2);
		uzytkwonikUczen.setRole(role);
		
		
		
		Adresy adres1 = new Adresy();
		adres1.setUlica("Retkinska");;
		adres1.setKodPocztowy("94-004");
		adres1.setMiasto("Lodz");
		adres1.setNumerMieszkania("5");
		adresyRepository.save(adres1);
		
		Adresy adres2 = new Adresy();
		adres2.setUlica("Bratyslawska");;
		adres2.setKodPocztowy("94-004");
		adres2.setMiasto("Lodz");
		adres2.setNumerMieszkania("17");
		adresyRepository.save(adres2);
		
		
		Kontakty kontakt1 = new Kontakty();
		kontakt1.setEmail("lol@lol.pl");
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
		
		
		
		
		
		Uzytkownicy uzytkwonikNauczyciel = new Uzytkownicy();
		uzytkwonikNauczyciel.setImie("Ann");
		uzytkwonikNauczyciel.setNazwisko("Kon");
		uzytkwonikNauczyciel.setLogin("Akon");
		uzytkwonikNauczyciel.setHaslo("1234");
		List<Role> role2 = new ArrayList<Role>();
		role.add(roleUser2);
		uzytkwonikNauczyciel.setRole(role2);
		uzytkownicyRepository.save(uzytkwonikNauczyciel);
		
		
		Oceny ocena = new Oceny();
		ocena.setOcena(3);
		ocena.setWagaOceny(1);
		ocena.setRokNauki(1);
		ocena.setSemestr(1);
		ocena.setTyp("czastkowa");
		ocenyRepository.save(ocena);
		
		Oceny ocena2 = new Oceny();
		ocena2.setOcena(2);
		ocena2.setWagaOceny(2);
		ocena2.setRokNauki(1);
		ocena2.setSemestr(1);
		ocena2.setTyp("ukonczono");
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
		ocena4.setOcena(6);
		ocena4.setWagaOceny(1);
		ocena4.setRokNauki(1);
		ocena4.setSemestr(1);
		ocena4.setTyp("ukonczono");
		ocenyRepository.save(ocena4);
		
		List<Oceny> oceny = new ArrayList<Oceny>();
		oceny.add(ocena);
		oceny.add(ocena2);
		oceny.add(ocena3);
		oceny.add(ocena5);
		
		List<Oceny> oceny2 = new ArrayList<Oceny>();
		oceny2.add(ocena4);
		
		List<Oceny> wszystkieOceny = new ArrayList<Oceny>();
		wszystkieOceny.addAll(oceny);
		wszystkieOceny.addAll(oceny2);
		Przedmioty przedmiot = new Przedmioty();
		przedmiot.setNazwa("polski");
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
		
		Klasa pierwszaKlasa2 = new Klasa();
		pierwszaKlasa2.setRok(2);
		pierwszaKlasa2.setSymbol("B");
		klasy.add(pierwszaKlasa2);
		klasaRepository.save(pierwszaKlasa2);
		
		
		Uczniowie uczen = new Uczniowie();
		uczen.setLogin(uzytkwonikUczen.getLogin());
		uczen.setImie(uzytkwonikUczen.getImie());
		uczen.setNazwisko(uzytkwonikUczen.getNazwisko());
		uczen.setPrzedmioty(przedmioty);
		uczen.setKlasa(pierwszaKlasa);
		uczen.setOceny(oceny);
		uczniowieRepository.save(uczen);
		
		Uczniowie uczen2 = new Uczniowie();
		uczen2.setLogin("erafbur'");
		uczen2.setImie("Raf");
		uczen2.setNazwisko("Burnej");
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
