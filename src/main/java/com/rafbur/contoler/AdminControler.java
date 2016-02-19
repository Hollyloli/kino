package com.rafbur.contoler;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rafbur.entity.Filmy;
import com.rafbur.service.FilmyService;



@Controller
public class AdminControler {

	@Autowired
	private FilmyService filmyService;

	
	@RequestMapping("dodanieFilmu")
	public String dodaniePrzedmiotu() {
		return "dodanieFilmu";
	}
	
	@ModelAttribute("film")
	public Filmy constructFilm() {
		return new Filmy();
	}
	
	@RequestMapping(value="/formularzDodaniaFilmu", method=RequestMethod.POST)
	public String dodaniePrzedmiotu(@Valid @ModelAttribute("film") Filmy film, BindingResult result,HttpSession sesja)
	{
		if(result.hasErrors()) {
			System.out.println("ten przedmiot juz istnieje");
			return "dodanieFilmu";
		}
		filmyService.dodajFilm(film.getTytulFilmu(),film.getDlugsc());
//		sesja.setAttribute("przedmioty", przedmiotyService.znajdzPrzedmioty());
		return "redirect:/dodanieFilmu.html?success=true";
	}
}
