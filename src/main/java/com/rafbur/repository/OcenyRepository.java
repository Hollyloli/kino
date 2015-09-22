package com.rafbur.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafbur.entity.Oceny;
import com.rafbur.entity.Przedmioty;
import com.rafbur.entity.Uczniowie;

public interface OcenyRepository extends JpaRepository<Oceny, Integer>{

	List<Oceny> findByPrzedmiotyAndUczniowie(Przedmioty przedmioty, Uczniowie uczen);
	
	Oceny findByRokNaukiAndSemestrAndTyp(Integer rok,Integer semestr, String typ);

	List<Oceny> findByPrzedmioty(Przedmioty przedmiot);

	List<Oceny> findByPrzedmiotyAndUczniowieAndRokNaukiAndSemestrAndTyp(
			Przedmioty przedmiot, Uczniowie uczniowie, Integer rok,
			Integer semestr, String typ);

	List<Oceny> findByUczniowie(Uczniowie uczen);

	List<Oceny> findByPrzedmiotyAndUczniowieAndRokNaukiAndSemestr(
			Przedmioty przedmiot, Uczniowie uczen, Integer i, Integer j);

	List<Oceny> findByUczniowieAndRokNaukiAndSemestr(Uczniowie uczenBaza,
			Integer rokNauki, Integer Semestr);

	Oceny findByUczniowieAndPrzedmiotyAndRokNaukiAndTyp(Uczniowie uczen,
			Przedmioty przedmiot, Integer rok, String typ);

	List<Oceny> findByPrzedmiotyAndUczniowieAndRokNaukiAndTyp(
			Przedmioty przedmiot, Uczniowie uczen, Integer rok, String typ);

	List<Oceny> findByUczniowieAndRokNauki(Uczniowie uczen, Integer rok);

	
//	Oceny findByPrzedmiotyAndUczniowieAndRokNaukiAndSemestrAndTyp(
//			Przedmioty przedmiot, Uczniowie uczniowie, Integer rokNauki,
//			Integer semestr, String typ);

}
