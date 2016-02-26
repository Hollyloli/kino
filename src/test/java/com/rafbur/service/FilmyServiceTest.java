package com.rafbur.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rafbur.entity.Filmy;
import com.rafbur.repository.FilmyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="../../../../webapp/WEB-INF/applicationContext.xml")
//@ContextConfiguration(locations="C:/Users/Rafal/Desktop/Kino/PracaInz/src/main/webapp/WEB-INF/applicationContext.xml")
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class FilmyServiceTest {
	
	@Autowired
	private FilmyService filmyService = new FilmyService();
	
//	@InjectMocks
//	private UserService userService = new UserService();
//	
//	@Mock
	@Autowired
	private FilmyRepository filmyRepository;

//	@Mock
//	private AccountRepository accountRepositoryMock;
	
//	@Before
//	public void setUp() throws Exception {
//
//		Filmy film = new Filmy();
//		film.setDlugsc(100);
//		
//		filmyRepository.save(film);
//	}

	@Test
	public void testZnajdzFilmy() {
		//filmyService.dodajFilm("dsfa", 222);
		
		List<Filmy> filmy = filmyService.znajdzFilmy();
		assertEquals(1, filmy.size());
	}

}
