package com.rafbur.contoler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





import com.rafbur.entity.Adresy;
import com.rafbur.entity.Kontakty;
import com.rafbur.entity.Uzytkownicy;
import com.rafbur.service.UserService;


@Controller
public class RegisterControler {
	
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("uzytkownik")
	public Uzytkownicy constructUser() {
		return new Uzytkownicy();
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
	public String rejestrowanie(@ModelAttribute("uzytkownik") Uzytkownicy user)
	{
		System.out.println("wchodzi w rejestrownie");
		System.out.println("wypisuje haslo "+ user.getHaslo());
//		userService.save(user);
		return "rejestracja";
	}
}
