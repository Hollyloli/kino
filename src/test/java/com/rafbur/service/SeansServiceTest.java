package com.rafbur.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rafbur.entity.Filmy;
import com.rafbur.entity.Seans;
import com.rafbur.repository.FilmyRepository;
import com.rafbur.repository.SalaRepository;
import com.rafbur.repository.SeansRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class SeansServiceTest {

	@Autowired
	private SalaService salaService;
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private FilmyRepository filmyRepository;
	
	@Autowired
	private SeansRepository seansRepository;
	
	@Autowired
	private SeansService seansService;

	@Test
	public void test() {
		Filmy film = new Filmy(); 
		film.setTytulFilmu("Film Testowy");
		film.setDlugsc(100);
		filmyRepository.save(film);
		Seans seans1 = new Seans();
		Date poczatekFilmu = new Date(116, 2, 27, 9, 0);
		Date koniecFilmu = new Date(116,2,27,9,0);
		seans1.setPoczatekFilmu(poczatekFilmu);
		seans1.setKoniecFilmu(koniecFilmu);
		seans1.setFilm(film);
		seansService.dodajSeans("Film Testowy", seans1);
		Seans seans = seansRepository.findByPoczatekFilmu(poczatekFilmu);
		Filmy idFilmu = filmyRepository.findByTytulFilmu("Film Testowy");
		assertEquals(poczatekFilmu, seans.getPoczatekFilmu());
		assertEquals(koniecFilmu, seans.getKoniecFilmu());
		assertEquals(idFilmu.getIdFilmu(), seans.getFilm().getIdFilmu());
	}

}
