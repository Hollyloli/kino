package com.rafbur.contoler;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rafbur.entity.Klasa;
import com.rafbur.entity.Oceny;
import com.rafbur.entity.Przedmioty;
import com.rafbur.entity.Uczniowie;
import com.rafbur.service.KlasaService;
import com.rafbur.service.NauczycielService;
import com.rafbur.service.OcenyService;
import com.rafbur.service.PrzedmiotyService;
import com.rafbur.service.UczniowieService;
import com.rafbur.service.UserService;

@Controller
public class OcenyControler {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NauczycielService nauczycielService;

	
	@Autowired
	private PrzedmiotyService przedmiotyService;
	
	@Autowired
	private OcenyService ocenyService;
	
	@Autowired
	private UczniowieService uczniowieService;
	
	@Autowired
	private KlasaService klasaService;
	
	@ModelAttribute("wspolne")
	public Polaczone2 constructWspolne() {
		return new Polaczone2();
	}
	
	@ModelAttribute("ocena")
	public Oceny constructOceny() {
		return new Oceny();
	}
	
	@RequestMapping("przedmiot-{id}")
	public String widokKlasIczynnosci(Model model,@PathVariable String id, Principal principal, HttpSession session) {
		session.setAttribute("nazwaPrzedmiotu", id);
		session.removeAttribute("ocenaKoncowa");
		model.addAttribute("nauczyciel",nauczycielService.znajdzKlasyIPrzedmiotNaucz(principal.getName(),id));
		return "wpisywanieOcen";
	}
	
	@RequestMapping("przedmiot-{id}/{id2}")
	public String widokUczenIczynnnosc(@PathVariable String id,@PathVariable String id2, HttpSession session) {
		session.removeAttribute("wpisanaOcena");
		return "wpisywanieOcen2";
	}
	
	@RequestMapping("przedmiot-{id}/{id2}/{id3}")
	public String widokOcenyIwagi(@PathVariable String id,@PathVariable String id2,@PathVariable String id3) {
		return "wpisywanieOcen3";
	}
	
	@RequestMapping(value="/formularzKlasIczynnosci", method=RequestMethod.POST)
	public String formularzKlasIczynnosci(@ModelAttribute("wspolne") Polaczone2 polaczone, BindingResult result, Model model,Principal principal,  HttpSession session) {
		//sprawdzaczy czy mozliwa jest edycja ocen
		//czyli czy wszysyc maja ocene koncowa jesli tak nie jest mozliwa edycja ocen
		String[] rokIsymbol = polaczone.getNauczyciel().getKlasaNauczyciel().get(0).getSymbol().split(" ");
		Integer rok = Integer.parseInt(rokIsymbol[0]);
		String symbol = rokIsymbol[1];
		if(klasaService.czyWszyscyMajaOcKoncowa((String) session.getAttribute("nazwaPrzedmiotu"),rok, symbol,"koncowa")) {
			//edycja ocen nie dostepna
			session.setAttribute("ocenaKoncowa", "ocenaKoncowa");
			if(polaczone.getWyborCZynnosci().equals("czynnosci zwiazane z podgladaniem ocen")) {
				Klasa klasa = klasaService.znajdzUczniowWKlasie((String) session.getAttribute("nazwaPrzedmiotu"),polaczone.getNauczyciel().getKlasaNauczyciel().get(0).getSymbol().split(" "));
				session.setAttribute("klasa", klasa);
			}
		}
		else {
			if(polaczone.getWyborCZynnosci().equals("czynnosci zwiazane z edycja ocen"))
			{
				Klasa klasa = klasaService.znajdzUczniowWKlasie((String) session.getAttribute("nazwaPrzedmiotu"),polaczone.getNauczyciel().getKlasaNauczyciel().get(0).getSymbol().split(" "));
				session.setAttribute("klasa", klasa);
			}
			else {
				Klasa klasa = klasaService.znajdzUczniowWKlasie((String) session.getAttribute("nazwaPrzedmiotu"),polaczone.getNauczyciel().getKlasaNauczyciel().get(0).getSymbol().split(" "));
				session.setAttribute("klasa", klasa);
			}
		}
		session.removeAttribute("ocenySemestr1");
		session.removeAttribute("ocenySemestr2");
		session.setAttribute("wybor", polaczone.getWyborCZynnosci().replace(" ", "_"));
		return "redirect:/przedmiot-" +session.getAttribute("nazwaPrzedmiotu")+ "/"+polaczone.getWyborCZynnosci().replace(" ", "_")+".html";
	}
	//to podgladania ocen
	@RequestMapping(value="/formularzWyswietlenieOcen", method=RequestMethod.POST)
	public String formularzWyswietlenieOcen(@ModelAttribute("ocena") Oceny ocena, BindingResult result, Model model, HttpSession session) {
		session.removeAttribute("ocenySemestr2");
		Klasa klasa = (Klasa)session.getAttribute("klasa");
		session.setAttribute("ocenySemestr1",klasaService.znajdzOcenyUczniowZroku(klasa,ocena.getRokNauki(),new Integer(1),(String)session.getAttribute("nazwaPrzedmiotu")));
		//sprwdzam czy kazdy z uczniow ma wpisana ocene koncowa na semestr jesli tak to wyswietlam tez 2 semestr
		if(ocenyService.CzyJestOcenaSemestr(klasa,ocena.getRokNauki(),new Integer(2),(String)session.getAttribute("nazwaPrzedmiotu"))) {
			session.setAttribute("ocenySemestr2",klasaService.znajdzOcenyUczniowZroku(klasa,ocena.getRokNauki(),new Integer(2),(String)session.getAttribute("nazwaPrzedmiotu")));
		}
		return "redirect:/przedmiot-"+session.getAttribute("nazwaPrzedmiotu")+"/"+session.getAttribute("wybor")+".html";
	}
	
