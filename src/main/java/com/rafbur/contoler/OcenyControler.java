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
import com.rafbur.entity.Nauczyciele;
import com.rafbur.entity.Oceny;
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
		System.out.println("wpisuje ocene");
		System.out.println("wypisuje id1234 " +id);
		session.setAttribute("nazwaPrzedmiotu", id);
		model.addAttribute("nauczyciel",nauczycielService.znajdzKlasyIPrzedmiotNaucz(principal.getName(),id));
		return "wpisywanieOcen";
	}
	
	@RequestMapping("przedmiot-{id}/{id2}")
	public String widokUczenIczynnnosc(@PathVariable String id,@PathVariable String id2) {
		return "wpisywanieOcen2";
	}
	
	@RequestMapping("przedmiot-{id}/{id2}/{id3}")
	public String widokOcenyIwagi(@PathVariable String id,@PathVariable String id2,@PathVariable String id3) {
		return "wpisywanieOcen3";
	}
	
	@RequestMapping(value="/formularzKlasIczynnosci", method=RequestMethod.POST)
	public String formularzKlasIczynnosci(@ModelAttribute("wspolne") Polaczone2 polaczone, BindingResult result, Model model,Principal principal,  HttpSession session) {
		if(polaczone.getWyborCZynnosci().equals("czynnosci zwiazane z edycja ocen"))
		{
//			Nauczyciele nauczyciel2 = nauczycielService.znajdzUczniowKlasyIPrzedmiot(principal.getName(),(String) session.getAttribute("nazwaPrzedmiotu"),polaczone.getNauczyciel().getKlasaNauczyciel().get(0).getSymbol().split(" "));
//			session.setAttribute("nauczyciel2", nauczyciel2);
			Klasa klasa = klasaService.znajdzUczniowWKlasie((String) session.getAttribute("nazwaPrzedmiotu"),polaczone.getNauczyciel().getKlasaNauczyciel().get(0).getSymbol().split(" "));
			session.setAttribute("klasa", klasa);
		}
		else {
			Klasa klasa = klasaService.znajdzUczniowWKlasie((String) session.getAttribute("nazwaPrzedmiotu"),polaczone.getNauczyciel().getKlasaNauczyciel().get(0).getSymbol().split(" "));
			session.setAttribute("klasa", klasa);
			
		}
		
		session.removeAttribute("ocenySemestr1");
		session.removeAttribute("ocenySemestr2");
		session.setAttribute("wybor", polaczone.getWyborCZynnosci().replace(" ", "_"));
		return "redirect:/przedmiot-" +session.getAttribute("nazwaPrzedmiotu")+ "/"+polaczone.getWyborCZynnosci().replace(" ", "_")+".html";
	}
	@RequestMapping(value="/formularzWyswietlenieOcen", method=RequestMethod.POST)
	public String formularzWyswietlenieOcen(@ModelAttribute("ocena") Oceny ocena, BindingResult result, Model model, HttpSession session) {
		session.setAttribute("ocenySemestr1",klasaService.znajdzOcenyUczniowZroku((Klasa)session.getAttribute("klasa"),ocena.getRokNauki(),1,(String)session.getAttribute("nazwaPrzedmiotu")));
		//sprwdzam czy kazdy z uczniow ma wpisana ocene koncowa na semestr jesli tak to wyswietlam tez 2 semestr
		if(ocenyService.CzyJestOcenaRoczna((Klasa)session.getAttribute("klasa"),ocena.getRokNauki(),new Integer(2),(String)session.getAttribute("nazwaPrzedmiotu"))) {
			session.setAttribute("ocenySemestr2",klasaService.znajdzOcenyUczniowZroku((Klasa)session.getAttribute("klasa"),ocena.getRokNauki(),new Integer(2),(String)session.getAttribute("nazwaPrzedmiotu")));
		}
		return "redirect:/przedmiot-"+session.getAttribute("nazwaPrzedmiotu")+"/"+session.getAttribute("wybor")+".html";
	}
	
	@RequestMapping(value="/formularzUczenIczynnnosc", method=RequestMethod.POST)
	public String formularzUczenIczynnnosc(@ModelAttribute("wspolne") Polaczone2 polaczone, BindingResult result, Model model, HttpSession session) {
		Uczniowie uczen=null;
		if(polaczone.getWyborCZynnosci().equals("wpisywanie oceny")) {
			uczen = uczniowieService.znajdzUcznia(polaczone.getUczen().getImie().split(" "));
		}
		else if(polaczone.getWyborCZynnosci().equals("edycja oceny")) {
			Klasa klasa = (Klasa)session.getAttribute("klasa");
			uczen = uczniowieService.znajdzUczniaZOcenami(polaczone.getUczen().getImie().split(" "),(String)session.getAttribute("nazwaPrzedmiotu"));
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
		System.out.println("wupisuje id oceny " + ocena.getIdOceny());
		
		System.out.println("wupisuje ocene " + ocena.getOcena());
		
		System.out.println("wupisuje wage " + ocena.getWagaOceny());
		
		ocenyService.zaaktualizujOCene((Uczniowie) session.getAttribute("uczen"),ocena,(String)session.getAttribute("nazwaPrzedmiotu"));
		
//		Uczniowie uczen = (Uczniowie) session.getAttribute("uczen");
//		ocenyService.zapiszOcene(uczen,ocena,(String)session.getAttribute("nazwaPrzedmiotu"));
		
		return "redirect:/przedmiot-"+session.getAttribute("nazwaPrzedmiotu")+"/"+session.getAttribute("wybor")+"/"+session.getAttribute("wybor2")+".html";
	}
}
