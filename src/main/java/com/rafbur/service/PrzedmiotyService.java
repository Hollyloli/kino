package com.rafbur.service;

import java.util.List;

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

	public List<Przedmioty> znajdzPrzedmioty() {
		List<Przedmioty> przedmioty = przedmiotyRepository.findAll();
		return przedmioty;
	}

	public void dodajPrzedmiot(String nazwaPrzedmiotu) {
		Przedmioty przedmiot = new Przedmioty();
		przedmiot.setNazwa(nazwaPrzedmiotu);
		przedmiotyRepository.save(przedmiot);
	}
	
	
}