	@RequestMapping(value="/formularzUczenIczynnnosc", method=RequestMethod.POST)
	public String formularzUczenIczynnnosc(@ModelAttribute("wspolne") Polaczone2 polaczone, BindingResult result, Model model, HttpSession session) {
		//w tym momencie nie wszyscy uczniowie maja wspiana ocene koncowa
		Przedmioty przedmiot = przedmiotyService.znajdzPrzedmiot((String)session.getAttribute("nazwaPrzedmiotu"));
		Uczniowie uczen = uczniowieService.znajdzUcznia(polaczone.getUczen().getImie().split(" "));
		Klasa klasa = (Klasa)session.getAttribute("klasa");
		if(uczniowieService.sprawdzCzyjestOcSemLubKon(uczen,przedmiot,klasa.getRok(),"semestralna")) {
			if(klasaService.czyWszyscyMajaOcKoncowa((String)session.getAttribute("nazwaPrzedmiotu"),klasa.getRok(), klasa.getSymbol(),"semestralna")) {
				if(uczniowieService.sprawdzCzyjestOcSemLubKon(uczen,przedmiot,klasa.getRok(),"koncowa")) {
					System.out.println("uczen ma wpisana ocene roczna");
					session.setAttribute("wpisanaOcena", "koncowa");
				}
				else {
					uczen = uczniowieService.znajdzUczniaZOcenami(uczen,przedmiot,klasa.getRok(),new Integer(2));
				}
			}
			else {
				System.out.println("uczen ma ocene semestralna");
				session.setAttribute("wpisanaOcena", "semestralna");
			}
		}
		else {
			System.out.println("uczen nie ma oceny semestralnej");
			uczen = uczniowieService.znajdzUczniaZOcenami(uczen,przedmiot,klasa.getRok(),new Integer(1));
		}
		session.setAttribute("uczen", uczen);
		session.setAttribute("wybor2", polaczone.getWyborCZynnosci().replace(" ", "_"));
		return "redirect:/przedmiot-"+session.getAttribute("nazwaPrzedmiotu")+"/"+session.getAttribute("wybor")+"/"+polaczone.getWyborCZynnosci().replace(" ", "_")+".html";
	}
	
	@RequestMapping(value="/wpisanieOceny", method=RequestMethod.POST)
	public String wpisywanieOcen(@ModelAttribute("ocena") Oceny ocena, BindingResult result, Model model, HttpSession session) {
		Uczniowie uczen = (Uczniowie) session.getAttribute("uczen");
		ocenyService.zapiszOcene(uczen,ocena,(String)session.getAttribute("nazwaPrzedmiotu"));
		return "redirect:/przedmiot-"+session.getAttribute("nazwaPrzedmiotu")+".html";
	}

	@RequestMapping(value="/edycjaOcen", method=RequestMethod.POST)
	public String edycjaOcen(@ModelAttribute("ocena") Oceny ocena, BindingResult result, Model model, HttpSession session) {
		Uczniowie uczen = (Uczniowie) session.getAttribute("uczen");
		ocenyService.zaaktualizujOCene(ocena);
		for(int i=0; i<uczen.getOceny().size(); i++) {
			if(uczen.getOceny().get(i).getIdOceny()==ocena.getIdOceny()) {
				uczen.getOceny().get(i).setOcena(ocena.getOcena());
				uczen.getOceny().get(i).setWagaOceny(ocena.getWagaOceny());
			}
		}
		session.setAttribute("uczen", uczen);
		return "redirect:/przedmiot-"+session.getAttribute("nazwaPrzedmiotu")+"/"+session.getAttribute("wybor")+"/"+session.getAttribute("wybor2")+".html";
	}
	@RequestMapping("usuniecieOceny/{id}")
	public String usuniecieOcen(@PathVariable int id, HttpSession session) {
		Uczniowie uczen = (Uczniowie) session.getAttribute("uczen");
		ocenyService.usunOcene(id,uczen,(String)session.getAttribute("nazwaPrzedmiotu"));
		for(int i=0; i<uczen.getOceny().size(); i++) {
			if(uczen.getOceny().get(i).getIdOceny()==id) {
				uczen.getOceny().remove(i);
			}
		}
		session.setAttribute("uczen", uczen);
		return "redirect:/przedmiot-"+session.getAttribute("nazwaPrzedmiotu")+"/"+session.getAttribute("wybor")+"/"+session.getAttribute("wybor2")+".html";
	}
	
	@RequestMapping(value="/wystawienieOcenyKoncowej", method=RequestMethod.POST)
	public String wystawienieOcenyKoncowej(@ModelAttribute("ocena") Oceny ocena, BindingResult result, Model model, HttpSession session) {
		session.setAttribute("uczen",ocenyService.wystawOceneKoncowa((Uczniowie) session.getAttribute("uczen"),ocena,(String)session.getAttribute("nazwaPrzedmiotu")));
		return "redirect:/przedmiot-"+session.getAttribute("nazwaPrzedmiotu")+"/"+session.getAttribute("wybor")+"/"+session.getAttribute("wybor2")+".html";
	}
}
