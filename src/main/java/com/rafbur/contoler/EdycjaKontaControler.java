package com.rafbur.contoler;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rafbur.service.UserService;

@Controller
public class EdycjaKontaControler {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("polaczone")
	public Polaczone constructUser() {
		return new Polaczone();
	}
	
	@RequestMapping("edycjaKonta")
	public String EdycjaKonta(Model model,Principal principal) {
		System.out.println("wypisuje edycja konta");
		System.out.println("wypisuje uczestnika " + principal.getName());
		model.addAttribute("uzytkownik",userService.znajdUzytkownika(principal.getName()));
		return "edycjaKonta";
	}
	
	@RequestMapping(value="/edycjaKonta", method=RequestMethod.POST)
	public String rejestrowanie(@Valid @ModelAttribute("polaczone") Polaczone polaczeone, BindingResult result, Principal principal)
	{
		System.out.println(" wypisuje najwazniejsza rzecz " + polaczeone.getAdresy().getUzytkownicy().get(0).getImie());
		System.out.println("wypisuje rezultat adresy.miasto " +result.getFieldValue("adresy.miasto"));
		if(result.hasErrors()  ) {
//			result.getAllErrors();
			System.out.println("wypisuje error" + result.getAllErrors());
			return "edycjaKonta";
		}
		System.out.println("wchodzi w edycja konta");
		System.out.println("wypisuje imie "+ polaczeone.getAdresy().getMiasto());
		
		userService.aktualizuj(polaczeone,principal.getName());
		return "redirect:/edycjaKonta.html?success=true";
	}
}
