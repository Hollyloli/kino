package com.rafbur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafbur.entity.Filmy;
import com.rafbur.repository.FilmyRepository;

@Service
public class FilmyService {

	@Autowired
	private FilmyRepository filmyRepository;
	
	public void dodajFilm(String tytulFilmu, Integer dlugosc) {
		// TODO Auto-generated method stub
		Filmy film = new Filmy();
		film.setTytulFilmu(tytulFilmu);
		film.setDlugsc(dlugosc);
		filmyRepository.save(film);
	}

}
