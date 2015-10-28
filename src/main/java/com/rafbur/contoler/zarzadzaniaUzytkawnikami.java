package com.rafbur.contoler;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import com.rafbur.entity.Klasa;
import com.rafbur.entity.Nauczyciele;
import com.rafbur.entity.Przedmioty;
import com.rafbur.entity.Uczniowie;
import com.rafbur.entity.Uzytkownicy;
import com.rafbur.service.KlasaService;
import com.rafbur.service.NauczycielService;
import com.rafbur.service.PrzedmiotyService;
import com.rafbur.service.UczniowieService;
import com.rafbur.service.UserService;

@Controller
public class zarzadzaniaUzytkawnikami {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PrzedmiotyService przedmiotyService;
	
	@Autowired
	private NauczycielService nauczycielService;
	
	@Autowired
	private KlasaService klasaService;
	
	@Autowired
	private UczniowieService uczniowieService;
	
	@ModelAttribute("uzytkownik")
	public Uzytkownicy constructUzytkownik() {
		return new Uzytkownicy();
	}
	
	@ModelAttribute("przedmiot")
	public Przedmioty constructPrzedmiot() {
		return new Przedmioty();
	}
	
	@ModelAttribute("uczen")
	public Uczniowie constructUczen() {
		return new Uczniowie();
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
		return "zarzadzanieUzytkownikami";
	}
	
	@RequestMapping("przypPrzedNaucz")
	public String przypPrzedNaucz(Model model) {
		model.addAttribute("klasy", klasaService.znjadzWszyskieKlasy());
		model.addAttribute("nauczyciele", userService.znajdzNauczycieli());
		return "przypPrzedNaucz";
	}
	
	@RequestMapping("dodaniePrzedmiotu")
	public String dodaniePrzedmiotu() {
		return "dodaniePrzedmiotu";
	}
	
	@RequestMapping("dodanieKlasy")
	public String dodanieKlasy() {
		return "dodanieKlasy";
	}
	@RequestMapping("zakonczenieRokuSzkolnego")
	public String zakonczenieRokuSzkolnego(Model model) {
		
		List<Klasa> klasy = klasaService.znjadzWszyskieKlasy();
		model.addAttribute("klasy", klasy);
		model.addAttribute("statusOcen", klasaService.statusOcenPodKoniecRoku(klasy));
		return "zakonczenieRokuSzkolnego";
	}
	
	
	@RequestMapping("przypPrzedUczn")
	public String przypPrzedUczn(Model model) {
		model.addAttribute("uczniowie", uczniowieService.znajdzWszystkichUczniow());
		model.addAttribute("przedmioty", przedmiotyService.znajdzPrzedmioty());
		return "przypPrzedUczn";
	}
	
	
	@RequestMapping("dodanieUczniaDoKlasy")
	public String dodanieUczniaDoKlasy(Model model) {
		model.addAttribute("uczniowie", uczniowieService.znajdzUczniowBezKlasy());
		model.addAttribute("klasy", klasaService.znjadzWszyskieKlasy());
		return "dodanieUczniaDoKlasy";
	}
	
	
	@RequestMapping(value="/formularzDodatniaRoli", method=RequestMethod.POST)
	public String DodanieRoliUzytkownikowi(@Valid @ModelAttribute("uzytkownik") Uzytkownicy uzytkownik, BindingResult result,HttpSession sesja)
	{
		userService.dodajRole(uzytkownik);
		sesja.setAttribute("uzytkownicyBezRoli", userService.znajdzNieaktywowanychUzytkownikow());
//		po co to ?
//		sesja.setAttribute("nauczyciele", userService.znajdzNauczycieli());
		return "redirect:/zarzadzanieUzytkownikami.html?success=true";
	}
	
