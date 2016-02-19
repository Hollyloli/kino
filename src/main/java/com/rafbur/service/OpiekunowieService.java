//package com.rafbur.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.rafbur.entity.Opiekunowie;
//import com.rafbur.entity.Role;
//import com.rafbur.entity.Uczniowie;
//import com.rafbur.entity.Uzytkownicy;
//import com.rafbur.repository.OpiekunowieRepository;
//import com.rafbur.repository.RoleRepository;
//import com.rafbur.repository.UczniowieRepository;
//import com.rafbur.repository.UzytkownicyRepository;
//
//@Service
//public class OpiekunowieService {
//
//	@Autowired
//	private UzytkownicyRepository uzytkownicyRepository;
//
//	@Autowired
//	private RoleRepository roleRepository;
//	
//	@Autowired
//	private UczniowieRepository uczniowieRepository;
//	
//	@Autowired
//	private OpiekunowieRepository opiekunowieRepository;
//	
//	public List<Uzytkownicy> znajdzWszystkichOpiekunow() {
//		Role rola = roleRepository.findByTypRoli("ROLE_OPIEKUN");
//		List<Uzytkownicy> opiekunowie = uzytkownicyRepository.findByRole(rola);
//		return opiekunowie;
//	}
//
//	public void przypiszUczniaOpiekunowi(String loginOpiekuna, String loginUcznia) {
//		List<Uczniowie> uczniowie = new ArrayList<Uczniowie>();
//		Uczniowie uczen = uczniowieRepository.findByLogin(loginUcznia);
//		uczniowie.add(uczen);
//		Opiekunowie opiekun = opiekunowieRepository.findByLogin(loginOpiekuna);
//		opiekun.setUczniowie(uczniowie);
//	}
//
//	public List<Uczniowie> znajdzDzieciOpiekuna(String loginOpiekuna) {
//		Opiekunowie opiekun = opiekunowieRepository.findByLogin(loginOpiekuna);
//		List<Uczniowie> uczniowie = uczniowieRepository.findByOpiekunowie(opiekun);
//		return uczniowie;
//	}
//	
//}
