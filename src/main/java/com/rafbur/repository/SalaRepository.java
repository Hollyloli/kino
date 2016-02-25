package com.rafbur.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafbur.entity.Sala;
import com.rafbur.entity.Seans;

public interface SalaRepository extends JpaRepository<Sala, Integer>{


	Sala findByNazwaSali(String nazwaSali);

	List<Sala> findBySeanse(List<Seans> seanse);

	List<Sala> findBySeanse(Seans seans);

	Sala findByIdSali(Integer idSali);

}
