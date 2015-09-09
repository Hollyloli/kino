package com.rafbur.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafbur.entity.Klasa;
import com.rafbur.entity.Uczniowie;

public interface UczniowieRepository extends JpaRepository<Uczniowie, Integer>{

	List<Uczniowie> findByKlasa(Klasa klasa);
	
	Uczniowie findByImieAndNazwisko(String imie, String nazwisko);

}
