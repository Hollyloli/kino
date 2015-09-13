package com.rafbur.contoler;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rafbur.entity.Klasa;
import com.rafbur.entity.Nauczyciele;
import com.rafbur.entity.Przedmioty;
import com.rafbur.entity.Uzytkownicy;
import com.rafbur.service.NauczycielService;
import com.rafbur.service.PrzedmiotyService;
import com.rafbur.service.UserService;

@Controller
public class zarzadzaniaUzytkawnikami {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PrzedmiotyService przedmiotyService;
	
	@Autowired
	private NauczycielService nauczycielService;
	
	@ModelAttribute("uzytkownik")
	public Uzytkownicy constructUzytkownik() {
		return new Uzytkownicy();
	}
	
	@ModelAttribute("przedmiot")
	public Przedmioty constructPrzedmiot() {
		return new Przedmioty();
	}

	@ModelAttribute("nauczyciel")
	public Nauczyciele constructNauczyciel() {
		return new Nauczyciele();
	}
	
	@ModelAttribute("klasa")
	public Klasa constructKlasa() {
		return new Klasa();
	}
	
	
	@RequestMapping("zarzadzanieUzytkownikami")
	public String zarzadzanieUzytkownikami() {
		System.out.println("wypisuje zarzadzanieUzytkownikami");
		return "zarzadzanieUzytkownikami";
	}
	
	@RequestMapping("przypPrzedNaucz")
	public String przypPrzedNaucz() {
		System.out.println("wypisuje przypPrzedNaucz");
		return "przypPrzedNaucz";
	}
	
	@RequestMapping("dodaniePrzedmiotu")
	public String dodaniePrzedmiotu() {
		System.out.println("wypisuje dodaniePrzedmiotu");
		return "dodaniePrzedmiotu";
	}
	
	@RequestMapping("dodanieKlasy")
	public String dodanieKlasy() {
		System.out.println("wypisuje dodanieKlasy");
		return "dodanieKlasy";
	}
	
	
	
	@RequestMapping(value="/formularzDodatniaRoli", method=RequestMethod.POST)
	public String DodanieRoliUzytkownikowi(@Valid @ModelAttribute("uzytkownik") Uzytkownicy uzytkownik, BindingResult result,HttpSession sesja)
	{
		System.out.println("wchodzi w formularz dodania roli");
		userService.dodajRole(uzytkownik);
		sesja.setAttribute("uzytkownicyBezRoli", userService.znajdzNieaktywowanychUzytkownikow());

//		sesja.removeAttribute("nauczyciele");
		sesja.setAttribute("nauczyciele", userService.znajdzNauczycieli());
		return "redirect:/zarzadzanieUzytkownikami.html?success=true";
	}

	
	@RequestMapping(value="/formularzPrzypPrzedNaucz", method=RequestMethod.POST)
	public String formularzPrzypPrzedNaucz(@Valid @ModelAttribute("nauczyciel") Nauczyciele nauczyciel, BindingResult result,Principal principal , HttpSession sesja)
	{
//		do zmiennej login laduje z oddzielone spacja imie i nazwisko. Nastepnie w metodzinie znajdz uzytkownika partuje to wydobywajac
//		imie i nazwisko i za pomocy metody findByImieAndNazwisko znajduje login uzytkownika ktory dalej  wraz z nazwa przedmiotu 
//		przekazuje to metody dopiszPrzedmiotNauczycielelowi w metodzie tej pobieram Obiekt nauczyciel za pomoca metody findByLogin oraz
//		przedmiot za omoca metody findByNazwa gdzie w parametrze jest nazwa przedmiotu. Nastepnie pobieram wszystkie przedmioty
//		danego uzytkownika i dodaje do nich wczesniej znaleziony przedmiot. Kolejnym krokiem jest ustawienie dla obiektu nauczyciel
//		przedmiotow oraz aktualizacja rekorku nauczyciel w bazie danych
		String login = userService.znajdzNauczyciela(nauczyciel.getLogin());
		nauczycielService.dopiszPrzedmiotNauczycielowi(login,nauczyciel.getPrzedmiotyNauczycieli().get(0).getNazwa());
		sesja.setAttribute("przedmiotNauczyciela", nauczycielService.znajdzPrzedmioty(principal.getName()));
		return "redirect:/dodaniePrzedmiotu.html?success=true";
	}
	
	@RequestMapping(value="/formularzDodaniaPrzedmiotu", method=RequestMethod.POST)
	public String dodaniePRzedmiotu(@Valid @ModelAttribute("przedmiot") Przedmioty przedmiot, BindingResult result,HttpSession sesja)
	{
		przedmiotyService.dodajPrzedmiot(przedmiot.getNazwa());
		sesja.setAttribute("przedmioty", przedmiotyService.znajdzPrzedmioty());
		return "redirect:/dodaniePrzedmiotu.html?success=true";
	}
	
	@RequestMapping(value="/formularzDodaniaKlasy", method=RequestMethod.POST)
	public String dodanieKlasy(@Valid @ModelAttribute("klasa") Klasa klasa, BindingResult result,HttpSession sesja)
	{
		System.out.println("wypisuje formularz formularzDodaniaKlasy");
//		przedmiotyService.dodajPrzedmiot(przedmiot.getNazwa());
//		sesja.setAttribute("przedmioty", przedmiotyService.znajdzPrzedmioty());
		return "redirect:/formularzDodaniaKlasy.html?success=true";
	}
	
	

}
