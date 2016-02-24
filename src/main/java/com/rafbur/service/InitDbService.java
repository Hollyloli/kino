package com.rafbur.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rafbur.entity.Adresy;
import com.rafbur.entity.Bilet;
import com.rafbur.entity.Filmy;
import com.rafbur.entity.Kontakty;
import com.rafbur.entity.Miejsce;
import com.rafbur.entity.Role;
import com.rafbur.entity.Rzad;
import com.rafbur.entity.Sala;
import com.rafbur.entity.Seans;
import com.rafbur.entity.Uzytkownicy;
import com.rafbur.repository.AdresyRepository;
import com.rafbur.repository.BiletRepository;
import com.rafbur.repository.FilmyRepository;
import com.rafbur.repository.KontaktyRepository;
import com.rafbur.repository.MiejsceRepository;
import com.rafbur.repository.RoleRepository;
import com.rafbur.repository.RzadRepository;
import com.rafbur.repository.SalaRepository;
import com.rafbur.repository.SeansRepository;
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
	private MiejsceRepository miejsceRepository;
	
	@Autowired
	private RzadRepository rzadRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private FilmyRepository filmyRepository;
	
	@Autowired
	private SeansRepository seansRepository;
	
	@Autowired
	private BiletRepository biletRepository;
	
	@PostConstruct
	public void init() throws ParseException {
		Role roleUser = new Role();
		roleUser.setTypRoli("ROLE_ADMIN");
		roleRepository.save(roleUser);
		
//		Role roleUser2 = new Role();
//		roleUser2.setTypRoli("ROLE_NAUCZYCIEL");
//		roleRepository.save(roleUser2);
//		
//		Role roleUser3 = new Role();
//		roleUser3.setTypRoli("ROLE_OPIEKUN");
//		roleRepository.save(roleUser3);
		
		
		Role roleUser4 = new Role();
		roleUser4.setTypRoli("ROLE_USER");
		roleRepository.save(roleUser4);
		
	
		
		Uzytkownicy admin = new Uzytkownicy();
		admin.setImie("Rafal");
		admin.setNazwisko("Burnejko");
		admin.setLogin("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		admin.setHaslo(encoder.encode("admin"));
		List<Role> role = new ArrayList<Role>();
		role.add(roleUser);
		admin.setRole(role);
		
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
		admin.setAdresy(adresy);
		
		List<Kontakty> kontakty = new ArrayList<Kontakty>();
		kontakty.add(kontakt1);
		admin.setKontakty(kontakty);
		
		uzytkownicyRepository.save(admin);

		/* DEKLARACJA SALI KINOWEJ */		

		
		Sala sala = new Sala();
		sala.setNazwaSali("Tatry");
		salaRepository.save(sala);
		
		Rzad rzad = new Rzad();
		rzad.setNumerRzedu(1);
		rzad.setSala(sala);
		rzadRepository.save(rzad);
		
		
		Miejsce miejsce = new Miejsce();
		miejsce.setNumerMiejsca(1);
		miejsce.setRzad(rzad);
		miejsceRepository.save(miejsce);
		
		
		Filmy film = new Filmy();
		film.setTytulFilmu("Pierwszy film");
		film.setDlugsc(100);
		filmyRepository.save(film);
		
		Seans seans = new Seans();
		seans.setFilm(film);
		seans.setSala(sala);
		seans.setPoczatekFilmu(new Date(135, 2, 25, 9, 00));
		seans.setKoniecFilmu(new Date(135, 2, 25, 10, 00));
		
//		seans.setData(new Date(135, 2, 25, 8, 53));
		seansRepository.save(seans);
		
		
		
		
	
		Bilet bilet = new Bilet();
		bilet.setSeans(seans);
		bilet.setUzytkownik(admin);
		biletRepository.save(bilet);
		
	}
	
}
