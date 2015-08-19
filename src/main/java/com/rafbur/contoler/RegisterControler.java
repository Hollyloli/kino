package com.rafbur.contoler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rafbur.service.UserService;


@Controller
public class RegisterControler {
	
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("polaczone")
	public Polaczone constructUser() {
		return new Polaczone();
	}
	

	public RegisterControler() {
		System.out.println("Konstruktor registerContoler");
	}
	
	@RequestMapping("rejestracja")
	public String rejestracja(){
		System.out.println("dupa rejestracja");
		return "rejestracja";
	}
	
	@RequestMapping(value="/rejestracja", method=RequestMethod.POST)
	public String rejestrowanie(@Valid @ModelAttribute("polaczone") Polaczone polaczeone, BindingResult result)
	{
		System.out.println("wypisuje result.has");
		if(result.hasErrors()) {
			result.getAllErrors();
			System.out.println("wypisuje error" + result.getAllErrors());
			return "rejestracja";
		}
		System.out.println("wchodzi w rejestrowanie");
		System.out.println("wypisuje imie "+ polaczeone.getUzytkownicy().getImie());
		
		userService.save(polaczeone);
		return "redirect:/rejestracja.html?success=true";
	}
}
