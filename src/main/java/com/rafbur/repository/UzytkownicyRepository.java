package com.rafbur.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafbur.entity.Role;
import com.rafbur.entity.Uzytkownicy;

public interface UzytkownicyRepository extends JpaRepository<Uzytkownicy, Integer>{

	Uzytkownicy findByImie(String imie);

	Uzytkownicy findByLogin(String login);

	Uzytkownicy findByImieAndNazwisko(String string, String string2);

	List<Uzytkownicy> findByRole(Role rola);
		
}
