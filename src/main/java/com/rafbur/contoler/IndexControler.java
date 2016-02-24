package com.rafbur.contoler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rafbur.service.UserService;

@Controller
public class IndexControler {
	
	@Autowired
	private UserService userService;
	

	
	@RequestMapping("/index")
	public String index(SecurityContextHolderAwareRequestWrapper rolaUyztkownika,HttpSession sesja) {
		if(rolaUyztkownika.isUserInRole("ROLE_NAUCZYCIEL")) {
//			sesja.setAttribute("przedmiotNauczyciela", nauczycielService.znajdzPrzedmioty(rolaUyztkownika.getUserPrincipal().getName()));
		}
		if(rolaUyztkownika.isUserInRole("ROLE_DYREKTOR")) {
		//	rolaUyztkownika.getSession().setAttribute("uzytkownicyBezRoli", userService.znajdzNieaktywowanychUzytkownikow());
		//	sesja.setAttribute("nauczyciele", userService.znajdzNauczycieli());
//			sesja.setAttribute("przedmioty", przedmiotyService.znajdzPrzedmioty());
		}
		if(rolaUyztkownika.isUserInRole("ROLE_OPIEKUN")) {
//			sesja.setAttribute("dzieciPodOpieka", opiekunowieService.znajdzDzieciOpiekuna(rolaUyztkownika.getUserPrincipal().getName()));
		}
		return "index";
	}
}
