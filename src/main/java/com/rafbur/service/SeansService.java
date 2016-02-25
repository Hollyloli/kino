package com.rafbur.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafbur.entity.Filmy;
import com.rafbur.entity.Sala;
import com.rafbur.entity.Seans;
import com.rafbur.repository.FilmyRepository;
import com.rafbur.repository.SalaRepository;
import com.rafbur.repository.SeansRepository;

@Service
public class SeansService {

	@Autowired
	private SeansRepository seansRepository;
	
	@Autowired
	private FilmyRepository filmyRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	public List<Sala> znajdzSale(Seans seans) {
		List<Sala> wszystkieSale = (ArrayList<Sala>) salaRepository.findAll();
		List<Seans> seanse = seansRepository.findByPoczatekFilmuAndKoniecFilmu(seans.getPoczatekFilmu(), seans.getKoniecFilmu());
		List<Sala> sale = new ArrayList<Sala>();		
		for(Sala sala : wszystkieSale) {
			if(seanse.isEmpty()) {
				sale.add(sala);
			} else {
				for(Seans seans1 : seanse) {
					if(!sala.getIdSali().equals(seans1.getSala().getIdSali())) {
						sale.add(sala);
					}
				}
			}
		}
		return sale;
	}

	public void dodajSeans(String nazwaSali, Seans seans) {
		Sala sala = salaRepository.findByNazwaSali(nazwaSali);
		Filmy film = filmyRepository.findByTytulFilmu(((Filmy)seans.getFilm()).getTytulFilmu());
		Seans seans1 = new Seans();
		seans1.setPoczatekFilmu(seans.getPoczatekFilmu());
		seans1.setKoniecFilmu(seans.getKoniecFilmu());
		seans1.setFilm(film);
		seans1.setSala(sala);
		seansRepository.save(seans1);
	}

	public List<Seans> znajdzWszystkieSeanse() {
		return seansRepository.findAll();
	}



	public Integer znajdzIdSeansu(Date obiektData, String nazwaSali) {
		Sala sala = salaRepository.findByNazwaSali(nazwaSali);
		return seansRepository.findByPoczatekFilmuAndSala(obiektData,sala).getIdSeansu();
	}

}
