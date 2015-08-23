package com.rafbur.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import com.rafbur.contoler.Polaczone;
import com.rafbur.entity.Adresy;
import com.rafbur.entity.Kontakty;
import com.rafbur.entity.Uzytkownicy;
import com.rafbur.repository.AdresyRepository;
import com.rafbur.repository.KontaktyRepository;
import com.rafbur.repository.UzytkownicyRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UzytkownicyRepository uzytkownicyRepository;
	
	@Autowired
	private AdresyRepository adresyRepository;
	
	@Autowired
	private KontaktyRepository kontaktyRepository;
	
	
	public void save(Polaczone polaczeone) {
		adresyRepository.save(polaczeone.getAdresy());
		List<Adresy> adresy= new ArrayList<Adresy>();
		adresy.add(polaczeone.getAdresy());
		
		kontaktyRepository.save(polaczeone.getKontakty());
		List<Kontakty> kontakty = new ArrayList<Kontakty>();
		kontakty.add(polaczeone.getKontakty());
		
		Uzytkownicy uzytkownik = polaczeone.getUzytkownicy();
		uzytkownik.setKontakty(kontakty);
		uzytkownik.setAdresy(adresy);
		uzytkownicyRepository.save(uzytkownik);
	}

	public Uzytkownicy znajdUzytkownika(String login) {
		System.out.println("wypisuje imie " + login);
		Uzytkownicy uzytkownik = uzytkownicyRepository.findByLogin(login);
		System.out.println(" wypisuje imie uzytkownika ze znajdzUzytkownika " + uzytkownik.getImie());
		System.out.println(" wypisuje nazwisko uzytkownika ze znajdzUzytkownika " + uzytkownik.getLogin());
		
		return znajdzAdresy(uzytkownik.getIdUzytkownika());
	}

	private Uzytkownicy znajdzAdresy(int idUzytkownika) {
		Uzytkownicy uzytkownik = uzytkownicyRepository.findOne(idUzytkownika);
		List<Adresy> adresy = adresyRepository.findByUzytkownicy(uzytkownik);
		uzytkownik.setAdresy(adresy);
		
		List<Kontakty> kontakty = kontaktyRepository.findByUzytkownicy(uzytkownik);
		
		//update danych
//		kontakty.get(0).setTelefon("1234");
//		kontaktyRepository.saveAndFlush(kontakty.get(0));
		
		uzytkownik.setKontakty(kontakty);
		return uzytkownik;
	}

//	public void aktualizuj(Polaczone polaczeone) {
//		String[] parts = polaczeone.getAdresy().getMiasto().split(",");
//		System.out.println("wypisuje tablice miast " +parts);
//		polaczeone.getAdresy().setMiasto(parts[0]);
//		adresyRepository.saveAndFlush(polaczeone.getAdresy());
//	}

	public void aktualizuj(Uzytkownicy uzytkownikDane, String login) {
		Uzytkownicy uzytkownik = uzytkownicyRepository.findByLogin(login);
		List<Adresy> adresy = adresyRepository.findByUzytkownicy(uzytkownik);
		for(int i = 0; i<uzytkownikDane.getAdresy().size(); i++)
		{
			adresy.get(i).setMiasto(uzytkownikDane.getAdresy().get(i).getMiasto());
//			adresy.get(i).setUlica(ulica[i]);
//			adresy.get(i).setNumerMieszkania(numerMieszkania[i]);
//			adresy.get(i).setKodPocztowy(kodPocztowy[i]);
			adresyRepository.saveAndFlush(adresy.get(i));
		}
	}

//	
//	public User findOne(int id) {
//		return userRepository.findOne(id);
//	}
//
//	@Transactional
//	public User findOneWithBlogs(int id) {
//		User user = findOne(id);
//		List<Blog> blogs = blogRepository.findByUser(user);
//		for (Blog blog : blogs) {
//			List<Item> item = itemRepository.findByBlog(blog, new PageRequest(0, 14, org.springframework.data.domain.Sort.Direction.DESC, "publishedDate"));
//			blog.setItems(item);
//		}
//		user.setBlogs(blogs);
//		return user;
//	}
	
}