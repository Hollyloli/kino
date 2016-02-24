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
	
	public ArrayList<Sala> znajdzSale(Seans seans) {
		
		//sprawdzic czy sala ma przyisany jakis seans
//		jesli nie to przypisac jestli tak to sprwdzic
//		czy w tej godzinie jest przypisany jakis seans
//		Seans seans2 = seansRepository.fin
//		seans2.setData(seans.getData());
		
		ArrayList<Sala> wszystkieSale = (ArrayList<Sala>) salaRepository.findAll();
		System.out.println("wypisuje wszyskie sale " + wszystkieSale.size());
		
		ArrayList<Seans> seanse = seansRepository.findByPoczatekFilmuAndKoniecFilmu(seans.getPoczatekFilmu(), seans.getKoniecFilmu());
		System.out.println("wypisuje seanse  " +seanse.size());
		
		ArrayList<Sala> sale = new ArrayList<Sala>();
		
//		for (Seans seans1 : seanse) {
//			sale.add(seans1.getSala());
//		}
		
		for(Sala sala : wszystkieSale) {
			if(seanse.size()==0) {
				sale.add(sala);
			}
			else {
				for(Seans seans1 : seanse) {
					if(!sala.getIdSali().equals(seans1.getSala().getIdSali())) {
						sale.add(sala);
					}
				}
			}
		}
		
		return sale;
		
		//ArrayList<Sala> sale = salaRepository.findBySeanse(seans);
		
		
		

	}

	public void dodajSeans(String nazwaSali, Seans seans) {
		Sala sala = salaRepository.findByNazwaSali(nazwaSali);
		
		Filmy film = filmyRepository.findByTytulFilmu(((Filmy)seans.getFilm()).getTytulFilmu());
		
		System.out.println("film " + film.getTytulFilmu());
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

	public Integer znajdzIdSeansu(Seans seans) {
		
		return null;
	}

	public Integer znajdzIdSeansu(Date obiektData, String nazwaSali) {
		System.out.println(obiektData.getYear() + " " + obiektData.getMonth() + " " + obiektData.getDate() + " " + obiektData.getHours() + " " + obiektData.getMinutes());
		Sala sala = salaRepository.findByNazwaSali(nazwaSali);
		System.out.println("wypisuje sale " + sala.getIdSali());
//		System.out.println("idSeansu " +seansRepository.findBySala(sala).getIdSeansu());
		System.out.println(obiektData.getYear() + " " + obiektData.getMonth() + " " + obiektData.getDate() + " " + obiektData.getHours() + " " + obiektData.getMinutes());
		
		Date data = new Date(135, 2, 25, 9, 00);
		System.out.println(data.getYear() + " " + data.getMonth() + " " + data.getDate() + " " + data.getHours() + " " + data.getMinutes());
		
		
		System.out.println("data " + data.getYear());
		System.out.println("szukanie daty " + seansRepository.findByPoczatekFilmu(data));
		
		return seansRepository.findByPoczatekFilmuAndSala(obiektData,sala).getIdSeansu();
	}

}
