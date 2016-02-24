package com.rafbur.contoler;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rafbur.entity.Filmy;
import com.rafbur.entity.Sala;
import com.rafbur.entity.Seans;
import com.rafbur.service.FilmyService;
import com.rafbur.service.SalaService;
import com.rafbur.service.SeansService;



@Controller
public class AdminControler {

	@Autowired
	private FilmyService filmyService;

	@Autowired
	private SalaService salaService;
	
	@Autowired
	private SeansService seansService;
	
	@RequestMapping("dodanieFilmu")
	public String dodaniePrzedmiotu() {
		return "dodanieFilmu";
	}
	
	@ModelAttribute("film")
	public Filmy constructFilm() {
		return new Filmy();
	}
	
	@RequestMapping("znalezieniaSali")
	public String znalezieniaSali(Model model) {
		model.addAttribute("filmy", filmyService.znajdzFilmy());
		return "znalezieniaSali";
	}
	
	@RequestMapping("dodanieSeansu")
	public String dodanieSeansu(Model model) {
		return "dodanieSeansu";
	}
	
	
	
	@ModelAttribute("seans")
	public Seans constructSeans() {
		return new Seans();
	}
	
	@RequestMapping("dodanieSali")
	public String dodanieSali() {
		return "dodanieSali";
	}
	
	@ModelAttribute("sala")
	public Sala constructSala() {
		return new Sala();
	}
	
	
	@RequestMapping(value="/formularzDodaniaFilmu", method=RequestMethod.POST)
	public String dodanieFilmu(@Valid @ModelAttribute("film") Filmy film, BindingResult result,HttpSession sesja)
	{
		if(result.hasErrors()) {
			return "dodanieFilmu";
		}
		filmyService.dodajFilm(film.getTytulFilmu(),film.getDlugsc());
//		sesja.setAttribute("przedmioty", przedmiotyService.znajdzPrzedmioty());
		return "redirect:/dodanieFilmu.html?success=true";
	}
	
	@RequestMapping(value="/formularzZnalezieniaSali", method=RequestMethod.POST)
	public String formularzznalezieniaSali(@Valid @ModelAttribute("seans") Seans seans, BindingResult result,HttpSession sesja)
	{
		if(result.hasErrors()) {
		//	System.out.println("ten przedmiot juz istnieje "+ result.getAllErrors());
			return "dodanieSeansu";
		}
		sesja.setAttribute("sale", seansService.znajdzSale(seans));
		sesja.setAttribute("seans", seans);
		return "redirect:/dodanieSeansu.html";
	}
	@RequestMapping(value="/formularzDodaniaSeansu", method=RequestMethod.POST)
	public String formularzDodaniaSeansu(@Valid @ModelAttribute("sala") Sala sala, BindingResult result,HttpSession sesja)
	{
	
		Seans seans = (Seans) sesja.getAttribute("seans");
		System.out.println(((Filmy)seans.getFilm()).getTytulFilmu());
		seansService.dodajSeans(sala.getNazwaSali(),seans);
		
//		sesja.setAttribute("przedmioty", przedmiotyService.znajdzPrzedmioty());
		return "redirect:/dodanieSeansu.html?success=true";
	}
	
	
	@RequestMapping(value="/formularzDodaniaSali", method=RequestMethod.POST)
	public String formularzDodaniaSali(@Valid @ModelAttribute("sala") Sala sala, BindingResult result,HttpSession sesja)
	{
		if(result.hasErrors()) {
			return "dodanieSali";
		}
		salaService.dodajSale(sala);
//		sesja.setAttribute("przedmioty", przedmiotyService.znajdzPrzedmioty());
		return "redirect:/dodanieSali.html?success=true";
	}
	
}
