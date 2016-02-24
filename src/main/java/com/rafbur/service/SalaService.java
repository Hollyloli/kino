package com.rafbur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafbur.entity.Miejsce;
import com.rafbur.entity.Rzad;
import com.rafbur.entity.Sala;
import com.rafbur.repository.MiejsceRepository;
import com.rafbur.repository.RzadRepository;
import com.rafbur.repository.SalaRepository;

@Service
public class SalaService {

	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private RzadRepository rzadRepository;
	
	@Autowired
	private MiejsceRepository miejsceRepository;
	
	public void dodajSale(Sala sala) {
		salaRepository.save(sala);
		
		int iloœæRzedow = sala.getRzedy().get(0).getNumerRzedu();
		int iloscMiejsc = sala.getRzedy().get(0).getMiejsca().get(0).getNumerMiejsca();
		
		for(int i = 0; i < iloœæRzedow; i++) {
			Rzad rzad = new Rzad();
			rzad.setNumerRzedu(i+1);
			rzad.setZajetoscRzedu(false);
			rzad.setSala(sala);
			rzadRepository.save(rzad);
			for(int j =0; j < iloscMiejsc; j++) {
				Miejsce miejsce = new Miejsce();
				miejsce.setNumerMiejsca(j+1);
				miejsce.setZajetoscMiejsca(false);
				miejsce.setRzad(rzad);
				miejsceRepository.save(miejsce);
			}
		}
	}

	public List<Sala> znajdzWolnaSale() {
		return salaRepository.findAll();
	}

	public Integer znajdzIdSaliPoNazwie(String nazwaSali) {
		return salaRepository.findByNazwaSali(nazwaSali).getIdSali();
	}

}
