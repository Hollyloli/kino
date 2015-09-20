package com.rafbur.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafbur.entity.Nauczyciele;
import com.rafbur.entity.Przedmioty;
import com.rafbur.entity.Uczniowie;

public interface PrzedmiotyRepository extends JpaRepository<Przedmioty, Integer>{

	List<Przedmioty> findByNauczyciele(Nauczyciele nauczyciel);

	Przedmioty findByNazwa(String nazwaPrzedmiotu);

	List<Przedmioty> findByUczniowie(Uczniowie uczen);


}
