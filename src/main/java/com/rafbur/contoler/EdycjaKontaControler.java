package com.rafbur.contoler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rafbur.service.UserService;

@Controller
public class EdycjaKontaControler {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("edycjaKonta")
	public String EdycjaKonta(Model model) {
		System.out.println("wypisuje edycja konta");
		model.addAttribute("uzytkownicy",userService.znajdUzytkownika());
		return "edycjaKonta";
	}
	
}
