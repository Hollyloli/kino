package com.rafbur.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;











import com.rafbur.entity.Adresy;
import com.rafbur.entity.Oceny;
import com.rafbur.entity.Role;
import com.rafbur.entity.Uczniowie;
import com.rafbur.entity.Uzytkownicy;
import com.rafbur.repository.AdresyRepository;
import com.rafbur.repository.OcenyRepository;
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
	private AdresyRepository adresyRepository;
	
	@Autowired
	private UczniowieRepository uczniowieRepository;
	
	@Autowired
	private OcenyRepository ocenyRepository; 
	
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
		uzytkwonikUczen.setLogin("erafbur");
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
		
		List<Adresy> adresy= new ArrayList<Adresy>();
		adresy.add(adres1);
		adresy.add(adres2);
		uzytkwonikUczen.setAdresy(adresy);
		
		uzytkownicyRepository.save(uzytkwonikUczen);
		
		Oceny ocena1 = new Oceny();
		ocena1.setOcena(5);
		ocenyRepository.save(ocena1);
		
		
		Uczniowie uczen = new Uczniowie();
		uczen.setLogin("erafbur");
		List<Oceny> ocenyUzytkow = new ArrayList<Oceny>();
		ocenyUzytkow.add(ocena1);
		
		uczniowieRepository.save(uczen);
		
		
	}
	
}
