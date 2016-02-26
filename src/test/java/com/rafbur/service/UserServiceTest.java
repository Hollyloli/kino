package com.rafbur.service;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.rafbur.entity.Uzytkownicy;
import com.rafbur.repository.UzytkownicyRepository;


@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class UserServiceTest {

	
	@Mock
	private UzytkownicyRepository UzytkownicyRepository;

//	@Mock
//	private AccountRepository accountRepositoryMock;
//
//	@Rule
//	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		Uzytkownicy uzytkownik = new Uzytkownicy();
		uzytkownik.setImie("Dupa");
		UzytkownicyRepository.save(uzytkownik);
		
		Uzytkownicy uzytkownik2 = UzytkownicyRepository.findByImie("Dupa");
		assertThat(uzytkownik.getImie()).isEqualTo(uzytkownik2.getImie());
	}

}
