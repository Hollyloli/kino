package com.rafbur.contoler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rafbur.entity.Uzytkownicy;
import com.rafbur.service.UserService;


@Controller
public class RegisterControler {
	
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("uczen")
	public Uzytkownicy stworzUcznia() {
		return new Uzytkownicy();
	}
	
	@RequestMapping("rejestracja")
	public String rejestracja(){
		return "rejestracja";
	}
	
	@RequestMapping(value="/rejestracja", method=RequestMethod.POST)
	public String rejestrowanie(@Valid @ModelAttribute("uczen") Uzytkownicy uzytkownik, BindingResult wynik) {
		if(wynik.hasErrors()) {
			return "rejestracja";
		}
		userService.zarejestruj(uzytkownik);
		return "redirect:/rejestracja.html?success=true";
	}
}
