package com.rafbur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafbur.entity.Przedmioty;
import com.rafbur.repository.PrzedmiotyRepository;

@Service
public class PrzedmiotyService {
	
	@Autowired
	private PrzedmiotyRepository przedmiotyRepository;

	public Przedmioty znajdzPrzedmiot(String nazwaPrzedmiotu) {
		return przedmiotyRepository.findByNazwa(nazwaPrzedmiotu);
	}
	
	
}