	@RequestMapping(value="/formularzZakonczeniaRoku", method=RequestMethod.POST)
	public String formularzZakonczeniaRoku(@Valid @ModelAttribute("uzytkownik") Uzytkownicy uzytkownik, BindingResult result,HttpSession sesja)
	{
		klasaService.zakonczRokSzkolny();
		sesja.removeAttribute("ocenySemestr2");
		return "redirect:/zakonczenieRokuSzkolnego.html?success=true";
	}
	
	
	@RequestMapping(value="/formularzPrzypPrzedNaucz", method=RequestMethod.POST)
	public String formularzPrzypPrzedNaucz(@Valid @ModelAttribute("nauczyciel") Nauczyciele nauczyciel, BindingResult result,Principal principal , HttpSession sesja)
	{
		System.out.println("wypisuje przypozadkowanie przedmiotu Naucz");
//		do zmiennej login laduje z oddzielone spacja imie i nazwisko. Nastepnie w metodzinie znajdz uzytkownika partuje to wydobywajac
//		imie i nazwisko i za pomocy metody findByImieAndNazwisko znajduje login uzytkownika ktory dalej  wraz z nazwa przedmiotu 
//		przekazuje to metody dopiszPrzedmiotNauczycielelowi w metodzie tej pobieram Obiekt nauczyciel za pomoca metody findByLogin oraz
//		przedmiot za omoca metody findByNazwa gdzie w parametrze jest nazwa przedmiotu. Nastepnie pobieram wszystkie przedmioty
//		danego uzytkownika i dodaje do nich wczesniej znaleziony przedmiot. Kolejnym krokiem jest ustawienie dla obiektu nauczyciel
//		przedmiotow oraz aktualizacja rekorku nauczyciel w bazie danych
		String login = userService.znajdzNauczyciela(nauczyciel.getLogin());
		String[] rokIsymbol = nauczyciel.getKlasaNauczyciel().get(0).getSymbol().split(" ");
		Integer rok = Integer.parseInt(rokIsymbol[0]);
		String symbol = rokIsymbol[1];
		nauczycielService.dopiszPrzedmiotNauczycielowi(login,nauczyciel.getPrzedmiotyNauczycieli().get(0).getNazwa(),rok,symbol);
		sesja.setAttribute("przedmiotNauczyciela", nauczycielService.znajdzPrzedmioty(principal.getName()));
		return "redirect:/przypPrzedNaucz.html?success=true";
	}
	
	@RequestMapping(value="/formularzPrzypPrzedUczniom", method=RequestMethod.POST)
	public String formularzprzypPrzedUczn(@Valid @ModelAttribute("uczen") Uczniowie uczen, BindingResult result,Principal principal , HttpSession sesja)
	{
		String login = userService.znajdzNauczyciela(uczen.getLogin());
		uczniowieService.dopiszPrzedmiotUcznowi(login,uczen.getPrzedmioty().get(0).getNazwa());
		return "redirect:/przypPrzedUczn.html?success=true";
	}
	
	@RequestMapping(value="/formularzDodaniaPrzedmiotu", method=RequestMethod.POST)
	public String dodaniePrzedmiotu(@Valid @ModelAttribute("przedmiot") Przedmioty przedmiot, BindingResult result,HttpSession sesja)
	{
		if(result.hasErrors()) {
			System.out.println("ten przedmiot juz istnieje");
			return "dodaniePrzedmiotu";
		}
		przedmiotyService.dodajPrzedmiot(przedmiot.getNazwa());
		sesja.setAttribute("przedmioty", przedmiotyService.znajdzPrzedmioty());
		return "redirect:/dodaniePrzedmiotu.html?success=true";
	}
	
	@RequestMapping(value="/formularzDodaniaKlasy", method=RequestMethod.POST)
	public String dodanieKlasy(@Valid @ModelAttribute("klasa") Klasa klasa, BindingResult result,HttpSession sesja)
	{
		if(result.hasErrors()) {
			return "dodanieKlasy";
		}
		klasaService.dodajKlase(klasa);
		return "redirect:/dodanieKlasy.html?success=true";
	}
	
	@RequestMapping(value="/formularzUczniaDoKlasy", method=RequestMethod.POST)
	public String formularzDodaniaUczniaDoKlasy(@Valid @ModelAttribute("uczen") Uczniowie uczen, BindingResult result,HttpSession sesja)
	{
		klasaService.dodajUcznia(uczen);
		return "redirect:/dodanieUczniaDoKlasy.html?success=true";
	}
}
