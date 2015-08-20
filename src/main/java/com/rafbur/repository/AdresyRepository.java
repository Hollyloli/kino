package com.rafbur.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafbur.entity.Adresy;
import com.rafbur.entity.Uzytkownicy;

public interface AdresyRepository extends JpaRepository<Adresy, Integer>{
	List<Adresy> findByUzytkownicy(Uzytkownicy uzytkownik);


}
