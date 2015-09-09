package com.rafbur.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafbur.entity.Klasa;
import com.rafbur.entity.Nauczyciele;
import com.rafbur.entity.Uczniowie;

public interface KlasaRepository extends JpaRepository<Klasa, Integer>{

	List<Klasa> findByNauczyciele(Nauczyciele nauczyciel);

	Klasa findByRok(String rok);

	Klasa findByRokAndSymbol(Integer rok, String symbol);

	Klasa findByUczniowie(Uczniowie uczen);
}
