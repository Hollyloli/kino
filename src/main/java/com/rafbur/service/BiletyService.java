package com.rafbur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafbur.entity.Bilet;
import com.rafbur.entity.Miejsce;
import com.rafbur.entity.Rzad;
import com.rafbur.entity.Sala;
import com.rafbur.entity.Seans;
import com.rafbur.entity.Uzytkownicy;
import com.rafbur.repository.BiletRepository;
import com.rafbur.repository.MiejsceRepository;
import com.rafbur.repository.RzadRepository;
import com.rafbur.repository.SalaRepository;
import com.rafbur.repository.SeansRepository;
import com.rafbur.repository.UzytkownicyRepository;

@Service
public class BiletyService {

	@Autowired
	private UzytkownicyRepository uzytkownicyRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private BiletRepository biletRepository;
	
	@Autowired
	private RzadRepository rzadRepository;
	
	@Autowired
	private MiejsceRepository miejsceRepository;
	
	@Autowired
	private SeansRepository seansRepository;
	
	public void zarezerwujBilet(Integer idSeansu,Integer idSali, Integer numerRzedu,Integer numerMiejsca,  String login) {
		Uzytkownicy uzytkownik = uzytkownicyRepository.findByLogin(login);
		Sala sala = salaRepository.findByIdSali(idSali);
		Rzad rzad = rzadRepository.findBySalaAndNumerRzedu(sala, numerRzedu);
		Miejsce miejsce =  miejsceRepository.findByRzadAndNumerMiejsca(rzad, numerMiejsca);
		miejsce.setZajetoscMiejsca(true);
		miejsceRepository.saveAndFlush(miejsce);
		Seans seans = seansRepository.findByIdSeansu(idSeansu);
		Bilet bilet = new Bilet();
		bilet.setSeans(seans);
		bilet.setUzytkownik(uzytkownik);
		biletRepository.save(bilet);
	}
}
