package com.rafbur.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafbur.entity.Kontakty;
import com.rafbur.entity.Uzytkownicy;

public interface KontaktyRepository extends JpaRepository<Kontakty, Integer>{

	List<Kontakty> findByUzytkownicy(Uzytkownicy uzytkownik);
}
