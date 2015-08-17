package com.rafbur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafbur.entity.Uzytkownicy;
import com.rafbur.repository.UzytkownicyRepository;

@Service
public class UserService {

	@Autowired
	private UzytkownicyRepository uzytkownicyRepository;
		
	public void save(Uzytkownicy user) {
		uzytkownicyRepository.save(user);
	}

	
	
}
