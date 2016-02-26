package com.rafbur.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rafbur.entity.Sala;
import com.rafbur.repository.SalaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class SalaServiceTest {

	@Autowired
	private SalaService salaService;
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Before
	public void setUp() throws Exception {
//		Sala sala = new Sala();
//		sala.setNazwaSali("Moja Sala");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
//public Integer znajdzIdSaliPoNazwie(String nazwaSali) {
//	return salaRepository.findByNazwaSali(nazwaSali).getIdSali();
//}