package com.rafbur.contoler;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rafbur.entity.Uzytkownicy;
import com.rafbur.service.AdresService;
import com.rafbur.service.KontaktyService;
import com.rafbur.service.UserService;

@Controller
public class EdycjaKontaControler {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdresService adresService;
	
	@Autowired
	private KontaktyService kontaktyService;
	
	@ModelAttribute("polaczone")
	public Uzytkownicy constructUser() {
		return new Uzytkownicy();
	}
	
	@ModelAttribute("polaczone2")
	public Uzytkownicy constructUser2() {
		return new Uzytkownicy();
	}
	
	@RequestMapping("edycjaKonta")
	public String EdycjaKonta(Model model,Principal principal) {
		model.addAttribute("uzytkownik",userService.znajdUzytkownika(principal.getName()));
		return "edycjaKonta";
	}
	
	@RequestMapping(value="/edycjaKonta", method=RequestMethod.POST)
	public String rejestrowanie(@Valid @ModelAttribute("polaczone") Uzytkownicy uzytkownik, BindingResult result, Model model,Principal principal)
	{
		if(result.hasErrors()) {
			model.addAttribute("uzytkownik",userService.znajdUzytkownika(principal.getName()));
			return "edycjaKonta";
		}
		userService.aktualizuj(uzytkownik,principal.getName());
		return "redirect:/edycjaKonta.html?success=true";
	}
	
	
	@RequestMapping("/adres/remove/{id}")
	public String removeAdres(@PathVariable int id, Principal principal) {
		adresService.delete(id,principal.getName());
		return"redirect:/edycjaKonta.html";
	}
	
	@RequestMapping(value="/edycjaKonta2", method=RequestMethod.POST)
	public String dodajAdres(@Valid @ModelAttribute("polaczone2") Uzytkownicy uzytkownik,BindingResult result, Model model,Principal principal) {
		if(result.hasErrors())
		{
			EdycjaKonta(model, principal);
			return "edycjaKonta";
		}
		adresService.save(uzytkownik,principal.getName());
		return "redirect:/edycjaKonta.html";
	}
	
	@RequestMapping("/kontakty/remove/{id}")
	public String removeKontakt(@PathVariable int id, Principal principal) {
		kontaktyService.delete(id,principal.getName());
		return"redirect:/edycjaKonta.html";
	}
	
	@RequestMapping(value="/edycjaKonta3", method=RequestMethod.POST)
	public String dodajKontakt(@Valid @ModelAttribute("polaczone") Uzytkownicy uzytkownik,BindingResult result, Model model,Principal principal) {
		if(result.hasErrors())
		{
			EdycjaKonta(model, principal);
			return "edycjaKonta";
		}
		kontaktyService.save(uzytkownik,principal.getName());
		return "redirect:/edycjaKonta.html";
	}
}
