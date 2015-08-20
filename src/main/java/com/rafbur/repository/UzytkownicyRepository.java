package com.rafbur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.rafbur.entity.Uzytkownicy;

public interface UzytkownicyRepository extends JpaRepository<Uzytkownicy, Integer>{

	Uzytkownicy findByImie(String imie);

	Uzytkownicy findByLogin(String login);
		
}
